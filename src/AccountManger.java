import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManger extends Account implements UserOperation
{
    private final String accountType = "Manager Account";

    public AccountManger(String userId, String userPass)
    {
        super(userId,userPass);
    }

    public AccountManger(String userId, String userPass, String userName)
    {
        super(userId,userPass,userName);
    }
    @Override
    void print()
    {
        System.out.println("==========================");
        System.out.printf("%12s : %s%n","User Name"  , super.getUserName());
        System.out.printf("%12s : %s%n","User Id"    , super.getUserPass());
        System.out.printf("%12s : %s%n","AccountType", this.accountType);
        System.out.println("==========================");
    }
    @Override
    public void addNewUser(DataBase dataBase, Scanner scanner, Address address, PhoneNumber phoneNumber)
    {
        System.out.println("Please input User Name:");
        String name = scanner.next();
        System.out.println("Please input User id:");
        String id = scanner.next();
        System.out.println("Please input User password:");
        String password = scanner.next();

        System.out.println("Please input E-mail ID:");
        String email = scanner.next();

        System.out.println("Please input phone number");
        phoneNumber.create(scanner);
        System.out.println("Please input Address");
        address.create(scanner);
        System.out.println("Please input User balance:");
        Double balance = 0.0;
        for(;true;)
        {
            try
            {
                balance= scanner.nextDouble();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("please input a Number:");
                scanner.next();
            }
        }

        AccountCustomerPersonal newUser = new AccountCustomerPersonal(id, password, name, balance);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setEmail(email);
        newUser.setAddress(address);
        dataBase.perAccountList.add(newUser);
        newUser.print();
    }

    @Override
    public void deleteUser(String id, DataBase dataBase)
    {
        Account deleteAccount = null;
        for(int i = 0; i < dataBase.perAccountList.size(); i++)
        {
            if(dataBase.perAccountList.get(i).getUserId().equals(id))
            {
                deleteAccount = dataBase.perAccountList.get(i);
                break;
            }
        }
        if(deleteAccount != null)
        {
            deleteAccount.delete();
            System.out.println("success delete User: " + id);
        }
        else
        {
            System.out.println("can not find user: " + id);
        }
    }

    @Override
    public void editUser(String id, DataBase dataBase, Scanner scanner)
    {
        Account targetAccount = searchUser(id,dataBase);
        if(targetAccount != null)
        {
            System.out.println("Please select the which one you want to edit?\n 1.Address\n 2.phone Number\n 3.Email ID");
            int choose = -1;
            for(;true;)
            {
                try
                {
                    choose= scanner.nextInt();
                    if(choose == 1 || choose == 2 || choose == 3)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("You enter a wrong number, please try again\n");
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Please input a number, try again\n");
                    scanner.next();
                }
            }

            if(choose == 1)
            {
                Address address = new Address();
                address.create(scanner);
                ((AccountCustomerPersonal)targetAccount).setAddress(address);
            }

            else if(choose == 2)
            {
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.create(scanner);
                ((AccountCustomerPersonal)targetAccount).setPhoneNumber(phoneNumber);
            }
            else
            {
                System.out.println("Please input new Email Id:");
                ((AccountCustomerPersonal)targetAccount).setEmail(scanner.next());
            }

            System.out.println("User Info Update Successful\n");
            targetAccount.print();
        }
    }

    public Account searchUser(String id, DataBase dataBase)
    {
        for(int i = 0; i < dataBase.perAccountList.size(); i++)
        {
            if(dataBase.perAccountList.get(i).getUserId().equals(id))
            {
                dataBase.perAccountList.get(i).print();
                return dataBase.perAccountList.get(i);
            }
        }
        System.out.println("can not find user: " + id);
        return null;
    }

    @Override
    public void listUsers(DataBase dataBase)
    {
        for(int i = 0; i < dataBase.perAccountList.size(); i++)
        {
            if(dataBase.perAccountList.get(i).isDelete() == false)
            {
                dataBase.perAccountList.get(i).print();
            }
        }
    }
}

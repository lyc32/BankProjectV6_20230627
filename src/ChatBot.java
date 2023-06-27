import java.util.InputMismatchException;
import java.util.Scanner;

public class ChatBot
{
    public ChatBot(DataBase dataBase)
    {
        System.out.println("Welcome to AB bank.");
        Scanner scanner = new Scanner(System.in);
        Account tmpAccount = null;
        int type = -1;

        while (true)
        {
            for(;true;)
            {
                // not login
                if(tmpAccount == null)
                {
                    for(;true;)
                    {
                        System.out.println("Please select your Account Type:\n 1 for personal\n 2.for business\n 3.for Manager");
                        try
                        {
                            type = scanner.nextInt();
                            if(type == 1 || type == 2 || type == 3)
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
                    // login
                    System.out.println("Please enter your Account Id:");
                    String id = scanner.next();
                    System.out.println("Please enter your password:");
                    String password = scanner.next();

                    if(type == 1)
                    {
                        tmpAccount = new AccountCustomerPersonal(id,password);
                        tmpAccount = tmpAccount.login(DataBase.perAccountList);
                    }
                    else if(type == 2)
                    {
                        tmpAccount = new AccountCustomerBusiness(id,password);
                        tmpAccount = tmpAccount.login(DataBase.busAccountList);
                    }
                    else
                    {
                        tmpAccount = new AccountManger(id,password);
                        tmpAccount = tmpAccount.login(DataBase.magAccountList);
                    }

                    if(tmpAccount == null)
                    {
                        tmpAccount = null;
                        String tryAgain = scanner.next();
                        if(tryAgain.equals("No"))
                        {
                            System.exit(0);
                        }
                    }
                    else
                    {
                        tmpAccount.print();
                    }
                }

                // if login success, then continue
                // else break;
                if(tmpAccount == null)
                {
                    break;
                }

                if(type == 1)
                {
                    System.out.println("Do you want to check your Balance?\nEnter 'Yes' to check");
                    if(("Yes").equals(scanner.next()))
                    {
                        ((AccountCustomerPersonal) tmpAccount).getBalance();
                    }
                    break;
                }
                else if(type == 2)
                {
                    System.out.println("Do you want to check your Balance?\nEnter 'Yes' to check");
                    if(("Yes").equals(scanner.next()))
                    {
                        ((AccountCustomerBusiness) tmpAccount).getBalance();
                    }
                    break;
                }
                else
                {
                    int choose;
                    for(;true;)
                    {
                        System.out.println("What you want to do?\n 1.add new user\n 2.delete user\n 3.search user\n 4.edit user\n 5.list all users");
                        try
                        {
                            choose= scanner.nextInt();
                            if(choose == 1 || choose == 2 || choose == 3 || choose == 4 || choose == 5)
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
                        ((AccountManger) tmpAccount).addNewUser(dataBase,scanner, new Address(), new PhoneNumber());
                    }
                    else if(choose == 3)
                    {
                        System.out.println("please input User ID:");
                        String userId = scanner.next();
                        ((AccountManger) tmpAccount).searchUser(userId, dataBase);
                    }
                    else if(choose == 4)
                    {
                        System.out.println("please input User ID:");
                        String userId = scanner.next();
                        ((AccountManger) tmpAccount).editUser(userId, dataBase, scanner);
                    }
                    else if(choose == 5)
                    {
                        ((AccountManger) tmpAccount).listUsers(dataBase);
                    }
                    else
                    {
                        System.out.println("please input User ID:");
                        String deleteId = scanner.next();
                        ((AccountManger) tmpAccount).deleteUser(deleteId,dataBase);
                    }
                    break;
                }
            }

            // when login success, then ask for logout.
            if(tmpAccount != null)
            {
                System.out.println("Do you want to logout or continue? \nEnter Yes to logout");
                if(("Yes").equals(scanner.next()))
                {
                    tmpAccount = null;
                    type = -1;
                    System.out.println("Do you want to Exit? \nEnter Yes to Exit.");
                    if(scanner.next().equals("Yes"))
                    {
                        break;
                    }
                }
            }
        }
    }
}

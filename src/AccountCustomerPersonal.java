public class AccountCustomerPersonal extends Account implements CheckBalance, SetAddress, SetUserDetail
{
    private final String accountType = "Personal Account";
    private double balance;
    private Address address;
    private String email;
    private PhoneNumber phoneNumber;

    public AccountCustomerPersonal(String userId, String userPass)
    {
        super(userId,userPass);
    }

    public AccountCustomerPersonal(String userId, String userPass, String userName, double balance)
    {
        super(userId,userPass,userName);
        this.balance = balance;
    }

    @Override
    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public void setAddress(String address)
    {
        System.out.println("This is a Personal Account, please use [void setAddress(Address address)]");
    }

    @Override
    public String getAddress()
    {
        return this.address.getAddress();
    }

    @Override
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public double getBalance()
    {
        System.out.println("\nyour account balance is: " + this.balance + "\n");
        return this.balance;
    }

    @Override
    void print()
    {

        System.out.println("\n==========================");
        System.out.printf("%12s : %s%n","User Name"  , super.getUserName());
        System.out.printf("%12s : %s%n","User Id"    , super.getUserId());
        System.out.printf("%12s : %s%n","AccountType", this.accountType);
        if(super.isDelete())
        {
            System.out.printf("%12s : %s%n","State", "Suspended");
        }
        else
        {
            System.out.printf("%12s : %s%n","State", "Activated");
        }
        System.out.println("==========================");
        System.out.println("[Phone]");
        System.out.println(" " + this.getPhoneNumber());
        System.out.println("\n[E-mail]");
        System.out.println(" " + this.getEmail());
        System.out.println("\n[Address]");
        System.out.println(this.address.getAddress());
        System.out.println("==========================\n");
    }

    @Override
    public void setPhoneNumber(PhoneNumber phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber.getPhoneNumber();
    }

    @Override
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

}

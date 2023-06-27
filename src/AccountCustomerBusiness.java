public class AccountCustomerBusiness extends Account implements CheckBalance, SetAddress
{
    private double balance;
    private final String accountType = "Business Account";
    String address;

    public AccountCustomerBusiness(String userId, String userPass)
    {
        super(userId,userPass);
    }

    public AccountCustomerBusiness(String userId, String userPass, String userName, double balance)
    {
        super(userId,userPass,userName);
        this.balance = balance;
    }
    @Override
    public void setAddress(Address address)
    {
        System.out.println("This is a Business Account, please use [void setAddress(String address)]");
    }
    @Override
    public void setAddress(String address)
    {
        this.address = address;
    }
    @Override
    public String getAddress()
    {
        return this.address;
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
        System.out.println("==========================");
        System.out.printf("%10s : %s%n","User Name"  , super.getUserName());
        System.out.printf("%10s : %s%n","User Id"    , super.getUserId());
        System.out.printf("%10s : %s%n","AccountType", this.accountType);
        System.out.println("==========================");
        System.out.println("[Address]");
        System.out.println(this.address);
        System.out.println("==========================");
    }
}

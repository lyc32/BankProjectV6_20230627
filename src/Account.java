import java.util.List;

public abstract class Account
{
    private String userId;
    private String userPass;
    private String userName;
    private boolean delete = false;

    public Account(String userId, String userPass)
    {
        this.userId = userId;
        this.userPass = userPass;
    }

    public Account(String userId, String userPass, String userName)
    {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getUserPass()
    {
        return this.userPass;
    }

    public String getUserName()
    {
        return this.userName;
    }


    public void delete()
    {
        this.delete = true;
    }

    public boolean isDelete()
    {
        return this.delete;
    }

    public Account login(List<Account> accountList)
    {
        for(int i = 0; i < accountList.size(); i++)
        {
            Account tmp = accountList.get(i);
            if(tmp.getUserId().equals(this.userId) && tmp.getUserPass().equals(this.userPass))
            {
                if(tmp.isDelete())
                {
                    System.out.println("Your account has been suspended, please connect the Manager\n input any key to continue");
                    return null;
                }
                return accountList.get(i);
            }
        }
        System.out.println("your ID and password not match\nDo you want to try again.");
        return null;
    }

    abstract void print();
}

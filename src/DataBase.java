import java.util.ArrayList;
import java.util.List;

public class DataBase
{
    public List<Account> perAccountList = new ArrayList<>();
    public List<Account> busAccountList = new ArrayList<>();
    public List<Account> magAccountList = new ArrayList<>();

    DataBase()
    {
        AccountCustomerPersonal p1 = new AccountCustomerPersonal("AB1001","12345","Jim", 800);
        Address address1 = new Address("405", "605", "W", "Madison", "Chicago", "IL", "60661");
        p1.setAddress(address1);
        p1.setPhoneNumber(new PhoneNumber(1,3122132457L));
        p1.setEmail("1598395257@qq.com");

        AccountCustomerPersonal p2 = new AccountCustomerPersonal("AB1004","12345","Tom", 200);
        Address address2 = new Address("B", "1346", "W", "32nd", "Chicago", "IL", "60608");
        p2.setAddress(address2);
        p2.setPhoneNumber(new PhoneNumber(86,18618455705L));
        p2.setEmail("liyc930826@gmail.com");

        AccountCustomerPersonal p3 = new AccountCustomerPersonal("AB1005","12345", "Lucky",1000);
        Address address3 = new Address("305", "525","S", "State","Chicago", "IL", "60605");
        p3.setAddress(address3);
        p3.setPhoneNumber(new PhoneNumber(1, 2397461036L));
        p3.setEmail("xcoder0000@sina.com");

        AccountCustomerBusiness p4 = new AccountCustomerBusiness("AB1002","12345","Apple", 1000000000);
        p4.setAddress("One Apple Park Way\nCupertino, CA 95014, U.S.A.");
        AccountCustomerBusiness p5 = new AccountCustomerBusiness("AB1003","12345","Google", 20000000);
        p5.setAddress("1600 Amphitheatre Parkway Mountain View\nCA 94043, USA.");

        AccountManger p6 = new AccountManger("M001","12345", "Manger1");
        AccountManger p7 = new AccountManger("M002","12345", "Manger2");

        perAccountList.add(p1);
        perAccountList.add(p2);
        perAccountList.add(p3);

        busAccountList.add(p4);
        busAccountList.add(p5);

        magAccountList.add(p6);
        magAccountList.add(p7);

    }
}

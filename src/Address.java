import java.util.Scanner;

public class Address
{
    private String doorNo;
    private String streetNo;
    private String direction;
    private String streetName;
    private String cityName;
    private String stateName;
    private String zipCode;

    public Address(String doorNo, String streetNo, String direction, String streetName, String cityName, String stateName, String zipCode) {
        this.doorNo = doorNo;
        this.streetNo = streetNo;
        this.direction = direction;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
    }

    public Address()
    {
        this.doorNo = "";
        this.streetNo = "";
        this.direction = "";
        this.streetName = "";
        this.stateName = "";
        this.cityName = "";
        this.zipCode = "";
    }

    public void create(Scanner scanner)
    {
        System.out.println("please input your Street No:");
        streetNo = scanner.next();
        System.out.println("please input the Street direction: W E N S");
        direction = scanner.next();
        System.out.println("please input the Street Name:");
        streetName = scanner.next();
        System.out.println("please input your apt No:");
        doorNo = scanner.next();
        System.out.println("please input your city name:");
        cityName = scanner.next();
        System.out.println("please input your state:");
        stateName = scanner.next();
        System.out.println("please input your ZipCode:");
        zipCode = scanner.next();
    }

    public String getAddress()
    {
        String result = "";
        if(!streetNo.equals(""))
        {
            result = "  " + streetNo + " ";
        }

        if(!direction.equals(""))
        {
            result = result + direction + " ";
        }

        if(!streetName.equals(""))
        {
            result = result + streetName + " St, ";
        }

        if(!doorNo.equals(""))
        {
            result = result + "APT "+ doorNo + "\n  ";
        }
        if(!cityName.equals(""))
        {
            result = result + cityName;
        }

        if(!stateName.equals(""))
        {
            result = result + "," + stateName + ", ";
        }
        if(!zipCode.equals(""))
        {
            result = result + zipCode;
        }
        return result;
    }
}

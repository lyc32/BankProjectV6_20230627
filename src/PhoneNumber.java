import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneNumber
{
    private int countryNumber;
    private long phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(int countryNumber, long phoneNumber) {
        this.countryNumber = countryNumber;
        this.phoneNumber = phoneNumber;
    }

    public void create(Scanner scanner) {
        System.out.println("please input Country No:\n eg: US user input 1");
        for (; true; ) {
            try {
                countryNumber = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a number, try again\n");
                scanner.next();
            }
        }

        System.out.println("please input the phone number:");
        for (; true; )
        {
            try
            {
                phoneNumber = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please input a number, try again\n");
                scanner.next();
            }
        }
    }

    public String getPhoneNumber()
    {
        return "+" + countryNumber + " " + phoneNumber;
    }


}

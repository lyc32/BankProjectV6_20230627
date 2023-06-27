public class BankProjectMain
{
    public static void main(String[] args)
    {
        DataBase dataBase = new DataBase();
        new ChatBot(dataBase);
    }
}

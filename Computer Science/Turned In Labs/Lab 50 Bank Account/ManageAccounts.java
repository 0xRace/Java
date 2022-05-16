// ****************************************************************
//   ManageAccounts.java
//
//   Use Account class to create and manage Sally and Joe's 
//   bank accounts       
// ****************************************************************

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */
public class ManageAccounts
{
    public static void main(String[] args)
    {
        Account acct1, acct2;

        //create account1 for Sally with $1000
        acct1 = new Account(1000, "Sally", 1111);

        //create account2 for Joe with $500, account number 12345
        acct2 = new Account(500, "Joe", 12345);

        //deposit $100 to Joe's account (use deposit method)
        acct2.deposit(100);

        //print Joe's new balance (use getBalance())
        System.out.println("Joe's new balance is $"+acct2.getBalance());

        //withdraw $50 from Sally's account (use withdraw method)
        acct1.withdraw(50);

        //print Sally's new balance (use getBalance())
        System.out.println("Sally's new balance is $"+acct1.getBalance());

        //charge fees to both accounts
        //print the balance that is returned from the chargeFees() method.  
        //You can either store it in a variable and then print the value of the variable,
        //or embed the method call in a println statement
        System.out.println("Sally's balance after charging a fee is $"+acct1.chargeFee());
        System.out.println("Joe's balance after charging a fee is $"+acct2.chargeFee());

        //change the name on Joe's account to Joseph 
        //(use changeName method)
        acct2.changeName("Joseph");

        //print summary for both accounts (use toString())
        System.out.println(acct1.toString());
        System.out.println(acct2.toString());

    }
}
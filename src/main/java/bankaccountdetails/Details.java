package bankaccountdetails;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Details {
    protected Scanner s =new Scanner(System.in);
    Logger log= Logger.getLogger("Details");
    private int currentBalance=0;
    private int depositedAmount;
    private int withdrawAmount;

    long accountNo;
    String accountName;
    public Details(long no, String name)
    {
        accountNo=no;
        accountName=name;
    }
    public void deposit()
    {
        log.info("Enter the amount to deposit:");
        depositedAmount =s.nextInt();
        currentBalance=currentBalance+ depositedAmount;
        log.log(Level.INFO,()->depositedAmount+" has been deposited successfully!!!");
    }
    public void withdrawal()
    {
        log.info("Enter the withdrawal amount:");
        withdrawAmount =s.nextInt();
        if(withdrawAmount >currentBalance)
        {
            log.info("SORRY !!!withdrawal amount is greater than current balance.");
        }
        else{
            currentBalance=currentBalance- withdrawAmount;
            log.log(Level.INFO,()->withdrawAmount+" has been withdrawn successfully!!!");
        }
    }
    public void balanceCheck()
    {
        log.log(Level.INFO,()->"current balance is :"+currentBalance);
    }
}
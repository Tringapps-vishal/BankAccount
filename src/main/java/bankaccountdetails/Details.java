package bankaccountdetails;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Details {
    Scanner s =new Scanner(System.in);
    Logger log= Logger.getLogger("Details");
    int currentBalance=0;
    int depositedAmount;
    int withdrawAmount;
    long accountNo;
    String accountName;
    public Details(long no, String nme)
    {
        accountNo=no;
        accountName=nme;
    }
    public void deposit()
    {
        log.info("Enter the amount to deposit:");
        depositedAmount =s.nextInt();
        currentBalance=currentBalance+ depositedAmount;
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
        }
    }
    public void balanceCheck()
    {
        log.log(Level.INFO,()->"current balance is :"+currentBalance);
    }
}
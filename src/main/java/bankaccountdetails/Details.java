package bankaccountdetails;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Details {
    protected Scanner sc =new Scanner(System.in);
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
        log.info("Account Created Successfully!! with the Account Number "+accountNo);
    }
    public void deposit()
    {
        log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(tempAccountNumber==accountNo) {
            log.info("Enter the amount to deposit:");
            depositedAmount = sc.nextInt();
            currentBalance = currentBalance + depositedAmount;
            log.log(Level.INFO, () -> depositedAmount + " has been deposited successfully!!!");
        }
        else
            log.info("Wrong Account number!!");
    }
    public void withdrawal()
    {
        log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(tempAccountNumber==accountNo) {
        log.info("Enter the withdrawal amount:");
        withdrawAmount =sc.nextInt();
        if(withdrawAmount >currentBalance)
        {
            log.info("SORRY !!!withdrawal amount is greater than current balance.");
        }
        else{
            currentBalance=currentBalance- withdrawAmount;
            log.log(Level.INFO,()->withdrawAmount+" has been withdrawn successfully!!!");
        }}else
            log.info("Wrong Account number!!");
    }
    public void balanceCheck()
    {
        log.log(Level.INFO,()->"current balance is :"+currentBalance);
    }
}
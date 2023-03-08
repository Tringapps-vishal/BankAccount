package bankaccountdetails;


import bankaccountgetdata.GetData;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Details extends GetData {
    protected Scanner sc =new Scanner(System.in);
    Logger log= Logger.getLogger("Details");
    private double currentBalance=0;
    private final long accountNo;
    private final  String accountName;
    private double balance;
    public Details(long no, String name,double balance)
    {
        accountNo=no;
        accountName=name;
        this.balance=balance;
        log.info("Account Created Successfully!! with the Account Number "+accountNo);
    }
    public void deposit()
    {
        int depositedAmount;
        log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            log.info("Enter the amount to deposit:");
            depositedAmount = sc.nextInt();
            map.get(tempAccountNumber)=currentBalance;
            currentBalance = currentBalance + depositedAmount;
            log.log(Level.INFO, () -> depositedAmount + " has been deposited successfully!!!");
        }
        else
            log.info("Account not found!!");
    }
    public void withdrawal()
    {
        int withdrawAmount;
        log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
        log.info("Enter the withdrawal amount:");
        withdrawAmount =sc.nextInt();
        map.get(tempAccountNumber)=currentBalance;
        if(withdrawAmount>currentBalance)
        {
            log.info("SORRY !!!withdrawal amount is greater than current balance.");
        }
        else{
            currentBalance=currentBalance- withdrawAmount;
            log.log(Level.INFO,()->withdrawAmount+" has been withdrawn successfully!!!");
        }}else
            log.info("Account not found!!");
    }
    public void balanceCheck()
    {   log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            map.get(tempAccountNumber)=currentBalance;
            log.log(Level.INFO, () -> "current balance is :" + currentBalance);
        }
        else
            log.info("Account not found!!");
    }
}
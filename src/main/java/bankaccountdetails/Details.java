package bankaccountdetails;


import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Details  {
    protected Scanner sc =new Scanner(System.in);
    Logger log= Logger.getLogger("Details");
    HashMap<Long,Long> map=new HashMap<>();
    private long currentBalance=0;
     long accountNo;
     String accountName;
     double balance;
    public Details(long no, String name,double balance)
    {
        accountNo=no;
        accountName=name;
        this.balance=balance;
        log.info("Account Created Successfully!! with the Account Number "+accountNo);
    }
    public Details()
    {
    }
    public void getdata()
    {
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger("Main");
        String accountName;
        long accountNo;
        log.info("Enter account holders name:");
        accountName=sc.nextLine();
        log.info("Enter the account number:");
        accountNo=sc.nextLong();
        long balance=0;
        Details d=new Details(accountNo,accountName,balance);
        map.put(accountNo,balance);
    }
    public void deposit()
    {
        int depositedAmount;
        log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            log.info("Enter the amount to deposit:");
            depositedAmount = sc.nextInt();
            currentBalance= map.get(tempAccountNumber);

            currentBalance = currentBalance + depositedAmount;
            map.replace(tempAccountNumber,currentBalance);
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
        currentBalance=map.get(tempAccountNumber);
        if(withdrawAmount>currentBalance)
        {
            log.info("SORRY !!!withdrawal amount is greater than current balance.");
        }
        else{
            currentBalance-=withdrawAmount;
            log.log(Level.INFO,()->withdrawAmount+" has been withdrawn successfully!!!");
        }}else
            log.info("Account not found!!");
    }
    public void balanceCheck()
    {   log.info("Enter the Account number:");
        long tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            currentBalance=map.get(tempAccountNumber);
            log.log(Level.INFO, () -> "current balance is :" + currentBalance);
        }
        else
            log.info("Account not found!!");
    }
}
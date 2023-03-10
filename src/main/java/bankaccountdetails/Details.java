package bankaccountdetails;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Details{
    private final Scanner sc =new Scanner(System.in);
    private final Logger log= Logger.getLogger("Details");
    private final HashMap<Long,Long> map=new HashMap<>();
    private long currentBalance=0;
    private long tempAccountNumber;
    long userNo;
    String userName;
    long userBalance;
    private static final String NUMBERMSG= "Enter the Account number:";
    private static final String ACCOUNTMSG= "Enter the Account number:";
    private Details(long no, String name,long balance)
    {
        this.userNo=no;
        this.userName=name;
        this.userBalance=balance;
    }
    public Details()
    {
    }
    private void msg()
    {
        log.info("Account Created Successfully!!");
    }
    public void getData()
    {
        String accountName;
        long accountNo;
        log.info("Enter account holders name:");
        accountName=sc.next();
        log.info("Enter the account number:");
        accountNo=sc.nextLong();
        long balance=0;
        Details d=new Details(accountNo,accountName,balance);
        d.msg();
        map.put(accountNo,balance);
    }
    public void deposit()
    {
        log.info(NUMBERMSG);
        tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            log.info("Enter the amount to deposit:");
            int depositedAmount = sc.nextInt();
            currentBalance= map.get(tempAccountNumber);
            currentBalance +=depositedAmount;
            map.replace(tempAccountNumber,currentBalance);
            log.log(Level.INFO, () -> depositedAmount + " has been deposited successfully!!!");
        }
        else
            log.info(ACCOUNTMSG);
    }
    public void withdrawal()
    {
        log.info(NUMBERMSG);
        tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
        log.info("Enter the withdrawal amount:");
        int withdrawAmount =sc.nextInt();
        currentBalance=map.get(tempAccountNumber);
        if(withdrawAmount>currentBalance) {
            log.info("SORRY !!!Insufficient Balance.");
        }
        else{
            currentBalance-=withdrawAmount;
            map.replace(tempAccountNumber,currentBalance);
            log.log(Level.INFO,()->withdrawAmount+" has been withdrawn successfully!!!");
        }
        }else
            log.info(ACCOUNTMSG);
    }
    public void balanceCheck()
    {
        log.info(NUMBERMSG);
        tempAccountNumber=sc.nextLong();
        if(map.containsKey(tempAccountNumber)) {
            currentBalance=map.get(tempAccountNumber);
            log.log(Level.INFO, () -> "current balance is :" + currentBalance);
        }
        else
            log.info(ACCOUNTMSG);
    }
}
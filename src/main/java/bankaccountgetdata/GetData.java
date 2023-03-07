package bankaccountgetdata;

import bankaccountdetails.Details;

import java.util.Scanner;
import java.util.logging.Logger;

public class GetData {
    public void getdata()
    {
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger("Main");
        String accountName;
        long accountNo;
        int choice;
        log.info("Enter account holders name:");
        accountName=sc.nextLine();
        log.info("Enter the account number:");
        accountNo=sc.nextLong();
        Details d=new Details(accountNo,accountName);
        while(true)
        {
            log.info("1.Deposit     2.Withdrawal       3.Check balance      4.Add Account       5.Exit");
            choice=sc.nextInt();
            switch (choice) {
                case 1 -> d.deposit();
                case 2 -> d.withdrawal();
                case 3 -> d.balanceCheck();
                case 4 -> getdata();
                case 5 -> {
                    log.info("Exiting!!!");
                    System.exit(0);
                }
                default -> log.info("Enter the invalid choice!!!");
            }
        }
    }
}

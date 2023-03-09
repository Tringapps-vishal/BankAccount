package bankaccountgetdata;

import bankaccountdetails.Details;
import java.util.Scanner;
import java.util.logging.Logger;
public class GetData {
    public void getData()
    {
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger("GetData");
        int choice;
        Details d;
        d = new Details();
        while(true)
        {
            log.info("1.Deposit     2.Withdrawal       3.Check balance      4.Add Account       5.Exit");
            choice=sc.nextInt();
            switch (choice) {
                case 1 -> d.deposit();
                case 2 -> d.withdrawal();
                case 3 -> d.balanceCheck();
                case 4 -> d.getData();
                case 5 -> {
                    log.info("Exiting!!!");
                    System.exit(0);
                }
                default -> log.info("Invalid choice!!!");
            }
        }
    }
}

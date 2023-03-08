package bankaccountmain;

import bankaccountgetdata.GetData;
import java.util.logging.Logger;
public class Main {
    private static final GetData gd =new GetData();
    public static void main(String[] args) {
        Logger log= Logger.getLogger("Main");
        log.info("WELCOME TO BANK OF VISHAL");
        gd.getData();
    }
}
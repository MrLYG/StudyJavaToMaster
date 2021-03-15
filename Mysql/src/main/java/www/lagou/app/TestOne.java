package www.lagou.app;
import org.junit.Test;
import www.lagou.dao.TransferAccountsDao;
import www.lagou.utils.ClientScanner;

import java.util.TreeMap;
/*
 * @Author 白沙
 * @create 2021/3/13 0013 18:16
 */

public class TestOne {
    public static void main(String[] args) {
        TransferAccountsDao tad = new TransferAccountsDao();
        System.out.println("请输入要转出的账号：");
        String cardIdOut = ClientScanner.getScanner().next();
        System.out.println("请输入要转入的账号：");
        String cardIdIn = ClientScanner.getScanner().next();
        tad.transferAccounts(cardIdOut,cardIdIn);
    }
   /*@Test
    public void accountTransaction(){//作业第一题测试
       TransferAccountsDao tad = new TransferAccountsDao();
       System.out.println("请输入要转出的账号：");
       String cardIdOut = ClientScanner.getScanner().next();
       System.out.println("请输入要转入的账号：");
       String cardIdIn = ClientScanner.getScanner().next();
       tad.transferAccounts(cardIdOut,cardIdIn);

    }*/
}

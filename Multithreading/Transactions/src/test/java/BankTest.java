import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankTest extends TestCase {

    long allMoney = 0;
    Bank bank;


    @Override
    protected void setUp() {

        int countOperations = 4000;
        int countAccounts = 50;
        int money = 150_000;
        int countThread = 10;
        Random random = new Random();

        Map<String, Account> accounts = new HashMap<>();
        for (int i = 1; i <= countAccounts; i++) {
            if (i < 10) {
                accounts.put(String.valueOf(i), new Account(money, ("1000-1000-1000-100" + i)));
            }
            if (i >= 10 && i < 100) {
                accounts.put(String.valueOf(i), new Account(money, ("1000-1000-1000-10" + i)));
            }
            if (i >= 100) {
                accounts.put(String.valueOf(i), new Account(money, ("1000-1000-1000-1" + i)));
            }
        }

        bank = new Bank(accounts);
        allMoney = bank.getSumAllAccounts();

        for (int i = 0; i < countThread; i++) {
            new Thread(() -> {
                for (int j = 0; j < countOperations; j++) {
                    String fromAccountNum = String.valueOf(random.nextInt(countAccounts) + 1);
                    String toAccountNum = String.valueOf(random.nextInt(countAccounts) + 1);
                    long amount = random.nextInt(55_000) + 1;
                    bank.transfer(fromAccountNum, toAccountNum, amount);
                }
            }).start();
        }

    }

    public void testGetSumAllAccounts () {
        long actual = bank.getSumAllAccounts();
        long expected = allMoney;
        assertEquals(actual, expected);
    }

}

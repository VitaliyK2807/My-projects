import java.util.*;

public class Bank {

    private Map<String, Account> accounts;
    private Map<String, Account> listBlockedAccounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
        listBlockedAccounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return random.nextBoolean();
    }


    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */


    public void transfer(String fromAccountNum, String toAccountNum, long amount){

        long fromAccountMoney = getBalance(fromAccountNum);
        Boolean isUnloked = isAccountUnlocked(fromAccountNum, toAccountNum);
        Boolean sameAccountNum = fromAccountNum.equals(toAccountNum) ? true : false;
        Boolean enoughMoney = testBalance(fromAccountMoney, amount);
        Boolean safetyApproval = false;

        if (amount > 50_000 && !isUnloked) {
            safetyApproval = isFraud(fromAccountNum, toAccountNum, amount);
            blockedAccounts(safetyApproval, fromAccountNum, toAccountNum);
        }

        if (enoughMoney && !safetyApproval && !sameAccountNum && !isUnloked) {
            Account lowSyncAccount;
            Account topSyncAccount;
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);

            System.out.println(fromAccount.getAccNumber() + " - " + toAccount.getAccNumber());


            if (fromAccount.hashCode() > toAccount.hashCode()) {
                lowSyncAccount = toAccount;
                topSyncAccount = fromAccount;
            } else {
                lowSyncAccount = fromAccount;
                topSyncAccount = toAccount;
            }
            synchronized (lowSyncAccount) {
                synchronized (topSyncAccount) {
                    transferMoney(fromAccount, toAccount, amount);
                }
            }

        }

    }

    private void transferMoney (Account fromAccount, Account toAccount, long amount) {
        toAccount.setMoney(toAccount.getMoney() + amount);
        fromAccount.setMoney(fromAccount.getMoney() - amount);
    }

    private void deductionMoney (Account account, long amount) {
        long money = account.getMoney();
        account.setMoney(money - amount);
    }

    private void blockedAccounts (Boolean value, String fromAccountNum, String toAccountNum) {
        if (value) {
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);
            listBlockedAccounts.put(fromAccountNum, fromAccount);
            listBlockedAccounts.put(toAccountNum, toAccount);
            accounts.remove(fromAccountNum);
            accounts.remove(toAccountNum);
        }
    }

    private Boolean testBalance (long accountMoney, long amount) {
        if (accountMoney <= 0) {
            return false;
        }
        if (accountMoney - amount >= 0) {
            return true;
        }
        return false;
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        long balance = account == null ? 0 : account.getMoney();
        return balance;
    }

    public Boolean isAccountUnlocked (String fromAccountNum, String toAccountNum) {
        Account accountFrom = accounts.get(fromAccountNum);
        if (accountFrom == null) {
            return true;
        }
        Account accountTo = accounts.get(toAccountNum);
        if (accountTo == null) {
            return true;
        }
        return false;
    }
    public long getSumAllAccounts() {
        long sumAllAccounts = 0;
        for (Map.Entry<String, Account> accaunt: accounts.entrySet()) {
            long money = accaunt.getValue().getMoney();
            sumAllAccounts += money;
        }
        for (Map.Entry<String, Account> accaunt: listBlockedAccounts.entrySet()) {
            long money = accaunt.getValue().getMoney();
            sumAllAccounts += money;
        }
        return sumAllAccounts;
    }

    public List<String> getListAccount () {
        List<String> list = new ArrayList<>();

        list.add("Основной список аккаунтов:"  + "\n");
        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            String string = ("Аккаунт: " + account.getKey() +
                    " Номер счета: " + account.getValue().getAccNumber() +
                    " Остаток средств: " + account.getValue().getMoney());
            list.add(string);
        }

        list.add("");
        list.add("Список блокированных аккаунтов:" + "\n");
        for (Map.Entry<String, Account> account : listBlockedAccounts.entrySet()) {
            String string = ("Аккаунт: " + account.getKey() +
                    " Номер счета: " + account.getValue().getAccNumber() +
                    " Остаток средств: " + account.getValue().getMoney());
            list.add(string);
        }
        return list;
    }

    public String getAccNumber(String accountKey) {
        Account account = accounts.get(accountKey);
        String accNumber = account == null ? "" : account.getAccNumber();
        return accNumber;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}

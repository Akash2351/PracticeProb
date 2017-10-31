/**
 * Created by Chiru on Dec 30, 2016
 */
package threading;

public class ThreadSafety {

    public static void main(String[] args) {

        RossAndRachelJob theJob = new RossAndRachelJob();

        Thread one = new Thread(theJob, "Ross");
        Thread two = new Thread(theJob, "Rachel");
        one.start();
        two.start();
    }

    private static class BankAccount {
        private int balance = 500;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }
    }

    public static final class RossAndRachelJob implements Runnable {
        private BankAccount account = new BankAccount();

        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 5; i++) {
                makeWithdrawal(100);
                if (account.getBalance() < 0) {
                    System.out.println("Over Drawn!");
                }
            }
        }

        //Making this critical method synchronized to ensure only one thread access data at a time.
        private synchronized void makeWithdrawal(int amount) {
            String currentThread = Thread.currentThread().getName();
            if (account.getBalance() >= amount) {
                System.out.println(currentThread + " is about to withdraw");
                try {
                    System.out.println(currentThread + " is sleeping");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(currentThread + " woke up");
                account.withdraw(amount);
                System.out.println(currentThread + " finished withdrawal. Balance = " + account.getBalance());
            } else {
                System.out.println("Not enough balance " + currentThread);
            }
        }
    }
}
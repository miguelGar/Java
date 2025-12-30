public class RaceCondition {
    private static int balance = 100;

    public static synchronized void  withdraw(int amount) {
        if (balance >= amount) {
            // Use synchronization to make the check-and-update atomic
            balance -= amount;
            System.out.println("Approving withdrawal of $" + amount);
            //balance = balance - amount; // ⚠️ Race condition here!
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for $" + amount);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition account = new RaceCondition();

        // Two threads trying to withdraw at the same time
        Thread t1 = new Thread(() -> account.withdraw(80));
        Thread t2 = new Thread(() -> account.withdraw(50));

        t1.start();
        t2.start();

        // Wait for both to finish
        t1.join();
        t2.join();

        System.out.println("Final balance: $" + account.balance);
    }
    //ERROR RACE CONDITION
    /*
        public class Counter {
            private static int count = 0;
            //ERROR
            public static void increment() {
                count++; // NOT atomic!
            }
            //FIX
            public static synchronized void increment() {
                count++; // Now atomic
            }

            public static void main(String[] args) throws InterruptedException {
                Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) increment(); });
                Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) increment(); });

                t1.start(); t2.start();
                t1.join(); t2.join();

                System.out.println("Final count: " + count); // Often < 2000!
            }
        }
     */
}

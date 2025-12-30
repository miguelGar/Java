public class RaceCondition2 {
    private static int ticketsAvailable = 1;

    //Use synchronized (Simple & Clear)
    public static synchronized void buyTicket(String user) {
        if (ticketsAvailable > 0) {
            System.out.println(user + " sees ticket available!");
            // Simulate processing delay (e.g., payment validation)
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            //ticketsAvailable = ticketsAvailable - 1;
            ticketsAvailable--;
            System.out.println(user + " bought a ticket! Remaining: " + ticketsAvailable);
        } else {
            System.out.println("Sorry " + user + ", no tickets left!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread alice = new Thread(() -> buyTicket("Alice"));
        Thread bob = new Thread(() -> buyTicket("Bob"));

        alice.start();
        bob.start();

        alice.join();
        bob.join();

        System.out.println("Final tickets left: " + ticketsAvailable);
    }
}

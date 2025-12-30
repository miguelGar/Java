public class Tread {
    public static void main(String[] args) {

        // Basic thread
        Thread t = new Thread(() -> {
            System.out.println("Hello from thread: " + Thread.currentThread().getName());
        });
        t.start(); // Don't call run() directly!


        // Thread 1: Counts 1-3
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-1: " + i);
                try {
                    //Thread.sleep(1000);
                } catch (Exception e) {}
            }
        });

        // Thread 2: Counts A-C
        Thread t2 = new Thread(() -> {
            for (char c = 'A'; c <= 'C'; c++) {
                System.out.println("Thread-2: " + c);
                try {
                   // Thread.sleep(1000);
                } catch (Exception e) {}
            }

        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All done!");


    }




}
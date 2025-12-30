import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    /*
    Only 3 threads are created (even for 5 tasks).
    Threads are reused (e.g., pool-1-thread-1 handles user1 → user4).
    Tasks run in parallel, finishing in ~2 seconds instead of 5.
     */
    // Create a thread pool with 3 reusable threads
    private static final ExecutorService emailThreadPool =
            Executors.newFixedThreadPool(3);
    //new ThreadPoolExecutor(...) // Full control (production-grade)

    // Submit email task to the pool
    public static void sendWelcomeEmailAsync(String userEmail) {
        emailThreadPool.submit(() -> {
            System.out.println("Sending welcome email to: " + userEmail +
                    " (on thread: " + Thread.currentThread().getName() + ")");

            // Simulate network delay (e.g., calling SMTP server)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("✅ Email sent to: " + userEmail);
        });
    }

    // Gracefully shut down the pool (call at app shutdown)
    public static void shutdown() {
        emailThreadPool.shutdown();
    }

    // --- Demo ---
    public static void main(String[] args) throws InterruptedException {
        // Simulate 5 users signing up rapidly
        for (int i = 1; i <= 5; i++) {
            sendWelcomeEmailAsync("user" + i + "@example.com");
        }

        // Wait for all emails to finish
        Thread.sleep(3000);
        shutdown();
    }

    //BASIC EXAMPLE
    /*
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            executor.submit(() -> System.out.println("Task 1"));
            executor.submit(() -> System.out.println("Task 2"));

            executor.shutdown(); // Always shut down!
        }
     */

    /*
    “Instead of creating a new thread for every email—which could crash the server under load—I use a fixed thread pool with a bounded size (e.g., 3 threads).

    This ensures we control resource usage, reuse threads efficiently, and process tasks concurrently without overwhelming the system.

    In production, I’d use a configurable pool size based on CPU cores or I/O wait time, and always shut down the pool gracefully during app shutdown.”

    Bonus insight:
    “For I/O-heavy tasks like email, a larger pool (e.g., 10–100 threads) is fine. For CPU-bound work, I’d use ForkJoinPool or limit threads to Runtime.getRuntime().availableProcessors().”
     */
}

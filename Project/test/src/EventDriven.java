import java.util.ArrayList;
import java.util.List;

// 1. Base Event interface
interface Event {}

// 2. Concrete Event
class UserSignedUpEvent implements Event {
    private final String email;
    public UserSignedUpEvent(String email) {
        this.email = email;
    }
    public String getEmail() { return email; }
}

// 3. Generic EventHandler
interface EventHandler {
    void handle(Event event);
}

// 4. EventBus (simple and safe)
class EventBus {
    private final List<EventHandler> handlers = new ArrayList<>();

    public void subscribe(EventHandler handler) {
        handlers.add(handler);
    }

    public void publish(Event event) {
        System.out.println("✅ Publishing event: " + event.getClass().getSimpleName());
        for (EventHandler handler : handlers) {
            handler.handle(event);
        }
    }
}

// 5. Concrete Handlers
class EmailService implements EventHandler {
    @Override
    public void handle(Event event) {
        if (event instanceof UserSignedUpEvent) {
            UserSignedUpEvent e = (UserSignedUpEvent) event;
            System.out.println("📧 Sending welcome email to: " + e.getEmail());
        }
    }
}

class AnalyticsService implements EventHandler {
    @Override
    public void handle(Event event) {
        if (event instanceof UserSignedUpEvent) {
            UserSignedUpEvent e = (UserSignedUpEvent) event;
            System.out.println("📊 Logging signup: " + e.getEmail());
        }
    }
}

public class EventDriven {

    public static void main(String[] args) {
        EventBus bus = new EventBus();

        // Subscribe services
        bus.subscribe(new EmailService());
        bus.subscribe(new AnalyticsService());

        // Simulate user signup
        UserSignedUpEvent event = new UserSignedUpEvent("alice@example.com");
        bus.publish(event);

        // Output:
        // ✅ Publishing event: UserSignedUp
        // 📧 Sending welcome email to: alice@example.com
        // 📊 Logging signup: alice@example.com
    }

}

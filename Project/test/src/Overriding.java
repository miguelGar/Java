// Parent class
public class Overriding {
    public void sendNotification() {
        System.out.println("Sending a generic notification.");
    }
}

// Child class 1
class PushNotification extends Overriding {
    @Override
    public void sendNotification() {
        System.out.println("Sending a PUSH notification to your phone!");
    }
}

// Child class 2
class EmailNotification extends Overriding {
    @Override
    public void sendNotification() {
        System.out.println("Sending an EMAIL notification!");
    }
}

// Demo
class Main {
    public static void main(String[] args) {
        // Polymorphism: parent reference, child objects
        Overriding n1 = new PushNotification();
        Overriding n2 = new EmailNotification();

        n1.sendNotification(); // Output: Sending a PUSH notification...
        n2.sendNotification(); // Output: Sending an EMAIL notification...
    }
}

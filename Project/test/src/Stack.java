import java.util.ArrayList;

public class Stack {

    // We'll use a list as our stack (only add/remove from the END)
    private ArrayList<String> history = new ArrayList<>();

    // Save the current text to the stack (like making a change)
    public void saveState(String text) {
        history.add(text);  // Push: add to the TOP (end of list)
        System.out.println("Saved: \"" + text + "\"");
    }

    // Undo: go back to the previous version
    public String undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo!");
            return "";
        }
        // Pop: remove and return the LAST item (most recent)
        String lastState = history.remove(history.size() - 1);
        System.out.println("Undo → Back to: \"" + lastState + "\"");
        return lastState;
    }

    // Show the current top (most recent saved state)
    public void showCurrent() {
        if (history.isEmpty()) {
            System.out.println("No text yet.");
        } else {
            String current = history.get(history.size() - 1);
            System.out.println("Current text: \"" + current + "\"");
        }
    }

    // ----- Demo in main -----
    public static void main(String[] args) {
        Stack editor = new Stack();

        // User types step by step
        editor.saveState("Hello");
        editor.saveState("Hello World");
        editor.saveState("Hello World!");

        System.out.println("\n--- Now undoing ---");
        editor.undo();  // Back to "Hello World"
        editor.undo();  // Back to "Hello"
        editor.undo();  // Back to nothing
        editor.undo();  // Nothing left!
    }

}

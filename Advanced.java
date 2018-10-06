import java.util.Scanner;

public class Advanced {

  private static final String WELCOME_MESSAGE = "Welcome to Array Expander!";
  private static final int DEFAULT_INITIAL_CAPACITY = 5;
  private static final int CAPACITY_INCREMENT = 5;

  private int capacity = DEFAULT_INITIAL_CAPACITY;
  private int[] history = new int[capacity];
  private int total = 0;

  private final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Advanced advanced = new Advanced();
    advanced.run();
  }

  private void run() {
    showBanner();
    while (true) {
      final int newNumber = getNewNumber();
      saveNumber(newNumber);
      showNumbers();
    }
  }

  private void showBanner() {
    System.out.println(WELCOME_MESSAGE);
  }

  private int getNewNumber() {
    System.out.print("Please enter a number: ");
    return scanner.nextInt();
  }

  private void saveNumber(final int newNumber) {
    history[total++] = newNumber;

    if (total == capacity) {
      int newCapacity = capacity + CAPACITY_INCREMENT;
      System.out.println("Array has reached its max capacity. Increasing capacity from " + capacity + " -> " + newCapacity);
      history = increaseCapacity(history, newCapacity);
      capacity = newCapacity;
    }
  }

  private int[] increaseCapacity(int[] source, int newCapacity) {
    int[] target = new int[newCapacity];
    System.arraycopy(source, 0, target, 0, source.length);
    return target;
  }

  private void showNumbers() {
    StringBuilder sb = new StringBuilder("Numbers = {");
    for (int historyElement : history) {
      sb.append(historyElement);
      sb.append(",");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append("}");
    System.out.println(sb.toString());
  }

}

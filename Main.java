import java.util.Scanner;

public class Main {

  private static final int DEFAULT_INITIAL_CAPACITY = 5;
  private static final int CAPACITY_INCREMENT = 5;

  public static void main(String[] args) {
    int capacity = DEFAULT_INITIAL_CAPACITY;
    int[] history = new int[capacity];
    int total = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Please enter a number: ");
      int input = scanner.nextInt();
      history[total++] = input;

      StringBuilder sb = new StringBuilder("History = {");
      for (int historyElement : history) {
        sb.append(historyElement);
        sb.append(",");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append("}");
      System.out.println(sb.toString());

      if (total == capacity) {
        int newCapacity = capacity + CAPACITY_INCREMENT;
        System.out.println("Increasing capacity from " + capacity + " -> " + newCapacity);
        history = increaseCapacity(history, newCapacity);
        capacity = newCapacity;
      }
      System.out.println("Capacity: [" + total + "/" + capacity + "]");
    }
  }

  private static int[] increaseCapacity(int[] source, int newCapacity) {
    int[] target = new int[newCapacity];
    System.arraycopy(source, 0, target, 0, source.length);
    return target;
  }

}


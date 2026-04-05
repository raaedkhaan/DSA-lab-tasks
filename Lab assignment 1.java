import java.util.Scanner;

public class Main {

    static int[] arr = new int[10]; // Fixed-size array
    static int size = 0; // Current number of elements

    // -----------------------------------------
    // INSERTION
    // -----------------------------------------

    static void insertAtEnd(int value) {
        if (size == arr.length) {
            System.out.println("Overflow! Array is full.");
            return;
        }
        arr[size] = value;
        size++;
    }

    static void insertAtBeginning(int value) {
        if (size == arr.length) {
            System.out.println("Overflow! Array is full.");
            return;
        }
        // Shift elements right
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
        size++;
    }

    static void insertAtPosition(int value, int pos) {
        if (size == arr.length) {
            System.out.println("Overflow! Array is full.");
            return;
        }
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        // Shift elements right
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = value;
        size++;
    }

    // -----------------------------------------
    // DELETION
    // -----------------------------------------

    static void deleteFromEnd() {
        if (size == 0) {
            System.out.println("Underflow! Array is empty.");
            return;
        }
        size--;
    }

    static void deleteFromBeginning() {
        if (size == 0) {
            System.out.println("Underflow! Array is empty.");
            return;
        }
        // Shift elements left
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    static void deleteFromPosition(int pos) {
        if (size == 0) {
            System.out.println("Underflow! Array is empty.");
            return;
        }
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position");
            return;
        }
        // Shift elements left
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // -----------------------------------------
    // TRAVERSAL
    // -----------------------------------------

    static void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // -----------------------------------------
    // SEARCH (Linear Search)
    // -----------------------------------------

    static void search(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found.");
    }

    // -----------------------------------------
    // UPDATE
    // -----------------------------------------

    static void update(int pos, int value) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid index");
            return;
        }
        arr[pos] = value;
        System.out.println("Value updated successfully.");
    }

    // -----------------------------------------
    // MAIN MENU
    // -----------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Array Menu ===");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Display Array");
            System.out.println("4. Search Element");
            System.out.println("5. Update Element");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Insert at Beginning");
                    System.out.println("2. Insert at Position");
                    System.out.println("3. Insert at End");
                    int insertChoice = sc.nextInt();

                    System.out.print("Enter value: ");
                    int val = sc.nextInt();

                    if (insertChoice == 1) insertAtBeginning(val);
                    else if (insertChoice == 2) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        insertAtPosition(val, pos);
                    }
                    else if (insertChoice == 3) insertAtEnd(val);
                    else System.out.println("Invalid choice");
                    break;

                case 2:
                    System.out.println("1. Delete from Beginning");
                    System.out.println("2. Delete from Position");
                    System.out.println("3. Delete from End");
                    int deleteChoice = sc.nextInt();

                    if (deleteChoice == 1) deleteFromBeginning();
                    else if (deleteChoice == 2) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        deleteFromPosition(pos);
                    }
                    else if (deleteChoice == 3) deleteFromEnd();
                    else System.out.println("Invalid choice");
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    search(key);
                    break;

                case 5:
                    System.out.print("Enter index to update: ");
                    int index = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newVal = sc.nextInt();
                    update(index, newVal);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

// =========================================
// IMPORTANT CONCEPT (WRITE IN REPORT):
// In arrays, insertion and deletion are expensive operations
// because elements must be shifted to maintain contiguous memory.
// =========================================

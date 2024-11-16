package intern_package;

import java.util.Scanner;

public class arrays {
	
	static int[] createArray(int size) {
        return new int[size];
    }

    static void inputValues(int arr[], int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the " + n + " values to insert in array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }

    static int searchElement(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1; 
    }

    static int insertEnd(int arr[], int n, int key, int capacity) {
        if (n >= capacity) {
            System.out.println("Array is full, cannot insert.");
            return n;
        }
        arr[n] = key;
        return (n + 1);
    }

    static void insertAtPosition(int arr[], int n, int x, int pos) {
        if (pos < 0 || pos > n) {
            System.out.println("Array position not available!!!.");
            return;
        }
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = x;
    }

    static int deleteElement(int arr[], int n, int key) {
        int pos = searchElement(arr, n, key);
        if (pos == -1) {
            System.out.println("Array Element not available.");
            return n;
        }

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;  
    }
    
    static void execute() {
        Scanner sc = new Scanner(System.in); int[] arr = null; int n = 0, size = 0;

        int choice;
        do {
            System.out.println("\nChoose an Array operation to perform:");
            System.out.println("1. Create New Array");
            System.out.println("2. Search Element in an Array");
            System.out.println("3. Insert at End of an Array");
            System.out.println("4. Insert at Specific Position in an Array");
            System.out.println("5. Delete Element from an Array");
            System.out.println("6. Traverse Array");
            System.out.println("7. Exit Array Operation");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	 System.out.println("Enter the size of the array: ");
                     size = sc.nextInt();
                     arr = createArray(size);
                     n = size;
                     inputValues(arr, n); 
                     System.out.println("Array of length " + size + " created and values entered.");
                     break;

                case 2:
                    if (arr == null) {
                        System.out.println("Create an Array First!!!.");
                        break;
                    }
                    System.out.println("Enter element to search: ");
                    int keySearch = sc.nextInt();
                    int position = searchElement(arr, n, keySearch);
                    if (position == -1) {
                        System.out.println("Element not found in an Array.");
                    } else {
                        System.out.println("Element found at the position: " + (position + 1));
                    }
                    break;

                case 3:
                    if (arr == null) {
                        System.out.println("Create an Array First!!!.");
                        break;
                    }

                    System.out.println("Enter element to insert at the end: ");
                    int keyEnd = sc.nextInt();
                    
                    if (n == size) {
                    	size *= 2;  
                        int[] newArr = new int[size];
                        
                        System.arraycopy(arr, 0, newArr, 0, arr.length);
                        
                        arr = newArr;

                        System.out.println("Array size increased. New Size is : " + size);
                    }

                    arr[n] = keyEnd;
                    n++;  

                    System.out.println("Element inserted at the end of an Array.");
                    break;

                case 4:
                    if (arr == null) {
                        System.out.println("Create an Array First!!!.");
                        break;
                    }

                    System.out.println("Enter element to insert in an Array: ");
                    int keyPosition = sc.nextInt();

                    System.out.println("Enter position to insert at (0 to " + n + "): ");
                    int pos = sc.nextInt();

                    if (pos < 0 || pos > n) {
                        System.out.println("Invalid position. Position should be between 0 and " + n);
                        break;
                    }

                    if (n == size) {
                    	size *= 2;  
                        int[] newArr = new int[size];

                        System.arraycopy(arr, 0, newArr, 0, arr.length);

                        arr = newArr;
                        
                        System.out.println("Array size increased. New Size is " + size);
                    }

                    for (int i = n; i > pos; i--) {
                        arr[i] = arr[i - 1];
                    }

                    arr[pos] = keyPosition;
                    
                    n++;

                    System.out.println("Element inserted at position " + pos);
                    break;


                case 5:
                    if (arr == null) {
                        System.out.println("Create an Array First!!!.");
                        break;
                    }
                    System.out.print("Enter element to delete from an Array: ");
                    int keyDelete = sc.nextInt();
                    n = deleteElement(arr, n, keyDelete);
                    if (n < arr.length) {
                        System.out.println("Element deleted from the Array.");
                    }
                    break;

                case 6:
                    if (arr == null) {
                        System.out.println("Create an Array First!!!.");
                        break;
                    }
                    System.out.print("Array: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Ending the Array Operations...");
                    break;

                default:
                    System.out.println("Invalid choice. Please Choose a Different Option.");
            }
        } while (choice != 7);

        sc.close();
    }
}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Program for sorting an array which is taken as input from command line,
 * then sorted in both ascending and descending order.
 *
 * @author Denizcan Boyraz
 * @since 04/10/2023
 */

public class HW3 {

    public static void main(String[] args) {
    /*
        // Initiate the scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for the size of the array to create one
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();


        // Initiate the array with the size
        int[] arr = new int[n];

        System.out.println("type 0 if you would like to generate a random array with " + n + " elements.");
        if (scanner.nextInt() == 0) {
            Random rd = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rd.nextInt(255);
            }

            System.out.println("your randomly generate array is: ");
            printArray(arr);
            algoSelector(arr);

        } else {
            System.out.println("Enter the elements of the array:");
            // Take the input and put them into the array
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();

            }
            algoSelector(arr);

        } */

        ResizingArrayQueueAndStackOfStrings.StringQueue queue = new ResizingArrayQueueAndStackOfStrings().new StringQueue(5);
        ResizingArrayQueueAndStackOfStrings.StringStack stack = new ResizingArrayQueueAndStackOfStrings().new StringStack(5);


        queue.enqueue("osman");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        queue.enqueue("mahmut");
        System.out.println(queue.dequeue()); // Output: osman
        System.out.println(queue.dequeue()); // Output: banana
        System.out.println(queue.dequeue()); // Output: cherry
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.size()); // Output: 1



        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");
        System.out.println(stack.pop()); // Output: cherry
        System.out.println(stack.pop()); // Output: banana
        System.out.println(stack.pop()); // Output: apple

    }


    public static void algoSelector(int[] arr) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1 for Bubble sort, type 2 for Selection sort.");

        int algoType = scanner.nextInt();

        System.out.println("Type 1 for sorted in Ascending order, 2 for Descending.");
        int sortAD = scanner.nextInt();

        if (algoType == 1) {
            bubbleSort(arr, sortAD);
            System.out.println("Array sorted using Bubble Sort:");
            printArray(arr);
        } else if (algoType == 2) {

            selectionSort(arr, sortAD);
            System.out.println("Array sorted using Selection Sort:");
            printArray(arr);

        } else {
            System.out.println("wrong selection, select again");
            algoSelector(arr);
        }

        // Close the scanner since we are done
        scanner.close();
    }

    public static void selectionSort(int[] arr, int sort) {
        int n = arr.length;

        if (sort == 1) {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;


                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }


                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        } else if (sort == 2) {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;


                for (int j = i + 1; j < n; j++) {
                    if (arr[j] > arr[minIndex]) {
                        minIndex = j;
                    }
                }


                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

        }
    }

    public static void bubbleSort(int[] arr, int sort) {
        int n = arr.length;

        if (sort == 1) {
            // Iterate over the array then compare each element
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // If the previous element is BIGGER than the next one,
                        // create a temporary variable to hold it,
                        // then switch places (Basically Bubble Sort)
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

        } else if (sort == 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        // If the previous element is SMALLER than the next one,
                        // create a temporary variable to hold it,
                        // then switch places
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

        }


    }


    // Helper method for printing an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static class ResizingArrayQueueAndStackOfStrings {


        class StringQueue {
            private String[] data;
            private int head;
            private int tail;
            private int size;

            public StringQueue(int initialCapacity) {
                data = new String[initialCapacity];
                head = 0;
                tail = 0;
                size = 0;
            }

            public void enqueue(String element) {
                if (tail == data.length) {
                    resize();
                }
                data[tail++] = element;
                size++;
            }

            public String dequeue() {
                if (head == tail) {
                    return null;
                }
                String element = data[head];
                head++;
                size--;
                return element;
            }

            public int size() {
                return size;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            private void resize() {
                String[] newData = new String[data.length * 2];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
            }
        }


        class StringStack {
            private String[] data;
            private int top;

            public StringStack(int initialCapacity) {
                data = new String[initialCapacity];
                top = -1;
            }

            public void push(String element) {
                if (top == data.length - 1) {
                    resize();
                }
                data[++top] = element;
            }

            public String pop() {
                if (top < 0) {
                    return null;
                }
                String element = data[top];
                data[top--] = null;
                return element;
            }

            public int size() {
                return top + 1;
            }

            public boolean isEmpty() {
                return top < 0;
            }

            private void resize() {
                String[] newData = new String[data.length * 2];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
            }
        }
    }


}
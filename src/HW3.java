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

        // Initiate the scanner
        Scanner scanner = new Scanner(System.in);

        // Initiate classes
        MergeSortTD mergeTD = new MergeSortTD();
        MergeSortBottomUp mergeBU = new MergeSortBottomUp();
        Quicksort quicksort = new Quicksort();

        // Ask for the size of the array to create one
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();


        // Initiate the array with the size
        int[] arr = new int[n];

        System.out.println("Generating array with " + n + " elements...");
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(255);
        }


        System.out.println("your randomly generate array is: ");
        printArray(arr);

        System.out.println("Sorting the array using Merge Sort Top Down...");
        long startTime = System.nanoTime();
        mergeTD.sort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double seconds = ((double) duration / 1000000000);
        System.out.println("Top Down took " + seconds + " seconds(" +duration + " nanoseconds) to sort the array.");

        printArray(arr);

        System.out.println("Sorting the array using Merge Sort Bottom Up...");
        long startTime2 = System.nanoTime();
        mergeBU.sort(arr);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        double seconds2 = ((double) duration2 / 1000000000);
        System.out.println("Top Down took " + seconds2 + " seconds(" +duration2 + " nanoseconds) to sort the array.");
        printArray(arr);

        System.out.println("Sorting the array using Quick Sort...");
        long startTime3 = System.nanoTime();
        quicksort.sort(arr);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        double seconds3 = ((double) duration3 / 1000000000);
        System.out.println("Quicksort took " + seconds3 + " seconds(" +duration3 + " nanoseconds) to sort the array.");
        printArray(arr);


        scanner.close();





         /*
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
        */

        /* ******************************************************************************** */




        /*
         * Reads a sequence of pairs of integers (Must be between 0 and 19 for our case)
         *  from standard input, where each integer
         * in the pair represents some element
         * if the elements are in different sets, merge the two sets
         * and print the pair to standard output.
         */
        // ----------------------------------------------------------------------------------------------
        /* QUICK FIND + QUICK UNION

        Scanner sc = new Scanner(System.in);

        QuickUnion uf = new QuickUnion(20);

        System.out.println("Enter numbers between 0 and 19, CTRL+D to break out of loop.");

        while (sc.hasNext()) {


            int p = sc.nextInt();
            int q = sc.nextInt();
            if ((p > 20 || p < 0)){
                System.out.println("Your entries must be between 0 and 19!");
                System.out.println("Entry reset to 0.");
                p = 0;
            }
            if ((q > 20 || q < 0)){
                System.out.println("Your entries must be between 0 and 19!");
                System.out.println("Entry reset to 0.");
                q = 0;
            }
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);


        }


        System.out.println(uf.count() + " components");
        System.out.println(uf.getExchangeCounter() + " exchanges");
        System.out.println(uf.getFindCounter() + " finds");

        sc.close();


         */

        /*
        QuickUnionPC qu = new QuickUnionPC(5);
        qu.union(1, 2);
        qu.union(2, 3);
        qu.union(3, 4);

        System.out.println("Components: " + qu.count());
        System.out.println("Size of component containing 1: " + qu.size(1));

         */


    }


    public static void algoSelector(int[] arr) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1 for Bubble sort,  2 for Selection sort, 3 for Insertion sort.");

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

        } else if (algoType == 3) {

            long startTime = System.nanoTime();
            insertionSort(arr, sortAD);
            long endTime = System.nanoTime();
            System.out.println("Array sorted using Insertion Sort:");
            printArray(arr);
            long duration = (endTime - startTime);
            double seconds = ((double) duration / 1000000000);
            System.out.println("Insertion Sort took " + seconds + " seconds(" +duration + " nanoseconds) to sort the array.");

        } else {
            System.out.println("wrong selection, select again");
            algoSelector(arr);
        }

        // Close the scanner since we are done
        scanner.close();
    }

    public static void insertionSort(int[] arr, int sort) {
        int n = arr.length;

        if (sort == 1) {
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        } else if (sort == 2) {
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }

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


    static class QuickFind {

        private int[] id;
        private int count;
        private int exchangeCounter;
        private int findCounter;


        public QuickFind(int n) {
            exchangeCounter = 0;
            findCounter = 0;
            count = n;
            id = new int[n];
            for (int i = 0; i < n; i++)
                id[i] = i;
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            validate(p);
            findCounter++;
            return id[p];
        }

        private void validate(int p) {
            int n = id.length;
            if (p < 0 || p >= n) {
                throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
            }
        }

        public void union(int p, int q) {
            validate(p);
            validate(q);

            int pID = id[p];   // needed for correctness
            int qID = id[q];   // to reduce the number of array accesses

            // p and q are already in the same component
            if (pID == qID) return;

            for (int i = 0; i < id.length; i++)
                if (id[i] == pID) id[i] = qID;
            count--;
            exchangeCounter++;
        }

        public int getExchangeCounter() {
            return exchangeCounter;
        }

        public int getFindCounter() {
            return findCounter;
        }

    }

    static class QuickUnion {

        private int[] parent;
        private int count;
        private int exchangeCounter;
        private int findCounter;

        public QuickUnion(int n) {
            exchangeCounter = 0;
            findCounter = 0;
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            validate(p);

            while (p != parent[p])
                p = parent[p];
            findCounter++;
            return p;
        }

        // validate that p is a valid index
        private void validate(int p) {
            int n = parent.length;
            if (p < 0 || p >= n) {
                throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            exchangeCounter++;
            count--;
        }

        public int getExchangeCounter() {
            return exchangeCounter;
        }

        public int getFindCounter() {
            return findCounter;
        }
    }

    static class QuickUnionPC {
        private int[] id;
        private int[] sz;
        private int count;

        public QuickUnionPC(int n) {
            id = new int[n];
            sz = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            // link every site on the paths from p and q to the roots of their trees to the root of the new tree
            for (int k = 0; k < id.length; k++) {
                if (id[k] == pRoot || id[k] == qRoot) {
                    id[k] = pRoot;
                }
            }

            // update the size of the new tree
            sz[pRoot] += sz[qRoot];

            // decrement the count of components
            count--;
        }

        public int count() {
            return count;
        }

        public int size(int p) {
            return sz[find(p)];
        }
    }

    static class MergeSortTD {

            private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
                // copy to aux[]
                for (int k = lo; k <= hi; k++) {
                    aux[k] = a[k];
                }

                // merge back to a[]
                int i = lo, j = mid + 1;
                for (int k = lo; k <= hi; k++) {
                    if (i > mid) a[k] = aux[j++];
                    else if (j > hi) a[k] = aux[i++];
                    else if (aux[j] < aux[i]) a[k] = aux[j++];
                    else a[k] = aux[i++];
                }
            }

            private static void sort(int[] a, int[] aux, int lo, int hi) {
                if (hi <= lo) return;
                int mid = lo + (hi - lo) / 2;
                sort(a, aux, lo, mid);
                sort(a, aux, mid + 1, hi);
                merge(a, aux, lo, mid, hi);
            }

            public static void sort(int[] a) {
                int[] aux = new int[a.length];
                sort(a, aux, 0, a.length - 1);
            }


    }

    static class MergeSortBottomUp{

            private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
                // copy to aux[]
                for (int k = lo; k <= hi; k++) {
                    aux[k] = a[k];
                }

                // merge back to a[]
                int i = lo, j = mid + 1;
                for (int k = lo; k <= hi; k++) {
                    if (i > mid) a[k] = aux[j++];
                    else if (j > hi) a[k] = aux[i++];
                    else if (aux[j] < aux[i]) a[k] = aux[j++];
                    else a[k] = aux[i++];
                }
            }

            public static void sort(int[] a) {
                int n = a.length;
                int[] aux = new int[n];
                for (int len = 1; len < n; len *= 2) {
                    for (int lo = 0; lo < n - len; lo += len + len) {
                        int mid = lo + len - 1;
                        int hi = Math.min(lo + len + len - 1, n - 1);
                        merge(a, aux, lo, mid, hi);
                    }
                }
            }
    }

    static class Quicksort {

        private static int partition(int[] a, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            int v = a[lo];
            while (true) {

                // find item on lo to swap
                while (a[++i] < v) {
                    if (i == hi) break;
                }

                // find item on hi to swap
                while (v < a[--j]) {
                    if (j == lo) break;      // redundant since a[lo] acts as sentinel
                }

                // check if pointers cross
                if (i >= j) break;

                exch(a, i, j);
            }

            // put partitioning item v at a[j]
            exch(a, lo, j);

            // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
            return j;
        }

        public static void sort(int[] a) {

            sort(a, 0, a.length - 1);
        }

        // quicksort the subarray from a[lo] to a[hi]
        private static void sort(int[] a, int lo, int hi) {
            if (hi <= lo) return;
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }

        private static void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }


    }


}
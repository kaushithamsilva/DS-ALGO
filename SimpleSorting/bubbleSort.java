package SimpleSorting;

class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void bubbleSort() {
        int in, out;
        for (out = nElems - 1; out > 1; out--) // outer loop backwards
            for (in = 0; in < out; in++) // inner loop forward
                if (a[in] > a[in + 1]) // if left element is taller than the right element
                    swap(in, in + 1); // swap them

    }
}

public class bubbleSort {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayBub arr; // reference to array
        arr = new ArrayBub(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        arr.bubbleSort(); // bubble sort them
        arr.display(); // display them again
    }
}

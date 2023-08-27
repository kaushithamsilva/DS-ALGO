package SimpleSorting;

class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    public void selectionSort() {
        int min, in, out;

        for (out = 0; out < nElems; out++) { // outer loop (look through N elements, N-1 elememts, N-2 elements..)
            min = out; // starting index assigned as minimum
            for (in = out + 1; in < nElems; in++) // inner loop, loop thorugh the remaining array (to the right)
                if (a[in] < a[min]) // if a smaller number is found
                    min = in;

            // swap the two numbers in the indices min and out
            swap(min, out);
        }

    }
}

public class selectionSort {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArraySel arr; // reference to array
        arr = new ArraySel(maxSize); // create the array
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
        arr.selectionSort(); // bubble sort them
        arr.display(); // display them again
    }
}

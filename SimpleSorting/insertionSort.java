package SimpleSorting;

class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
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

    public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out]; // marked item
            for (in = out; in > 0 && a[in - 1] >= temp; in--)
                a[in] = a[in - 1];// shift item right

            a[in] = temp; // insert marked item
        }

    }

    public double median() {
        insertionSort();
        return nElems % 2 == 0 ? (a[nElems / 2] + a[nElems / 2 - 1]) / 2.0 : a[nElems / 2];
    }

    public int getSize() {
        return nElems;
    }

    public void noDups() {
        int i;

    }
}

public class insertionSort {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayIns arr; // reference to array
        arr = new ArrayIns(maxSize); // create the array
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
        arr.insertionSort(); // bubble sort them
        arr.display(); // display them again

        System.out.println(arr.median());
        arr.insert(33);
        arr.insert(66);
        arr.insertionSort();
        arr.display();

        arr.noDups();
        arr.display();

    }
}

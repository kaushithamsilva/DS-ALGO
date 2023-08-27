package Arrays;

interface List {
    abstract public int find(long searchKey);

    abstract public boolean delete(long value);

    abstract public void display();

    abstract public void insert(long value);

    abstract public int size();
}

class HighArray implements List {
    private long[] a;
    private int nElems;

    HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int find(long searchKey) {
        int j;
        for (j = 0; j < nElems && a[j] != searchKey; j++)
            ; // iterate through each item and look for it

        return j != nElems ? j : -1; // 0 <= j < nElems ==> element is present
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public boolean delete(long value) {
        // returns true if deleted successfully
        // returns false if not found

        int j = find(value);
        if (j == -1)
            return false; // element not found

        // Element found, delete it and move higher ones down
        for (int k = j; k < nElems; k++)
            a[k] = a[k + 1]; // moving each item down, overwriting the a[j] element

        nElems--;
        return true;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public int size() {
        return nElems;
    }

    public long[] getA() {
        return a;
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);
        arr.insert(10);
        arr.insert(11);
        arr.insert(15);
        arr.insert(12);

        arr.display();

        int searchKey = 10;
        if (arr.find(searchKey) != -1)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(10);
        arr.delete(25);
        arr.display();

    }

}
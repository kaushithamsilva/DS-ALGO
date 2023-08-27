package Arrays;

class OrdArray {
    private long[] a;
    private int nElems;

    OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;

            else if (lowerBound > upperBound)
                return -1;

            if (a[curIn] < searchKey)
                lowerBound = curIn + 1; // in Upper Half
            else
                upperBound = curIn - 1; // in Lower Half
        }
    }

    public void insert(long value) {
        int j;
        // find position to insert
        for (j = 0; j < nElems && a[j] <= value; j++)
            ;

        // shift one up
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];

        a[j] = value; // insert
        nElems++;

    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == -1)
            return false;

        for (int k = j; k < nElems; k++)
            a[k] = a[k + 1];

        nElems--;
        return true;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

}

class orderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;

        arr = new OrdArray(maxSize);
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

        int searchKey = 55; // search for item
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);
        arr.display(); // display items
        arr.delete(00); // delete 3 items
        arr.delete(55);
        arr.delete(99);
        arr.display(); // display items again
    }
}

package SimpleSorting;

class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print("    Last Name: " + lastName);
        System.out.print(", First Name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems++] = new Person(last, first, age);
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            a[j].displayPerson();
        System.out.println();

    }

    public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            Person temp = a[out];

            // sort by Last Name Lexicographically and if the names are same then compare by
            // age
            for (in = out; in > 0 &&
                    (a[in - 1].getLastName().compareTo(temp.getLastName()) > 0
                            || // if not
                            a[in - 1].getLastName().compareTo(temp.getLastName()) == 0 && // if names are equal
                                    a[in - 1].getAge() >= a[in].getAge()); in--) // using String Method compareTo
                a[in] = a[in - 1]; // shift person

            a[in] = temp; // insert marked person

        }
    }

}

public class objectSort {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayInOb arr; // reference to array
        arr = new ArrayInOb(maxSize); // create the array
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);
        System.out.println("Before sorting:");
        arr.display(); // display items
        arr.insertionSort(); // insertion-sort them
        System.out.println("After sorting:");
        arr.display(); // display them again
    }
}

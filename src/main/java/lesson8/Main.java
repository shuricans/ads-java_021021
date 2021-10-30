package lesson8;

public class Main {

    public static void main(String[] args) {
        var hashTable = new HashTableChainImpl<>(2); //2*2

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(67, "Carrot"), 228);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(51, "Milk"), 120);
        hashTable.put(new Product(21, "Potato"), 67);

        System.out.println("put [Orange - 150, Banana - 100, Carrot - 228, Lemon - 250, Milk - 120, Potato - 67]");
        hashTable.display();
        System.out.println("Size is " + hashTable.size());
        System.out.println();

        hashTable.put(new Product(77, "Banana"), 120);
        hashTable.put(new Product(12, "Tomato"), 50);
        hashTable.put(new Product(10, "Cherry"), 180);

        System.out.println("put [Banana - 120, Tomato - 50, Cherry - 180]");
        hashTable.display();
        System.out.println("Size is " + hashTable.size());
        System.out.println();


        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        hashTable.remove(new Product(77, "Banana"));
        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(10, "Cherry"));

        System.out.println();
        System.out.println("remove [Banana, Potato, Cherry]");
        System.out.println();

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        hashTable.display();
        System.out.println("Size is " + hashTable.size());

        System.out.println();
        hashTable.put(new Product(47, "Pineapple"), 228);
        System.out.println("put [Pineapple - 228]");

        hashTable.display();
        System.out.println("Size is " + hashTable.size());
    }
}

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SparseThreeDimensionalList list = new SparseThreeDimensionalList();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.set(random.nextInt(200),random.nextInt(200),random.nextInt(200),random.nextInt(200) );
        }
        list.printList();
        System.out.println("_______________________");
        list.sort_nonempty();
        list.printList();
    }
}

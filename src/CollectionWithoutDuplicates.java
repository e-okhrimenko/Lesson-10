import java.util.*;

public class CollectionWithoutDuplicates {
    public static void main(String[] args) {
        //Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.

        ArrayList arrayList = new ArrayList<>();
        arrayList.add("ArrayList E01");
        arrayList.add("ArrayList E02");
        arrayList.add("ArrayList E03");
        arrayList.add("ArrayList E01");
        arrayList.add("ArrayList E02");
        arrayList.add("ArrayList E03");

        LinkedList linkedList = new LinkedList<>();
        linkedList.add("LinkedList E01");
        linkedList.add("LinkedList E02");
        linkedList.add("LinkedList E03");
        linkedList.add("LinkedList E01");
        linkedList.add("LinkedList E02");
        linkedList.add("LinkedList E03");

        System.out.println("Old arrayList: " + arrayList);
        arrayList = new ArrayList<>(antiDuplicator(arrayList));
        System.out.println("New arrayList: " + arrayList);
        System.out.println();
        System.out.println("Old linkedList: " + linkedList);
        linkedList = new LinkedList<>(antiDuplicator(linkedList));
        System.out.println("New linkedList: " + linkedList);
    }

    static Collection antiDuplicator(Collection c) {
        return new HashSet<>(c);
    }
}
package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        addInOrder(linkedList,"Fis");
        addInOrder(linkedList,"Fis");
        addInOrder(linkedList, "Fispitt");
        addInOrder(linkedList, "ff");
        addInOrder(linkedList, "FSA");
        addInOrder(linkedList, "Putte");

        System.out.println(linkedList);

    }

    public static boolean addInOrder(LinkedList<String> linkedList, String entry) {
        ListIterator<String> listIterator = linkedList.listIterator();

        while (listIterator.hasNext()) {
            int comp = listIterator.next().compareTo(entry);
            if (comp == 0) {
                System.out.println("Item already present");
                return false;
            } else if (comp > 0) {
                listIterator.previous();
                listIterator.add(entry);
                return true;
            } else {
                // Do nothing
            }
        }
        listIterator.add(entry);
        return true;
    }
}

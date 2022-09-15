package collections.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example of how to create a deep copy of a list containing objects
 */
public class DeepCopyDemo {
    public static void main(String[] args) {
        List<ExampleObject> origList = new ArrayList<>();
        origList.add(new ExampleObject("hej"));
        List<ExampleObject> copyList = new ArrayList<>(origList);

        // The lists are both referring to the same objects, aka. we made a shallow copy of the origList when creating copyList
        origList.add(new ExampleObject("då"));
        origList.get(0).setFlagged();
        System.out.println(origList.get(0).isFlagged());
        System.out.println(copyList.get(0).isFlagged());
        origList.get(0).setValue("homo");


        System.out.println(origList);
        System.out.println(copyList);

        // COMPARABLE & COMPARATOR
        ExampleObject exampleObject = new ExampleObject("Comparable example");
        exampleObject.addInnerObject("Inner", 3);
        exampleObject.addInnerObject("Inner2", 1);
        exampleObject.addInnerObject("Inner3", 2);
        System.out.println(exampleObject.getInnerObjectList());
        Collections.sort(exampleObject.getInnerObjectList());
        System.out.println(exampleObject.getInnerObjectList());

        // Using a one time sorter using a comparator
        Collections.sort(exampleObject.getInnerObjectList(), ExampleObject.STRING_ORDER);
        System.out.println(exampleObject.getInnerObjectList());



    }
}

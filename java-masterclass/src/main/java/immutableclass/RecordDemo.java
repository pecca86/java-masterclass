package immutableclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordDemo {

    public static void main(String[] args) {

        ImmutableClass immutableClass = new ImmutableClass(36, "Pekka");
        System.out.println(immutableClass.age());
        System.out.println(immutableClass.name());

        ImmutableClass im2 = new ImmutableClass(40, "FisFjalle");
        ImmutableClass im3 = new ImmutableClass(50, "FisFjalle");

        List<ImmutableClass> immutableClassList = new ArrayList<>();
        immutableClassList.add(immutableClass);
        immutableClassList.add(im3);
        immutableClassList.add(im2);
        System.out.println(immutableClassList);
        Collections.sort(immutableClassList);
        System.out.println(immutableClassList);

    }
}

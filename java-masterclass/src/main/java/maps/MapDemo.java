package maps;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> people = new HashMap<>();
        people.put("Pekka", "A good lookin' fella");
        people.put("Jarkko", "A victim of the ugly stick");
        people.put("Pernilla", "Good body, face... meh...");

        System.out.println(people.get("Pekka"));

        System.out.println(people.getOrDefault("homo", "Not present"));
        System.out.println(people.putIfAbsent("Pekka", "Dildo-man")); // Returns the present value if not absent
        System.out.println(people.get("Pekka"));

        for (String key : people.keySet()) {
            System.out.println(key + " : " + people.get(key));
        }

        // You can remove by just key, or key/value (BOTH need to match)
        if (people.remove("Pekka", "Super ugly")) {
            System.out.println("Pekka was removed");
        } else {
            System.out.println("Pekka not removed, reason: Is a good lookin' fella");
        }

    }
}

package inputoutput;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, String> {

    private static Map<Integer, String> locations = new HashMap<>();

    // Is initialize upon creating a new instance of this object
    static {
        locations.put(0, "start");
        locations.put(99, "end");

        //BufferedReader reads chunks of data, and are therefore more efficient
        try(Scanner in = new Scanner(new BufferedReader(new FileReader("map.txt")))) {
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Bitchin' file is missin'!");
        }
    }

    public void loadMap() throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter("map.txt");
            for (Integer key : locations.keySet()) {
                fw.write(key + " ==> " + locations.get(key) + "\n");
            }
        } finally {
            fw.close();
        }
    }

    public void readFile() {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileReader("bitches.txt"));
            scanner.useDelimiter(" ");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                //scanner.skip(scanner.delimiter());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file!");
        } finally {
            scanner.close();
        }
    }

    /**
     * Using a try-with IO statement which automatically closes the file after done.
     * 'throws' lets the program calling the method handle the IOException
     */
    public void putLoadInYoMoma() throws IOException {
        // Opening multiple FileWriters inside same try-with block
        try(FileWriter fw = new FileWriter("yo_moma.txt");
            FileWriter bitches = new FileWriter("bitches.txt")
        ) {
            for (Integer key : locations.keySet()) {
                fw.write(key + " --> " + locations.get(key) + "\n");
                bitches.write(locations.get(key) + " fucking\n");
            }
        }
    }


    public void writeWithBufferedWriter() throws IOException {
        try(BufferedWriter out = new BufferedWriter(new FileWriter("cocks.txt"))) {
            for (int i = 0; i < 10; i++) {
                out.write(i+"\n");
            }
        }
    }



    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return locations.get(key);
    }

    @Override
    public String put(Integer key, String value) {
        return locations.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends String> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<String> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return locations.entrySet();
    }
}

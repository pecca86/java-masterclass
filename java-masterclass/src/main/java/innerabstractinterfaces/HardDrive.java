package innerabstractinterfaces;

import java.util.ArrayList;
import java.util.List;

public class HardDrive{

    List<ISaveable> data = new ArrayList<>();


    public HardDrive() {
    }

    public void save(ISaveable data) {
        this.data.add(data);
        System.out.println("Data successfully saved to disk.");
    }

    @Override
    public String toString() {
        return "HardDrive contains the following files: \n" +
                "data:" + data;
    }
}

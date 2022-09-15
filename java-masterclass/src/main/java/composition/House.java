package composition;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String address;
    private List<Room> rooms = new ArrayList<>();

    public House(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    public void addRoom(Room room) {
        if (room == null) {
            System.out.println("Empty room");
        } else {
            this.rooms.add(room);
        }
    }
}

package composition;

public class HouseBuilder {

    public static void main(String[] args) {
        Sofa sofa = new Sofa(100, 20);
        Chair chair = new Chair(20, 4);

        Room room = new Room(5000, 6000);
        room.addFurniture(sofa);
        room.addFurniture(chair);

        Room bedRoom = new Room(500, 1000);
        bedRoom.addFurniture(chair);


        House house = new House("Pjukalavägen 115, 21600 PARGAS");
        house.addRoom(room);
        house.addRoom(bedRoom);

        System.out.println(house);
    }
}

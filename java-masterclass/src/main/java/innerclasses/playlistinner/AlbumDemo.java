package innerclasses.playlistinner;

public class AlbumDemo {
    public static void main(String[] args) {
        Album album = new Album("Led Zeppelin - Whole lotta love", 1974);
        album.addSongToSongList("Whole lotta love");
        album.addSongToSongList("Stairway to heaven");
        album.addSongToSongList("Communication breakdown");

        album.findSongFromSongList("Whole lotta love");
        album.findSongFromSongList("Going to california");

        System.out.println(album);
    }
}

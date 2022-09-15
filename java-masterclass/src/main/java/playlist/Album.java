package playlist;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumName;
    List<Song> albumSongs = new ArrayList<>();

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public List<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void addSong(Song song) {
        this.albumSongs.add(song);
    }

    public void printAlbumSongs() {

    }
}

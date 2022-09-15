package innerclasses.playlistinner;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private SongList songList;
    private String title;
    private int releaseYear;

    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        songList = new SongList();
    }

    public void addSongToSongList(String song) {
        songList.addSong(song);
    }

    public void findSongFromSongList(String song) {
        if (songList.findSong(song)) {
            System.out.println("Song list is found on this album.");
        } else {
            System.out.println("This song is not on this album.");
        }
    }

    @Override
    public String toString() {
        return "Album{" +
                "songList=" + songList +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    private class SongList {
        private List<String> songs = new ArrayList<>();

        public SongList() {}

        public void addSong(String song) {
            this.songs.add(song);
            System.out.println("Added " + song);
        }

        public boolean findSong(String song) {
            if (this.songs.contains(song)) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "SongList{" +
                    "songs=" + songs +
                    '}';
        }
    }
}

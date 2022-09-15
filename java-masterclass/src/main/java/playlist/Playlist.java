package playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Quit, Skip forward, skip backward, replay current, List songs in playlist
 * Song must exist on an album in order to be added.
 */

public class Playlist {

    LinkedList<Song> playList = new LinkedList<>();
    int playlistPosition = 0;

    public Playlist() {
    }

    public void addSongFromAlbum(Album album, Song song) {
        if (!album.getAlbumSongs().contains(song)) {
            System.out.println("Song does not exist in album");
        }
        playList.add(song);
        System.out.println("Successfully added " + song + " to the playlist");
    }

    public void play() {
        showCurrentSong();
    }

    public void skipBackwards() {
        System.out.println("Skipping one track forward");
        this.playList.poll();
    }

    public void skipForward() {
        //
    }

    public void replay() {
        //
    }

    public void showPlaylist() {

    }

    public void showMenu() {

    }

    private void showCurrentSong() {
        System.out.println("Now playing: " + playList.peek());
    }
}

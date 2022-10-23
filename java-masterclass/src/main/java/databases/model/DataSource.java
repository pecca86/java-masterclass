package databases.model;

import org.sqlite.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/pekkaranta-aho/Coding/Java/Udemy/javamaster/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final String COLUMN_SONG_ID = "_id";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    // Prepared SQL statement
    public static final String QUERY_ARTIST_PREP = "SELECT * FROM " + TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS + " ON albums.artist = artists._id " + "WHERE artists.name = ?";
    private PreparedStatement queryArtistAlbums;

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryArtistAlbums = conn.prepareStatement(QUERY_ARTIST_PREP);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artist> queryAllArtists(SortOrder sortOrder) {
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS + " ORDER BY " + INDEX_ARTIST_NAME + " " + sortOrder.orderType);) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Album> queryArtistAlbums(String artistName) {
        try {
            queryArtistAlbums.setString(1, artistName);
            System.out.println(queryArtistAlbums.getParameterMetaData());
            ResultSet results = queryArtistAlbums.executeQuery();
            List<Album> albums = new ArrayList<>();
            while (results.next()) {
                Album album = new Album();
                album.setName(results.getString("name"));
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

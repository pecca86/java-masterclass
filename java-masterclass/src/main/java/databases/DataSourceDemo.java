package databases;

import databases.model.Album;
import databases.model.Artist;
import databases.model.DataSource;
import databases.model.SortOrder;

import java.util.Comparator;
import java.util.List;

public class DataSourceDemo {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Connection failed");
            return;
        }

        List<Artist> aristList = dataSource.queryAllArtists(SortOrder.NONE);
//        aristList.stream()
//                .forEach(System.out::println);

        String artist = "Iron Maiden";
        System.out.println(artist + " albums:");
        List<Album> albums = dataSource.queryArtistAlbums(artist);
        albums.forEach(a -> System.out.println(a.getName()));

        dataSource.close();
    }
}

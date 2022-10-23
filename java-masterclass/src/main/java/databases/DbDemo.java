package databases;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DbDemo {
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_TITLE = "title";

    public static void main(String[] args) {
        connectToDb();
    }

    public static void connectToDb() {
        try(final Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/pekkaranta-aho/Coding/Java/Udemy/javamaster/music.db")) {
            Statement statement = conn.createStatement();
            //statement.execute("INSERT INTO artists VALUES(10000, 'KAKKA-MIES')");


            ResultSet results = statement.executeQuery("SELECT * FROM songs LIMIT 5");
            while (results.next()) {
                System.out.println(results.getString("title"));
            }

            ResultSet results2 = statement.executeQuery("SELECT " + COLUMN_TITLE + " FROM songs LIMIT 5 OFFSET 5");
            System.out.println("\nSECOND: ");
            while (results2.next()) {
                System.out.println(results2.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertArtist(Statement statement, int id, String title) {

    }
}

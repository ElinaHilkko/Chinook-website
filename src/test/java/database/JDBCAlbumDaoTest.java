package database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Album;

public class JDBCAlbumDaoTest {
	
	private JDBCAlbumDao dao = new JDBCAlbumDao();
	
    @BeforeEach
    public void setUp() throws SQLException {
        String deleteAll = "DELETE FROM Album";
        String insertTwo = "INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (1, 'Stop', 1), (2, 'Vuokralainen', 1), (3, 'Revolution', 2)";

        Database db = new Database();
        Connection connection = db.connect();

        PreparedStatement deleteStatement = connection.prepareStatement(deleteAll);
        deleteStatement.executeUpdate();

        PreparedStatement insertStatement = connection.prepareStatement(insertTwo);
        insertStatement.executeUpdate();

        deleteStatement.close();
        insertStatement.close();
        connection.close();
    }
    
    @Test
    public void testGetAlbumsByArtistId() {
    	List<Album> albums = dao.getAlbumsByArtistId(1);
    	String titles = "";
    	for (Album album: albums) {
    		titles = titles + " " + album.getTitle();
    	}
    	assertEquals(" Stop Vuokralainen", titles);
    }
    
    @Test
    public void testGetAlbumsByTitle() {
    	List<Album> albums = dao.getAlbumsByTitle("Revolu");
    	String titles = "";
    	for (Album album: albums) {
    		titles = titles + album.getTitle();
    	}
    	assertEquals("Revolution", titles);
    }
}

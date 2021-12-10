package database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Artist;

public class JDBCArtistDaoTest {
	
	private JDBCArtistDao dao = new JDBCArtistDao();
	
    @BeforeEach
    public void setUp() throws SQLException {
        String deleteAll = "DELETE FROM Artist";
        String insertTwo = "INSERT INTO Artist (ArtistId, Name) VALUES (1, 'Abreu'), (2, 'Adele'), (3, 'Danny')";

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
    public void testFirstArtist() {
    	List<Artist> artists = dao.getAllArtist();
    	Artist first = artists.get(0);
    	
    	assertEquals("Abreu", first.getName());
    }
    
    @Test
	public void testAddArtist() {
		Artist newArtist = new Artist("Frederik");
		assertTrue(dao.addArtist(newArtist));
	}
    
    @Test
    public void testGetArtistByArtistId() {
    	Artist artist = dao.getArtistByArtistId(2);
    	assertEquals("Adele", artist.getName());
    }
    @Test
    public void testGetArtistsByName() {
    	List<Artist> artists = dao.getArtistsByName("Dan");
    	String names = "";
    	for (Artist artist: artists) {
    		names = names + artist.getName();
    	}
    	assertEquals("Danny", names);
    }
}
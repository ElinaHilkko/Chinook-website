package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class JDBCArtistDao implements ArtistDao {

	private Database db = new Database();
	
	@Override
	public List<Artist> getAllArtist() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> allArtists = new ArrayList<>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");

				Artist a = new Artist(id, name);
				allArtists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allArtists;
	}

	@Override
	public boolean addArtist(Artist newArtist) {
		String add = "INSERT INTO Artist (name) VALUES (?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(add);
			statement.setString(1, newArtist.getName());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.db.close(connection, statement, null);
		}
	}
	
	@Override
	public Artist getArtistByArtistId(long artistId) {
		String selectById = "SELECT ArtistId, Name FROM Artist WHERE ArtistId = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectById);
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			while (results.next()) {
				Artist artist = new Artist(results.getLong("ArtistId"), results.getString("Name")); 
			return artist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
	}
	
	@Override
	public List<Artist> getArtistsByName(String name) {
		String selectByName = "SELECT ArtistId, Name  FROM Artist WHERE Name LIKE ? ORDER BY Name ASC";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		List<Artist> artists = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectByName);
			statement.setString(1, "%" + name + "%");
			results = statement.executeQuery();
			while (results.next()) {
				Artist artist = new Artist(results.getLong("ArtistId"), results.getString("Name"));
				artists.add(artist);
			} 
			return artists;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
	}
}

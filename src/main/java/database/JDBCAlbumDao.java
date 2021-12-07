package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class JDBCAlbumDao {
	
	private Database db = new Database();
	
	public List<Album> getAlbumsByArtistId(long artistId) {
		String selectAlbums = "SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ? ORDER BY Title ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> albums = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAlbums);
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			while (results.next()) {
				long albumId = results.getLong("AlbumId");
				String title = results.getString("Title");

				Album a = new Album(albumId, title, artistId);
				albums.add(a);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return albums;
	}

}

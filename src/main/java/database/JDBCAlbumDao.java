package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class JDBCAlbumDao implements AlbumDao {
	
	private Database db = new Database();
	
	@Override
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
	
	@Override
	public List<Album> getAlbumsByTitle(String title) {
		String select = "SELECT AlbumId, Title, ArtistId  FROM Album WHERE Title LIKE ? ORDER BY Title ASC";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		List<Album> albums = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(select);
			statement.setString(1, "%" + title + "%");
			results = statement.executeQuery();
			while (results.next()) {
				Album album = new Album(results.getLong("AlbumId"), results.getString("Title"), results.getLong("ArtistId"));
				albums.add(album);
			} 
			return albums;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
	}

}

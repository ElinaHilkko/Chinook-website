package database;

import java.util.List;

import model.Album;

public interface AlbumDao {
	
	public List<Album> getAlbumsByArtistId(long artistId);
	
	public List<Album> getAlbumsByTitle(String title);

}

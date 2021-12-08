package database;

import java.util.List;

import model.Artist;

public interface ArtistDao {
	
	public List<Artist> getAllArtist();
	
	public boolean addArtist(Artist newArtist);
	
	public Artist getArtistByArtistId(long artistId);
	
	public List<Artist> getArtistsByName(String name); 
}

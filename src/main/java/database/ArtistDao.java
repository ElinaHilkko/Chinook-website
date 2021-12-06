package database;

import java.util.List;

import model.Artist;

public interface ArtistDao {
	
	public List<Artist> getAllArtist();
	
	public boolean addArtist(Artist newArtist);
	
	//public ShoppingListItem getItem(long id);

	//public boolean removeItem(ShoppingListItem item);
}

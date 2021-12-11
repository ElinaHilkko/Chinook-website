package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCAlbumDao;
import database.JDBCArtistDao;
import model.Album;
import model.Artist;

@SuppressWarnings("serial")
@WebServlet("/albums")
public class AlbumsServlet extends HttpServlet{
	
	private JDBCAlbumDao albumDao = new JDBCAlbumDao();
	private JDBCArtistDao artistDao = new JDBCArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long artistId = Integer.parseInt(req.getParameter("ArtistId"));
		List<Album> albums = albumDao.getAlbumsByArtistId(artistId);
		Artist artist = artistDao.getArtistByArtistId(artistId);
		if(albums.isEmpty() && artist == null) {
			req.getRequestDispatcher("/WEB-INF/notFound.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("albums", albums);
			req.setAttribute("artist", artist);
			req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
		}
	}
}

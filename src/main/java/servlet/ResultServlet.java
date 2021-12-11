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
@WebServlet("/results")
public class ResultServlet extends HttpServlet {
	
	private JDBCArtistDao artistDao = new JDBCArtistDao();
	private JDBCAlbumDao albumDao = new JDBCAlbumDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameOrTitle = req.getParameter("nameOrTitle");
		
		List<Artist> foundArtists = artistDao.getArtistsByName(nameOrTitle);
		List<Album> foundAlbums = albumDao.getAlbumsByTitle(nameOrTitle);
		
		req.setAttribute("artists", foundArtists);
		req.setAttribute("albums", foundAlbums);
		
		req.getRequestDispatcher("/WEB-INF/results.jsp").forward(req, resp);
	}
}

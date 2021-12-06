package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCArtistDao;
import model.Artist;

@WebServlet("/artistlist")
public class ArtistListServlet extends HttpServlet {

	private JDBCArtistDao dao = new JDBCArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = this.dao.getAllArtist();
		
		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String artistName = req.getParameter("name");
		
		Artist newArtist = new Artist(artistName);
		dao.addArtist(newArtist);
		resp.sendRedirect("/artistlist");
	}
}

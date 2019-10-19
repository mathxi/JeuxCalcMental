package controller;

import bo.Resultat;
import model.HomeBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet( name = "homeController", urlPatterns = {"/accueil"}, loadOnStartup = 1 )
public class HomeController extends HttpServlet {

    private static final String PAGE_HOME_JSP = "/WEB-INF/jsp/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession( true );

        HomeBean model = new HomeBean();
        List<Resultat> resultats = model.getTopTenResult();
        session.setAttribute( "topTenResult", resultats );
        request.getRequestDispatcher( PAGE_HOME_JSP ).forward( request, response );
    }
}

package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Tournoi;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListTournoi extends HttpServlet
{
    private TournoiDao tournoiDao;

    public void init()
    {
        tournoiDao = new TournoiDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            Filtre f = new Filtre(request);
            request.setAttribute("filter", f);
            request.setAttribute("tournois", tournoiDao.lister(f) );
            this.getServletContext().getRequestDispatcher("/WEB-INF/list_tournois.jsp").forward(request, response);
        } catch (BeanException |DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            String searchQuery = request.getParameter("searchQuery");
            List<Tournoi> tournois = tournoiDao.rechercher(searchQuery);
            if (tournois.size() ==  0) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_tournois_null.jsp").forward(request, response);
            } else {
                request.setAttribute("tournois", tournois);
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/list_tournois.jsp").forward(request, response);
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ListMatch extends HttpServlet
{
    private MatchDao matchDao;

    public void init()
    {
        matchDao = new MatchDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
//        for (String s : request.getParameterMap().keySet() ) { System.out.println(s); }
        try {
            Filtre f = new Filtre(request);
            request.setAttribute("filter", f);
            request.setAttribute("tournois", matchDao.getTournois() );
            request.setAttribute("annees", matchDao.getAnnees() );
            request.setAttribute("matchs", matchDao.lister(f) );
            this.getServletContext().getRequestDispatcher("/WEB-INF/list_matchs.jsp").forward(request, response);
        } catch (BeanException |DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            String searchQuery = request.getParameter("searchQuery");
            List<Match> matchs = matchDao.rechercher(searchQuery);
            if (matchs.size() ==  0) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_matchs_null.jsp").forward(request, response);
            } else {
                request.setAttribute("matchs", matchs);
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_matchs.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
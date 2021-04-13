package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Epreuve;
import com.mycompany.beans.Filtre;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ListEpreuve extends HttpServlet
{
    private EpreuveDao epreuveDao;

    public void init()
    {
        epreuveDao = new EpreuveDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            Filtre f = new Filtre(request);
            request.setAttribute("filter", f);
            request.setAttribute("tournois", epreuveDao.getTournois() );
            request.setAttribute("annees", epreuveDao.getAnnees() );
            request.setAttribute("epreuves", epreuveDao.lister(f) );
            this.getServletContext().getRequestDispatcher("/WEB-INF/list_epreuves.jsp").forward(request, response);
        } catch (BeanException |DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String searchQuery = request.getParameter("searchQuery");

        try {
            List<Epreuve> epreuves = epreuveDao.rechercher(searchQuery);
            if (epreuves.size() ==  0) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/listepreuves_null.jsp").forward(request, response);
            } else {
                request.setAttribute("epreuves", epreuves);
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_epreuves.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
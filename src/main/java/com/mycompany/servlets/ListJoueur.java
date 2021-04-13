package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListJoueur extends HttpServlet
{
    private JoueurDao joueurDao;

    public void init()
    {
        joueurDao = new JoueurDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            Filtre f = new Filtre(request);
            request.setAttribute("filter", f);
            request.setAttribute("joueurs", joueurDao.lister(f) );
            this.getServletContext().getRequestDispatcher("/WEB-INF/list_joueurs.jsp").forward(request, response);
//            throw new DaoException("Erreur de communication avec la Base de Données");
        } catch (BeanException|DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            String searchQuery = request.getParameter("searchQuery");
            List<Joueur> j = joueurDao.rechercher(searchQuery);
            if (j.size() ==  0) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_joueurs_null.jsp").forward(request, response);
            } else {
                request.setAttribute("joueurs", j);
                this.getServletContext().getRequestDispatcher("/WEB-INF/list_joueurs.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
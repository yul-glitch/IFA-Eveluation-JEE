package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Joueur;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjouterJoueur extends HttpServlet
{
    private JoueurDao joueurDao;

    public void init()
    {
        joueurDao = new JoueurDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_joueur.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            joueurDao.ajouter(new Joueur(request));
            response.sendRedirect(request.getContextPath() + "/private/list_joueurs");
        } catch (BeanException|DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
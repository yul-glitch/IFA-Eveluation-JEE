package com.mycompany.servlets;

import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SupprimerJoueur extends HttpServlet
{
    private JoueurDao joueurDao;

    public void init()
    {
        joueurDao = new JoueurDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        long id = Long.parseLong(request.getParameter("idjoueur") );
        try {
            joueurDao.supprimer(id);
            response.sendRedirect(request.getContextPath() + "/private/list_joueurs");
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
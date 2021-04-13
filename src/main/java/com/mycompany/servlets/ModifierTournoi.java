package com.mycompany.servlets;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Joueur;
import com.mycompany.beans.Tournoi;
import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ModifierTournoi extends HttpServlet
{
    private TournoiDao tournoiDao;

    public void init()
    {
        tournoiDao = new TournoiDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            long id = Long.parseLong(request.getParameter("idtournoi") );
            request.setAttribute("tournoi", tournoiDao.lecture(id) );
            this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_tournoi.jsp").forward(request, response);
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try {
            tournoiDao.modifier(new Tournoi(request) );
            response.sendRedirect(request.getContextPath() + "/private/list_tournois");
        } catch (BeanException|DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

}
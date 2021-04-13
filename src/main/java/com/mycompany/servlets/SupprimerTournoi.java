package com.mycompany.servlets;

import com.mycompany.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SupprimerTournoi extends HttpServlet
{
    private TournoiDao tournoiDao;

    public void init()
    {
        tournoiDao = new TournoiDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        long id = Long.parseLong(request.getParameter("idtournoi") );
        try {
            tournoiDao.supprimer(id);
            response.sendRedirect(request.getContextPath() + "/private/list_tournois");
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage() );
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
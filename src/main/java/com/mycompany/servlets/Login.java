package com.mycompany.servlets;

import com.mycompany.beans.Joueur;
import com.mycompany.beans.User;
import com.mycompany.dao.DaoException;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.HashClass;
import com.mycompany.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class Login extends HttpServlet
{
    private UserDaoImpl userDao;

    public void init()
    {
        userDao = new UserDaoImpl(DaoFactory.getInstance() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        User user = null;
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String login = null;
        String password = null;
        if (action == null) { action = ""; }

        switch (action)
        {
            case "login":
                login = request.getParameter("txtLogin");
                password = request.getParameter("txtPassword");
                try {
                    user = userDao.isValidLogin(login, HashClass.sha1(password) );
                    if (user != null && user.isAuthetified() ) {
                        session.setAttribute("User", user);
                        response.sendRedirect(request.getContextPath() + "/private/list_joueurs");
                    } else {
                        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    }
                } catch (DaoException e) {
                    request.setAttribute("error", e.getMessage() );
                    this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
                }
                break;

            case "logout":
                session.invalidate();
                this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                break;

            default:
                user = (User) session.getAttribute("User");
                if (user != null && user.isAuthetified() ) {
                    response.sendRedirect(request.getContextPath() + "/private/list_joueurs");
                } else {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                }
                break;
        }
    }

}
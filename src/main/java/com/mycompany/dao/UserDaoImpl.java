package com.mycompany.dao;

import com.mycompany.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl
{
    private DaoFactory daoFactory;

    public UserDaoImpl(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    public User isValidLogin(String login, String password) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "SELECT * FROM connexion WHERE login = ? AND password = ?";

        try{
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if ( rs.next() ) {
                return new User(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            throw new DaoException("Erreur de communication avec la Base de Données.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
                throw new DaoException("Erreur de communication avec la Base de Données.");
            }
        }
    }

}
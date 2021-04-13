package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class TennisDaoExtended extends TennisDaoBaseClass
{
    protected String baseQuery;

    public TennisDaoExtended(DaoFactory daoFactory)
    {
        super(daoFactory);
    }

    public List<String> getAnnees() throws DaoException
    {
        List<String> annees = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "SELECT DISTINCT(ANNEE) FROM EPREUVE ORDER BY ANNEE DESC;";
            statement = connection.prepareStatement(sqlStr);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                annees.add(rs.getString("ANNEE") );
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
        return annees;
    }

    public List<String> getTournois() throws DaoException
    {
        List<String> tournois = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "SELECT NOM FROM TOURNOI ORDER BY NOM ASC;";
            statement = connection.prepareStatement(sqlStr);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                tournois.add(rs.getString("NOM") );
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
        return tournois;
    }

}

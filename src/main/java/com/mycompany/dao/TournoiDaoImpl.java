package com.mycompany.dao;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Tournoi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournoiDaoImpl extends TennisDaoBaseClass implements TournoiDao
{
    public TournoiDaoImpl(DaoFactory daoFactory)
    {
        super(daoFactory);
    }

    @Override
    public void modifier(Tournoi tournoi) throws DaoException, BeanException
    {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "UPDATE TOURNOI SET NOM = ?, CODE = ? WHERE ID = ?;";
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1, tournoi.getNom() );
            statement.setString(2, tournoi.getCode() );
            statement.setLong(3, tournoi.getId() );
            statement.executeUpdate();

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

    @Override
    public void supprimer(Long id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "DELETE FROM TOURNOI WHERE ID = ?;";
            statement = connection.prepareStatement(sqlStr);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Tournoi lecture(Long id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        Tournoi t = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "SELECT * FROM TOURNOI WHERE ID = ?;";
            statement = connection.prepareStatement(sqlStr);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next() ) {
                t = new Tournoi(rs);
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
            return t;
        }
    }

    @Override
    public void ajouter(Tournoi tournoi) throws DaoException, BeanException
    {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "INSERT INTO TOURNOI (NOM, CODE) VALUES (?, ?);";

            statement = connection.prepareStatement(sqlStr);
            statement.setString(1, tournoi.getNom() );
            statement.setString(2, tournoi.getCode() );
            statement.executeUpdate();

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

    public List<Tournoi> lister(Filtre f) throws DaoException
    {
        List<Tournoi> tournois = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            String sqlStr = "SELECT * FROM TOURNOI;";
            statement = connection.prepareStatement(sqlStr);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                tournois.add(new Tournoi(rs) );
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

    @Override
    public List<Tournoi> rechercher(String searchQuery) throws DaoException
    {
        List<Tournoi> tournois = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "SELECT * FROM TOURNOI WHERE TOURNOI.NOM LIKE ? OR TOURNOI.CODE LIKE ?;";

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1, "%" + searchQuery + "%");
            statement.setString(2, "%" + searchQuery + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                tournois.add(new Tournoi(rs) );
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

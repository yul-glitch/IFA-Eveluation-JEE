package com.mycompany.dao;


import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JoueurDaoImpl extends TennisDaoBaseClass implements JoueurDao
{

    public JoueurDaoImpl(DaoFactory daoFactory)
    {
        super(daoFactory);
    }

    @Override
    public void supprimer(Long id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "DELETE FROM JOUEUR WHERE ID = ?;";

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            statement.setLong(1, id);
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
    public void modifier(Joueur joueur) throws DaoException, BeanException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "UPDATE JOUEUR SET NOM = ?, PRENOM = ?, SEXE = ? WHERE ID = ?;";

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            setJoueur(statement, joueur);
            statement.setLong(4, joueur.getId() );
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
    public Joueur lecture(Long id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "SELECT * FROM JOUEUR WHERE ID = ?;";
        Joueur j = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next() ) {
                j = new Joueur(rs);
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
            return j;
        }

    }

    @Override
    public void ajouter(Joueur joueur) throws DaoException, BeanException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "INSERT INTO JOUEUR (NOM, PRENOM, SEXE) VALUES (?, ?, ?);";

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            setJoueur(statement, joueur);
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
    public List<Joueur> lister(Filtre f) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "SELECT * FROM JOUEUR WHERE SEXE LIKE ?;";
        List<Joueur> joueurs = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1, f.getSexe() );
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                joueurs.add(new Joueur(rs) );
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
        return joueurs;
    }

    @Override
    public List<Joueur> rechercher(String searchQuery) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = "SELECT * FROM JOUEUR WHERE JOUEUR.NOM LIKE ? OR JOUEUR.PRENOM LIKE ?;";
        List<Joueur> joueurs = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1, "%" + searchQuery + "%");
            statement.setString(2, "%" + searchQuery + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                joueurs.add(new Joueur(rs) );
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
        return joueurs;
    }
}
package com.mycompany.dao;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchDaoImpl extends TennisDaoExtended implements MatchDao
{
    public MatchDaoImpl(DaoFactory daoFactory)
    {
        super(daoFactory);
        baseQuery = """
            SELECT m.ID_EPREUVE as id, t.NOM as epreuve_nom, t.CODE as epreuve_code,
                EPREUVE.ANNEE as epreuve_annee, EPREUVE.TYPE_EPREUVE AS epreuve_type,
                j.NOM as j1_nom, j.PRENOM as j1_prenom, j.SEXE as j1_sexe,
                j2.NOM as j2_nom, j2.PRENOM as j2_prenom, j2.SEXE as j2_sexe
            FROM EPREUVE
            JOIN TOURNOI as t ON ( t.ID = EPREUVE.ID_TOURNOI )
            JOIN MATCH_TENNIS as m ON ( m.ID_EPREUVE = EPREUVE.ID )
            JOIN JOUEUR as j ON ( j.ID = m.ID_VAINQUEUR )
            JOIN JOUEUR as j2 ON ( j2.ID = m.ID_FINALISTE )
        """;
    }

    @Override
    public List<Match> lister(Filtre f) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = baseQuery + "WHERE t.NOM LIKE ? AND EPREUVE.TYPE_EPREUVE LIKE ? AND CONVERT(EPREUVE.ANNEE, CHAR) LIKE ? ORDER BY EPREUVE.ANNEE DESC;";
        List<Match> matchs = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            setFilter(statement, f);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                matchs.add(new Match(rs) );
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
        return matchs;
    }

    @Override
    public List<Match> rechercher(String searchQuery) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = baseQuery + "WHERE j.NOM LIKE ? OR j.PRENOM LIKE ? OR j2.NOM LIKE ? OR j2.PRENOM LIKE ? ORDER BY EPREUVE.ANNEE DESC;";
        List<Match> matchs = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            setSearch(statement, searchQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                matchs.add(new Match(rs) );
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
        return matchs;
    }

}
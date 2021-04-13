package com.mycompany.dao;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Tournoi;

import java.util.List;

public interface TournoiDao
{
    void modifier(Tournoi t) throws DaoException, BeanException;
    void supprimer(Long id ) throws DaoException;
    Tournoi lecture(Long id) throws DaoException;
    void ajouter(Tournoi t) throws DaoException, BeanException;
    List<Tournoi> lister(Filtre f) throws DaoException;
    List<Tournoi> rechercher(String chaine) throws DaoException;
}

package com.mycompany.dao;

import com.mycompany.beans.Filtre;

import java.util.List;

public interface TennisDao<T>
{
    void modifier(T t) throws DaoException;
    void supprimer(Long id ) throws DaoException;
    T lecture(Long id) throws DaoException;
    void ajouter(T t) throws DaoException;
    List<T> lister(Filtre f) throws DaoException;
    List<T> rechercher(String chaine) throws DaoException;
    List<String> getAnnees() throws DaoException;
    List<String> getTournois() throws DaoException;
}

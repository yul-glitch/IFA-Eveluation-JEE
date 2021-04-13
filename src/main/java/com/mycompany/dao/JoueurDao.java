package com.mycompany.dao;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;

import java.util.List;

public interface JoueurDao
{
    void modifier(Joueur t) throws DaoException, BeanException;
    void supprimer(Long id ) throws DaoException;
    Joueur lecture(Long id) throws DaoException;
    void ajouter(Joueur t) throws DaoException, BeanException;
    List<Joueur> lister(Filtre f) throws DaoException;
    List<Joueur> rechercher(String chaine) throws DaoException;
}

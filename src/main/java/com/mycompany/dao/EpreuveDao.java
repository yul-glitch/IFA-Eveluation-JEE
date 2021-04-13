package com.mycompany.dao;

import com.mycompany.beans.Epreuve;
import com.mycompany.beans.Filtre;

import java.util.List;

public interface EpreuveDao
{
    List<Epreuve> lister(Filtre f) throws DaoException;
    List<Epreuve> rechercher(String chaine) throws DaoException;
    List<String> getAnnees() throws DaoException;
    List<String> getTournois() throws DaoException;
}

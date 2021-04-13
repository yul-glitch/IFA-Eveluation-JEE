package com.mycompany.beans;

import com.mycompany.dao.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Joueur
{
    private long id;
    private String prenom;
    private String nom;
    private String sexe;

    public Joueur() { }

    public Joueur (ResultSet rs) throws SQLException
    {
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.prenom = rs.getString("prenom");
        this.sexe = rs.getString("sexe");
    }

    public Joueur(HttpServletRequest request) throws BeanException
    {
        try {
            this.id = Long.parseLong(request.getParameter("idjoueur") );
        } catch (java.lang.NumberFormatException e) {
            this.id = -1;
        }
        setNom(request.getParameter("txtNom") );
        setPrenom(request.getParameter("txtPrenom") );
        setSexe(request.getParameter("opSexe") );
    }

    public void setPrenom(String prenom) throws BeanException
    {
//        prenom = "";
        if (prenom == null || prenom.length() == 0) {
            throw new BeanException("Prénom trop court.");
        } else if (prenom.length() > 20) {
            throw new BeanException("Prénom trop long, 20 charactères maximum.");
        } else {
            this.prenom = prenom;
        }
    }

    public void setNom(String nom) throws BeanException
    {
//        nom = "";
        if (nom == null || nom.length() == 0) {
            throw new BeanException("Nom trop court.");
        } else if (nom.length() > 20) {
            throw new BeanException("Nom trop long, 20 charactères maximum.");
        } else {
            this.nom = nom;
        }
    }

    public void setSexe(String sexe) throws BeanException
    {
//        sexe = null;
        if (sexe == null || !(sexe.equals("H") || sexe.equals("F")) ) {
            throw new BeanException("Choisissez entre 'H' ou 'F'");
        } else {
            this.sexe = sexe;
        }
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public String getSexe()
    {
        return sexe;
    }

    public long getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Joueur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}

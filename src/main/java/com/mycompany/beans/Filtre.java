package com.mycompany.beans;

import javax.servlet.http.HttpServletRequest;

public class Filtre
{
    private String tournoi;
    private String annee;
    private String sexe;

    public Filtre() { }

    public Filtre(HttpServletRequest request) throws BeanException
    {
        setTournoi(request.getParameter("formTournoi") );
        setAnnee(request.getParameter("formAnnee") );
        setSexe(request.getParameter("formSexe") );
    }

    public String getTournoi() {
        return tournoi;
    }

    public String getAnnee() {
        return annee;
    }

    public String getSexe() {
        return sexe;
    }

    public void setTournoi(String tournoi) throws BeanException
    {
//        tournoi = "DROP TABLE TOURNOI;";

        if (tournoi == null || tournoi.equals("%") ) {
            this.tournoi = "%";
            return;
        }

        String t = tournoi.toLowerCase();
        if (tournoi.length() > 20) {
            throw new BeanException("Nom du tournoi trop long, 20 charactères maximum.");
        } else if (t.contains("drop") || t.contains("insert") || t.contains("update") || t.contains("delete") || t.contains("truncate") ) {
            throw new BeanException("Bouuuuuuh");
        } else {
            this.tournoi = tournoi;
        }
    }

    public void setAnnee(String annee) throws BeanException
    {
//        annee = "2021";
        int a;
        if (annee == null || annee.equals("%") ) {
            this.annee = "%";
            return;
        }
        try {
            a = Integer.parseInt(annee);
        } catch (java.lang.NumberFormatException e) {
            System.out.println(e);
            throw new BeanException("Format d'année invalide");
        }
        if (annee.length() != 4) {
            throw new BeanException("Format d'année invalide");
        } else if ((a < 2010) || (a > 2020)) {
            throw new BeanException("Format d'année invalide");
        } else {
            this.annee = annee;
        }
    }

    public void setSexe(String sexe) throws BeanException
    {
        if (sexe == null || sexe.equals("%") ) {
            this.sexe = "%";
            return;
        }
        if ( !(sexe.equals("H") || sexe.equals("F") ) ) {
            throw new BeanException("Choisissez entre 'H' et 'F'");
        } else {
            this.sexe = sexe;
        }
    }

}

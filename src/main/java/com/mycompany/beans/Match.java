package com.mycompany.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Match
{
    private long id;
    private String nom;
    private String code;
    private String annee;
    private String type;
    private String j1Nom;
    private String j2Nom;

    public Match() {}
    public Match(ResultSet rs) throws SQLException
    {
        id = rs.getLong("id");
        nom = rs.getString("epreuve_nom");
        code = rs.getString("epreuve_code");
        annee = rs.getString("epreuve_annee");
        type = rs.getString("epreuve_type");
        j1Nom = rs.getString("j1_nom") + " " + rs.getString("j1_prenom");
        j2Nom = rs.getString("j2_nom") + " " + rs.getString("j2_prenom");
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getAnnee() { return annee; }

    public void setAnnee(String annee) { this.annee = annee; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getJ1Nom() { return j1Nom; }

    public void setJ1Nom(String j1Nom) { this.j1Nom = j1Nom; }

    public String getJ2Nom() { return j2Nom; }

    public void setJ2Nom(String j2Nom) { this.j2Nom = j2Nom; }

    @Override
    public String toString()
    {
        return "Match{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", annee='" + annee + '\'' +
                ", type='" + type + '\'' +
                ", j1Nom='" + j1Nom + '\'' +
                ", j2Nom='" + j2Nom + '\'' +
                '}';
    }
}

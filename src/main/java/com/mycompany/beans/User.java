package com.mycompany.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User
{
    private int id;
    private String login;
    private String password;
    private int profil;
    private boolean isAuthetified;

    public User() {
        super();
    }

    public User(ResultSet rs) throws SQLException
    {
        this.id = rs.getInt( "id" );
        this.login = rs.getString( "login" );
        this.password = rs.getString( "password" );
        this.profil = rs.getInt( "profil" );
        this.isAuthetified = true;
    }

    public boolean isAuthetified()
    {
        return isAuthetified;
    }

    public void setId(int id) { this.id = id; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setProfil(int profil) { this.profil = profil; }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getProfil() {
        return profil;
    }

    public String getPassword() { return password; }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", isAuthetified=" + isAuthetified +
                '}';
    }
}

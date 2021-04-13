<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.HashMap" %>
<html lang="fr">
  <%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/")+1);
    HashMap<String, String> searchablePages = new HashMap<>();
    searchablePages.put("list_joueurs.jsp", "list_joueurs");
    searchablePages.put("list_joueurs_null.jsp", "list_joueurs");
    searchablePages.put("list_tournois.jsp", "list_tournois");
    searchablePages.put("list_tournois_null.jsp", "list_tournois");
    searchablePages.put("list_matchs.jsp", "list_matchs");
    searchablePages.put("list_matchs_null.jsp", "list_matchs");
    String s = searchablePages.get(pageName);
  %>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="list_joueurs">Joueurs</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="">|</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="list_tournois">Tournois</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="">|</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="list_matchs">Matchs</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="">|</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="list_epreuves">Épreuves</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="">|</a></li>
        <li class="nav-item" style="font-size: large;"><a class="nav-link" href="">${sessionScope.User.getLogin()}</a></li>
      </ul>
      <form class="form-inline my-2 my-lg-0" action="${s}" method="post">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="searchQuery" <% if (s == null) { out.print("disabled"); } %> />
        <button class="btn btn-secondary my-2 my-sm-0" name="action" type="submit" <% if (s == null) { out.print("disabled"); } %> >Search</button>
      </form>
      <form class="form-inline my-2 my-lg-0" action="../login" method="get" style="padding-left: 7px;">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action" value="logout">Deconnexion</button>
      </form>
    </div>
  </nav>
</html>
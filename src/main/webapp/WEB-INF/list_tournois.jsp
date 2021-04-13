<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <style><%@ include file="../css/starter-template.css" %></style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Tournois</title>
  </head>

  <body>
    <jsp:include page="/WEB-INF/navbar.jsp" />
    <main role="main" class="container">
      <div class="starter-template"><h1>Liste des Tournois</h1></div>
    </main>
    <div class="container">
      <div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
        <a class="btn btn-primary" href="ajouter_tournoi" role="button">Ajouter un tournoi</a>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col" style="width:10%">#</th>
            <th scope="col" style="width:25%">Nom</th>
            <th scope="col" style="width:20%">Code</th>
            <th scope="col" style="width:10%"></th>
            <th scope="col" style="width:10%"></th>
            <th scope="col" style="width:20%"></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="tournoi" items="${ tournois }">
            <tr>
              <th scope="row"><c:out value="${ tournoi.id }" /></th>
              <td><c:out value="${ tournoi.nom }" /></td>
              <td><c:out value="${ tournoi.code }" /></td>
              <td>
                <form action="modifier_tournoi" method="get">
                  <input type="hidden" name="idtournoi" value="${ tournoi.id }" />
                  <button type="submit" name="action" class="btn btn-outline-primary">Modifier</button>
                </form>
              </td>
              <td>
                <form action="supprimer_tournoi" method="get">
                  <input type="hidden" name="idtournoi" value="${ tournoi.id }" />
                  <button type="submit" name="action" class="btn btn-outline-warning">Supprimer</button>
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
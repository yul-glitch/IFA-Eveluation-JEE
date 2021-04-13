<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <style><%@ include file="../css/starter-template.css" %></style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <title>Épreuves</title>
</head>

  <body>
    <jsp:include page="/WEB-INF/navbar.jsp" />
    <main role="main" class="container">
      <div class="starter-template"><h1>Liste des Épreuves</h1></div>
    </main><!-- /.container -->
    <div class="container">
      <jsp:include page="/WEB-INF/filtre.jsp" />
      <table class="table">
        <thead>
          <tr>
            <th scope="col" style="width:5%">#</th>
            <th scope="col" style="width:20%">Tournoi</th>
            <th scope="col" style="width:10%">Code</th>
            <th scope="col" style="width:10%">Année</th>
            <th scope="col" style="width:10%">Type</th>
            <th scope="col" style="width:5%">Set 1</th>
            <th scope="col" style="width:5%">Set 2</th>
            <th scope="col" style="width:5%">Set 3</th>
            <th scope="col" style="width:5%">Set 4</th>
            <th scope="col" style="width:5%">Set 5</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="epreuve" items="${ epreuves }">
            <tr>
                <th scope="row"><c:out value="${ epreuve.id }" /></th>
                <td><c:out value="${ epreuve.nom }" /></td>
                <td><c:out value="${ epreuve.code }" /></td>
                <td><c:out value="${ epreuve.annee }" /></td>
                <td><c:out value="${ epreuve.type }" /></td>
                <td><c:out value="${ epreuve.score[0] }" /></td>
                <td><c:out value="${ epreuve.score[1] }" /></td>
                <td><c:out value="${ epreuve.score[2] }" /></td>
                <td><c:out value="${ epreuve.score[3] }" /></td>
                <td><c:out value="${ epreuve.score[4] }" /></td>
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
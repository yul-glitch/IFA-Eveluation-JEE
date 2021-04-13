<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <style><%@ include file="../css/starter-template.css" %></style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Modifier Joueurs</title>
  </head>

  <body>
    <jsp:include page="/WEB-INF/navbar.jsp" />
    <main role="main" class="container">
      <div class="starter-template"><h1>Modifier un Joueur</h1></div>
    </main>
    <div style="width:40%; margin:auto;">
      <form class="needs-validation" method="post" novalidate>
        <div class="form-row">
          <div class="col-md-4 mb-3">
            <label for="validationCustom01">Nom du joueur</label>
            <input type="text" class="form-control" style="width:400px;" id="validationCustom01" name="txtNom" value="${ joueur.nom }" required pattern=".{1,20}" />
            <div class="invalid-feedback">1 à 20 caractères maximum</div>
          </div>
        </div>
        <div class="form-row">
          <div class="col-md-4 mb-3">
            <label for="validationCustom02">Prénom du joueur</label>
            <input type="text" class="form-control" style="width:400px;" id="validationCustom02" name="txtPrenom" value="${ joueur.prenom }" required pattern=".{1,20}" />
            <div class="invalid-feedback">1 à 20 caractères maximum</div>
          </div>
        </div>
        <div class="form-row">
          <div class="col-md-3 mb-3">
            <label for="validationCustom04">Sexe</label>
            <select class="custom-select" id="validationCustom04" name="opSexe" style="width:400px;" required>
              <option selected="selected" disabled="disabled" value="">Sélectioner...</option>
              <option value="F" <c:if test="${joueur.sexe == 'F'}">selected</c:if> >Femme</option>
              <option value="H" <c:if test="${joueur.sexe == 'H'}">selected</c:if> >Homme</option>
            </select>
            <div class="invalid-feedback">Veuillez choisir un sexe!</div>
          </div>
        </div>
        <button class="btn btn-primary center" type="submit">Modifier</button>
      </form>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/check_form.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
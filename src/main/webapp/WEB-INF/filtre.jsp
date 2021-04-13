<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <style><%@ include file="../css/starter-template.css" %></style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  </head>
  
  <body>
    <form style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;" method="get">
      <div class="form-row">
        <div class="col-md-4 mb-4">
          <label for="validationCustom01">Tournoi</label>
          <select class="custom-select" id="validationCustom01" name="formTournoi" style="width:50%;" onchange=submit()>
            <option value="%" <c:if test="${filter.tournoi == '%'}">selected</c:if> >Tous</option>
            <c:forEach var="tournoi" items="${ tournois }">
              <option value="${tournoi}" <c:if test="${filter.tournoi == tournoi}">selected</c:if> ><c:out value="${tournoi}" /></option>
            </c:forEach>
          </select>
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationCustom02">Année</label>
          <select class="custom-select" id="validationCustom02" name="formAnnee" style="width:50%;" onchange=submit()>
            <option value="%" <c:if test="${filter.annee == '%'}">selected</c:if> >Toutes</option>
            <c:forEach var="annee" items="${ annees }">
              <option value="${annee}" <c:if test="${filter.annee == annee}">selected</c:if> ><c:out value="${annee}" /></option>
            </c:forEach>
          </select>
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationCustom03">Sexe</label>
          <select class="custom-select" id="validationCustom03" name="formSexe" style="width:50%;" onchange=submit()>
            <option value="%" <c:if test="${filter.sexe == '%'}">selected</c:if> >Les deux</option>
            <option value="F" <c:if test="${filter.sexe == 'F'}">selected</c:if> >Femme</option>
            <option value="H" <c:if test="${filter.sexe == 'H'}">selected</c:if> >Homme</option>
          </select>
        </div>
      </div>
    </form>
  </body>
</html>
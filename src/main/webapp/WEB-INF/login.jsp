<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
  <head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style><%@ include file="../css/signin.css" %></style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Connection</title>
  </head>

  <body style="background-color:#000000 ;">
    <form class="form-signin" method="get" action="login">
      <input name="action" type="hidden" value="login" />
      <img class="mb-4" src="${pageContext.request.contextPath}/images/logo.png" alt="" />
      <h1 class="h3 mb-3 font-weight-normal" style="color:#FFF;">Merci de vous connecter</h1>
      <label for="inputEmail" class="sr-only" >Email address</label>
      <input type="email" id="inputEmail" name="txtLogin" class="form-control" placeholder="Addresse mail" required autofocus value="aymeric.guth@gmail.com" />
      <label for="inputPassword" class="sr-only" >Password</label>
      <input type="password" id="inputPassword" name="txtPassword" class="form-control" placeholder="Mot de passe" required value="123456" />
      <button class="btn btn-lg btn-primary btan-block" style="background-color:#ff750b; border-color:#FFF;" type="submit">Sign in</button>
    </form>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
  </body>
</html>
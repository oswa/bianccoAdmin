<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="BIANCCO Administrator">
        <meta name="author" content="SOSExcellence">
        <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico">

        <title>Biancco Admin</title>

		<link href="${pageContext.request.contextPath}/js/lib/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.min.js"></script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>
		<!--
		<link href="js/lib/bootstrap.min.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
        
        <script type="text/javascript" src="js/lib/jquery.min.js"></script>
        <script type="text/javascript" src="js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/utils.js"></script>
		 -->
  </head>

  <body>

    <div class="container">
        <form class="form-signin" id="loginForm" method="post" action="${pageContext.request.contextPath}/app/login/signin">
            <h4 class="form-signin-heading">BIANCCO Administrador</h4>
            <label for="user" class="sr-only">Usuario</label>
            <input type="text" id="user" name="user" class="form-control" placeholder="usuario" required autofocus>
            <label for="pwd" class="sr-only">Contrase&ntilde;a</label>
            <input type="password" id="pwd" name="pwd" class="form-control" placeholder="contrase&ntilde;a" required>
            <button class="btn btn-lg btn-primary btn-block" id="loginButton" type="submit">Entrar</button>
            <p align="right">v0.0.1-SNAPSHOT</p>
			<c:if test="${not empty model and not empty model.message}">
				<div class="alert alert-danger" role="alert">
        			<strong>Error!</strong> <c:out value="${model.message}"/>
      			</div>
			</c:if>            
            <img src="${pageContext.request.contextPath}/image/footer_biancco_519.png" width="300px"/>
        </form>
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script>window.jQuery || document.write('<script src="' + ${pageContext.request.contextPath} + '/js/lib/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/js/lib/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
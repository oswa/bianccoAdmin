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
    <link rel="icon" href="favicon.ico">

    <title>Biancco Main Page</title>
    
    <link href="../js/lib/bootstrap.min.css" rel="stylesheet">
    <link href="../js/lib/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="../css/app.css" rel="stylesheet">
    <script src="../js/lib/assets/js/ie-emulation-modes-warning.js"></script>
    
    <!-- 
        <link href="js/lib/bootstrap.min.css" rel="stylesheet">
    
        <link href="css/signin.css" rel="stylesheet">
        
        <script type="text/javascript" src="js/lib/jquery.min.js"></script>
        <script type="text/javascript" src="js/lib/tether.min.js"></script>
        <script type="text/javascript" src="js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/utils.js"></script>
     -->

  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <!--div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
          </button>
          <img src="../image/lg_gbiancco.png" width="150px">
          <a class="navbar-brand">BIANCCO Administrador</a>
          <p class="navbar-brand">BIANCCO Administrador</p>
        </div-->
        <div class="navbar-header">
        	<p class="nav navbar-nav">
        		<img src="../image/lg_gbiancco.png" width="150px" />
           	</p>
           	<p class="nav navbar-nav">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">M&oacute;dulos <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Empresas</a></li>
                <li><a href="#">Calidad</a></li>
                <li><a href="#">Oficina</a></li>
                <li><a href="#">Control vehicular</a></li>
                <li><a href="#">Inventarios</a></li>
                <li><a href="#">Empleados</a></li>
                <li><a href="#">Contabilidad</a></li>
                <li><a href="#">Resultados</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administraci&oacute;n <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Carpetas</a></li>
                <li><a href="#">Accesos</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li>
          		<p class="navbar-brand">Bienvenido&nbsp;<b>Oswaldo</b>&nbsp;&nbsp;<b>|</b></p>
          	</li>
          	<li>
                <p class="navbar-btn">
                    <a href="#" class="btn btn-danger">Salir</a>
                </p>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container" id="content">

      <div class="page-header">
        <h3>M&oacute;dulos</h3>
      </div>
      <br>
      <div class="row">
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Empresas" src="../image/folder-home.png"></a></div>Empresas</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Calidad" src="../image/sign-check.png"></a></div>Calidad</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Oficina" src="../image/screen.png"></a></div>Oficina</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Control vehicular" src="../image/cone.png"></a></div>Control vehicular</div>
      </div>
      <br><br>
      <div class="row">
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Compras" src="../image/bag.png"></a></div>Compras</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Empleados" src="../image/users.png"></a></div>Empleados</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Contabilidad" src="../image/money.png"></a></div>Contabilidad</div>
        <div class="col-md-3" align="center"><div><a href="#"><img alt="Resultados" src="../image/pie-chart.png"></a></div>Resultados</div>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="../js/lib/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/lib/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../js/lib/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
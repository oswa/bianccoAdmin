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

    <title>Biancco Main Page</title>
    
    <link href="${pageContext.request.contextPath}/js/lib/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/lib/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/js/lib/bootstrap-treeview.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/lib/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/lib/jquery.fileupload.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/lib/jquery.fileupload-ui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/lib/fileuploadUI.css" rel="stylesheet">
    
    <link href="${pageContext.request.contextPath}/css/app.css" rel="stylesheet">
    
    <script src="${pageContext.request.contextPath}/js/lib/assets/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/lib/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap-treeview.min.js"></script>    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/assets/js/vendor/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.fileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.fileupload-process.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.fileupload-validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/fileuploadUI.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/assets/js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
    <c:forEach items="${model.menu}" var="item" varStatus="loop">
    	<script type="text/javascript" src="${pageContext.request.contextPath}/js/${item.module}.js"></script>
    </c:forEach>
    
    <!-- 
        <link href="../js/lib/bootstrap.min.css" rel="stylesheet">
    	<link href="../js/lib/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    	<link href="../css/app.css" rel="stylesheet">
    	<script src="../js/lib/assets/js/ie-emulation-modes-warning.js"></script>
    	<script type="text/javascript" src="../js/utils.js"></script>
    	<script type="text/javascript" src="../js/app.js"></script>
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
        		<img src="${pageContext.request.contextPath}/image/lg_gbiancco.png" width="150px" />
           	</p>
           	<p class="nav navbar-nav">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">M&oacute;dulos <span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<c:forEach items="${model.menu}" var="item" varStatus="loop">
              		<li><a href="#" onclick="goToView('${item.module}');"><c:out value="${item.option}"/></a></li>
              	</c:forEach>
              </ul>
            </li>
            <c:if test="${model.configOption}">
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administraci&oacute;n <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="#">Carpetas</a></li>
	                <li><a href="#">Accesos</a></li>
	              </ul>
	            </li>
            </c:if>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li>
          		<p class="navbar-brand" style="font-size:16px;">Bienvenido&nbsp;<b><c:out value="${model.name}"/></b>&nbsp;&nbsp;<b>|</b></p>
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
    	<%@include file="modules.jsp"%>
    	
    	<!-- -------------------------------------------------------- -->
    	
    	
    	
    	<!-- -------------------------------------------------------- -->
    </div> <!-- /container -->
    <br>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!--
    <script type="text/javascript" src="../js/lib/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/lib/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
    <script src="../js/lib/assets/js/ie10-viewport-bug-workaround.js"></script> 
     -->
  </body>
</html>
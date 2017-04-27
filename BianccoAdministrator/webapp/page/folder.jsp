<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<table width="100%">
		<tr>
			<td width="30%"><h3>Documentos</h3></td>
            <td width="70%" align="right">
            	<!-- 
				<button class="btn btn-default btn-block" id="loginButton" onclick="showAlert()" style="width: 130px;">
        			<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>Documentos
        		</button>
        		 --> 
            </td>
		</tr>
	</table>
</div>
<div class="row">
	<div class="col-md-6" role="main">
		<div>
			<div id="folderTreeview"></div>
		</div>
	</div>
	<div class="col-md-6" id="_folderContent" role="complementary">
		<div class="panel panel-default">
            <div class="panel-heading">
            	<h3 class="panel-title">Informaci&oacute;n adicional</h3>
            </div>
            <div class="panel-body">
            	<div id="_folderMessage"></div>
            	<div id="_folderName"></div>
				<div id="_folderFields"></div>
				<div id="_folderUploadFiles"></div>
            </div>
          </div>
	</div>
</div>
<button class="btn btn-default" id="backButton" onclick="backTo(1)">
	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	Regresar
</button>
				
<script type="text/javascript">
	var _data = '[' + decodeURIComponent('<c:out value="${model.folderAsJSON}"/>'.replace(/\+/g, '%20')) + ']';
	var $tree = $('#folderTreeview').treeview({
		showTags: true,
		data: _data,
		onNodeSelected: function(event, node) {
			// get fields
			if (node.folder) {
				getFolderFields(node.detail);
			}
        }
	});
</script>
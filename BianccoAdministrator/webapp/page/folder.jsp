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
<div>
	<div>
		<div id="folderTreeview"></div>
	</div>
</div>
<script type="text/javascript">
	var _data = '[' + decodeURIComponent('<c:out value="${model.folderAsJSON}"/>'.replace(/\+/g, '%20')) + ']';
	var $tree = $('#folderTreeview').treeview({
		data: _data
	});
</script>
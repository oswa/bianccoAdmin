<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<table width="100%">
		<tr>
			<td width="30%"><h3>Empresas</h3></td>
			<td width="70%" align="right">
				<c:if test="${model.pType.type eq 'M'}">
					<button class="btn btn-primary" id="addButton" onclick="addCompany()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar
					</button>
				</c:if>
			</td>
		</tr>
	</table>
</div>

<div id="messageAlert"></div>

<c:choose>
	<c:when test="${not empty model.companies}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th width="5%">#</th>
					<th width="55%">Nombre</th>
					<th width="30%">Obras</th>
					<th width="5%">Editar</th>
					<!-- <th width="5%">Activo</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${model.companies}" var="item" varStatus="loop">
					<tr>
						<td><c:out value="${loop.index+1}"/></td>
						<td><c:out value="${item.name}"/></td>
						<td><c:out value="${item.workCount}"/></td>
						<td align="center">
							<button class="btn btn-danger" onclick="editCompany(${item.id})" >
								<span class="glyphicon ${(model.pType.type eq 'Q') ? 'glyphicon-eye-open' : 'glyphicon-pencil'}" 
								aria-hidden="true"></span>
							</button>
						</td>
						<!-- 
						<td align="center"><input type="checkbox" onclick="disableEmployee(${item.id}, this.checked)" ${(model.pType.type eq 'Q') ? 'disabled' : ''} 
						${(item.enable) ? 'checked' : ''}></td> -->
					</tr>					
				</c:forEach>
			</tbody>
		</table>
		<table width="100%">
			<td align="left">
				<button class="btn btn-default" id="backButton" onclick="backTo(0)">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					Regresar
				</button>
			</td>
			<c:if test="${model.pType.type eq 'M'}">
				<td align="right">
					<button class="btn btn-primary" id="addButton" onclick="addCompany()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						Agregar
					</button>
				</td>
			</c:if>
		</table>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning" role="alert">
        	<strong>:\ </strong> No hay empresas que mostrar.
      	</div>
	</c:otherwise>
</c:choose>
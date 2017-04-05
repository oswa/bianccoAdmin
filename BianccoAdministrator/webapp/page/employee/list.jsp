<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<table width="100%">
		<tr>
			<td width="30%"><h3>Empleados</h3></td>
			<td width="70%" align="right">
				<c:if test="${model.pType.type eq 'M'}">
					<button class="btn btn-primary" id="addButton" onclick="addEmployee()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar
					</button>
				</c:if>
			</td>
		</tr>
	</table>
</div>

<div id="messageAlert"></div>

<c:choose>
	<c:when test="${not empty model.employees}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th width="5%">#</th>
					<th width="55%">Nombre</th>
					<th width="30%">Puesto</th>
					<th width="5%">Editar</th>
					<th width="5%">Habilitar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${model.employees}" var="item" varStatus="loop">
					<tr>
						<td><c:out value="${loop.index+1}"/></td>
						<c:choose>
							<c:when test="${not empty item.name}">
								<td><c:out value="${item.name}"/>&nbsp;<c:out value="${item.lastName}"/></td>
							</c:when>
							<c:otherwise><td><c:out value="${item.nick}"/></td></c:otherwise>
						</c:choose>
						<td><c:out value="${item.roleName}"/></td>
						<td align="center">
							<button class="btn btn-danger" onclick="editEmployee(${item.id})" 
							${(model.pType.type eq 'Q') ? 'disabled' : ''}>
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</button>
						</td>
						<td align="center"><input type="checkbox" ${(model.pType.type eq 'Q') ? 'disabled' : ''}></td>
					</tr>					
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary" id="addButton" onclick="addEmployee()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						Agregar
					</button>
				</td>
			</table>
		</c:if>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning" role="alert">
        	<strong>Warning!</strong> No hay empleados que mostrar.
      	</div>
	</c:otherwise>
</c:choose>
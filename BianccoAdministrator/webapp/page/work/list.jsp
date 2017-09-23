<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<table width="100%">
		<tr>
			<td width="30%"><h3>Obras</h3></td>
			<td width="70%" align="right">
				<c:if test="${model.pType.type eq 'M'}">
					<button class="btn btn-primary" id="addButton" onclick="addWork()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar
					</button>
				</c:if>
			</td>
		</tr>
	</table>
</div>

<div id="messageAlert"></div>

  <div id="_obras" class="tab-pane fade in active">
	<c:choose>
		<c:when test="${not empty model.company.works}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="5%">#</th>
						<th width="55%">Obra</th>
						<th width="5%">Editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${model.company.works}" var="item" varStatus="loop">
						<tr>
							<td><c:out value="${loop.index+1}"/></td>
							<td><c:out value="${item.name}"/></td>
							<td align="center">
								<button class="btn btn-danger" onclick="editWork(${item.idWork})" >
									<span class="glyphicon ${(model.pType.type eq 'Q') ? 'glyphicon-eye-open' : 'glyphicon-pencil'}" aria-hidden="true"></span>
								</button>
							</td>
						</tr>					
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert">
	        	<strong>Warning!</strong> Empresa sin obras.
	      	</div>
		</c:otherwise>
	</c:choose>
  </div>
<table width="100%">
	<td align="left">
		<button class="btn btn-default" id="backButton" onclick="backTo(1)">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			Regresar
		</button>
	</td>
	<c:if test="${model.pType.type eq 'M'}">
		<td align="right">
			<button class="btn btn-primary" id="addButton" onclick="addWork()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Agregar
			</button>
		</td>
	</c:if>
</table>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="page-header">
	<h3>M&oacute;dulos</h3>
</div>
<br>
<c:set var="menuSize" scope="page" value="${fn:length(model.menu)}"/>
<c:forEach items="${model.menu}" var="item" varStatus="loop">
	<c:if test="${loop.first}">
		<div class="row">
	</c:if>
	<c:if test="${loop.index lt 4}">
		<div class="col-md-3" align="center">
			<div>
				<a href="#" onclick="goToView(${item.module});"><img alt="${item.option}" src="${pageContext.request.contextPath}/image/${item.icon}"></a>
			</div>
			<c:out value="${item.option}"/>
		</div>
	</c:if>
	<c:if test="${(menuSize le 4 and loop.index lt 4 and loop.last) or (menuSize gt 4 and loop.index eq 3)}">
		</div>
	</c:if>
	<c:if test="${menuSize gt 4 and loop.index eq 4}">
		<br>
		<br>
		<div class="row">
	</c:if>
	<c:if test="${loop.index ge 4}">
		<div class="col-md-3" align="center">
			<div>
				<a href="#" onclick="goToView(${item.module});"><img alt="${item.option}" src="../image/${item.icon}"></a>
			</div>
			<c:out value="${item.option}"/>
		</div>
	</c:if>
	<c:if test="${menuSize gt 4 and loop.last}">
		</div>
	</c:if>
</c:forEach>
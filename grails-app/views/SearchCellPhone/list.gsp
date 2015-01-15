

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cellPhone.label', default: 'CellPhone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<form name="list">
			<a href="#list-cellPhone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
			<div class="nav" role="navigation">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li>
						<span class="menuButton">
	             			<g:textField name="inputSearchName" value="${inputSearchName}"/>
	             			<button>Buscar</button>
	            		</span>
	            	</li>
				</ul>
			</div>
			<div id="list-cellPhone" class="content scaffold-list" role="main">
				<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
				</g:if>
				<table>
					<thead>
						<tr>
						
							<g:sortableColumn property="number" title="${message(code: 'cellPhone.number.label', default: 'Number')}" />
						
							<g:sortableColumn property="name" title="${message(code: 'cellPhone.name.label', default: 'Name')}" />
						
							<th><g:message code="cellPhone.model.label" default="Model" /></th>
						
							<g:sortableColumn property="receivesSummaryAccount" title="${message(code: 'cellPhone.receivesSummaryAccount.label', default: 'Receives Summary Account')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${cellPhoneInstanceList}" status="i" var="cellPhoneInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="${request.forwardURI}/CellPhone/show" id="${cellPhoneInstance.id}">${fieldValue(bean: cellPhoneInstance, field: "number")}</g:link></td>
						
							<td>${fieldValue(bean: cellPhoneInstance, field: "name")}</td>
						
							<td>${fieldValue(bean: cellPhoneInstance, field: "model")}</td>
						
							<td><g:formatBoolean boolean="${cellPhoneInstance.receivesSummaryAccount}" /></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${cellPhoneInstanceTotal}" />
				</div>
			</div>
		</form>
	</body>
</html>

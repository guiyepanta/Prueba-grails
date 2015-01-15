

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cellPhone.label', default: 'CellPhone')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-cellPhone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-cellPhone" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cellPhone">
			
				<g:if test="${cellPhoneInstance?.number}">
				<li class="fieldcontain">
					<span id="number-label" class="property-label"><g:message code="cellPhone.number.label" default="Number" /></span>
					
						<span class="property-value" aria-labelledby="number-label"><g:fieldValue bean="${cellPhoneInstance}" field="number"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cellPhoneInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="cellPhone.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${cellPhoneInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cellPhoneInstance?.model}">
				<li class="fieldcontain">
					<span id="model-label" class="property-label"><g:message code="cellPhone.model.label" default="Model" /></span>
					
						<span class="property-value" aria-labelledby="model-label"><g:link controller="cellPhoneModel" action="show" id="${cellPhoneInstance?.model?.id}">${cellPhoneInstance?.model?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cellPhoneInstance?.receivesSummaryAccount}">
				<li class="fieldcontain">
					<span id="receivesSummaryAccount-label" class="property-label"><g:message code="cellPhone.receivesSummaryAccount.label" default="Receives Summary Account" /></span>
					
						<span class="property-value" aria-labelledby="receivesSummaryAccount-label"><g:formatBoolean boolean="${cellPhoneInstance?.receivesSummaryAccount}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${cellPhoneInstance?.id}" />
					<g:link class="edit" action="edit" id="${cellPhoneInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

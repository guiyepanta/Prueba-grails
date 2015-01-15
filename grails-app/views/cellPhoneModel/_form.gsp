



<div class="fieldcontain ${hasErrors(bean: cellPhoneModelInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="cellPhoneModel.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="25" required="" value="${cellPhoneModelInstance?.name}"/>
</div>


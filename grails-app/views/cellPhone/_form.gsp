



<div class="fieldcontain ${hasErrors(bean: cellPhoneInstance, field: 'number', 'error')} required">
	<label for="number">
		<g:message code="cellPhone.number.label" default="Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="number" type="number" min="1001" value="${cellPhoneInstance.number}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: cellPhoneInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="cellPhone.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="30" required="" value="${cellPhoneInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cellPhoneInstance, field: 'model', 'error')} required">
	<label for="model">
		<g:message code="cellPhone.model.label" default="Model" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="model" name="model.id" from="${CellPhoneModel.list()}" optionKey="id" required="" value="${cellPhoneInstance?.model?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cellPhoneInstance, field: 'receivesSummaryAccount', 'error')} ">
	<label for="receivesSummaryAccount">
		<g:message code="cellPhone.receivesSummaryAccount.label" default="Receives Summary Account" />
		
	</label>
	<g:checkBox name="receivesSummaryAccount" value="${cellPhoneInstance?.receivesSummaryAccount}" />
</div>


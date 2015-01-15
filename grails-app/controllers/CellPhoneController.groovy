import org.springframework.dao.DataIntegrityViolationException

class CellPhoneController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [cellPhoneInstanceList: CellPhone.list(params), cellPhoneInstanceTotal: CellPhone.count()]
    }

    def create() {
        [cellPhoneInstance: new CellPhone(params)]
    }

    def save() {
        def cellPhoneInstance = new CellPhone(params)
        if (!cellPhoneInstance.save(flush: true)) {
            render(view: "create", model: [cellPhoneInstance: cellPhoneInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), cellPhoneInstance.id])
        redirect(action: "show", id: cellPhoneInstance.id)
    }

    def show(Long id) {
        def cellPhoneInstance = CellPhone.get(id)
        if (!cellPhoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "list")
            return
        }

        [cellPhoneInstance: cellPhoneInstance]
    }

    def edit(Long id) {
        def cellPhoneInstance = CellPhone.get(id)
        if (!cellPhoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "list")
            return
        }

        [cellPhoneInstance: cellPhoneInstance]
    }

    def update(Long id, Long version) {
        def cellPhoneInstance = CellPhone.get(id)
        if (!cellPhoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (cellPhoneInstance.version > version) {
                cellPhoneInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cellPhone.label', default: 'CellPhone')] as Object[],
                          "Another user has updated this CellPhone while you were editing")
                render(view: "edit", model: [cellPhoneInstance: cellPhoneInstance])
                return
            }
        }

        cellPhoneInstance.properties = params

        if (!cellPhoneInstance.save(flush: true)) {
            render(view: "edit", model: [cellPhoneInstance: cellPhoneInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), cellPhoneInstance.id])
        redirect(action: "show", id: cellPhoneInstance.id)
    }

    def delete(Long id) {
        def cellPhoneInstance = CellPhone.get(id)
        if (!cellPhoneInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "list")
            return
        }

        try {
            cellPhoneInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cellPhone.label', default: 'CellPhone'), id])
            redirect(action: "show", id: id)
        }
    }
}

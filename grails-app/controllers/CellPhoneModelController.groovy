import org.springframework.dao.DataIntegrityViolationException

class CellPhoneModelController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [cellPhoneModelInstanceList: CellPhoneModel.list(params), cellPhoneModelInstanceTotal: CellPhoneModel.count()]
    }

    def create() {
        [cellPhoneModelInstance: new CellPhoneModel(params)]
    }

    def save() {
        def cellPhoneModelInstance = new CellPhoneModel(params)
        if (!cellPhoneModelInstance.save(flush: true)) {
            render(view: "create", model: [cellPhoneModelInstance: cellPhoneModelInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), cellPhoneModelInstance.id])
        redirect(action: "show", id: cellPhoneModelInstance.id)
    }

    def show(Long id) {
        def cellPhoneModelInstance = CellPhoneModel.get(id)
        if (!cellPhoneModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "list")
            return
        }

        [cellPhoneModelInstance: cellPhoneModelInstance]
    }

    def edit(Long id) {
        def cellPhoneModelInstance = CellPhoneModel.get(id)
        if (!cellPhoneModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "list")
            return
        }

        [cellPhoneModelInstance: cellPhoneModelInstance]
    }

    def update(Long id, Long version) {
        def cellPhoneModelInstance = CellPhoneModel.get(id)
        if (!cellPhoneModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (cellPhoneModelInstance.version > version) {
                cellPhoneModelInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel')] as Object[],
                          "Another user has updated this CellPhoneModel while you were editing")
                render(view: "edit", model: [cellPhoneModelInstance: cellPhoneModelInstance])
                return
            }
        }

        cellPhoneModelInstance.properties = params

        if (!cellPhoneModelInstance.save(flush: true)) {
            render(view: "edit", model: [cellPhoneModelInstance: cellPhoneModelInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), cellPhoneModelInstance.id])
        redirect(action: "show", id: cellPhoneModelInstance.id)
    }

    def delete(Long id) {
        def cellPhoneModelInstance = CellPhoneModel.get(id)
        if (!cellPhoneModelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "list")
            return
        }

        try {
            cellPhoneModelInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cellPhoneModel.label', default: 'CellPhoneModel'), id])
            redirect(action: "show", id: id)
        }
    }
}

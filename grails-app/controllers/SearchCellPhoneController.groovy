import org.springframework.dao.DataIntegrityViolationException

class SearchCellPhoneController {

	def cellPhoneService
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def searchCellPhones = cellPhoneService.search(params.inputSearchName)		
		[cellPhoneInstanceList: searchCellPhones, cellPhoneInstanceTotal: searchCellPhones.size(), inputSearchName: params.inputSearchName]		
	}
}

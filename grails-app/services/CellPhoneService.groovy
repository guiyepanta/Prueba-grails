
public class CellPhoneService {
	static transactional = true

	def search(inputSearchName) {
		
		if (inputSearchName){
			
			def likeSearch = "%" + inputSearchName + "%"
			return CellPhone.findAllByNameLike(likeSearch)
			
		}		
		else {	
			
			return CellPhone.getAll()		
		}		
	}
}

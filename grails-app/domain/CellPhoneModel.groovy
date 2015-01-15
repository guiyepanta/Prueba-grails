
public class CellPhoneModel {
	
	String name
	
	static constraints = {
		 name(blank: false, size:1..25)
	}
	
	String toString(){
		return name
	}	
}

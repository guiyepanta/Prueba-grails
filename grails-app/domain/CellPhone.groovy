
public class CellPhone {
	 
	Integer number
	String name
	CellPhoneModel model
	boolean receivesSummaryAccount
	
	static constraints = {
		number(length:10, min:1001)		
		name(blank:false, size:5..30)		
	}
}

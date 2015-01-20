import org.junit.*
import grails.test.mixin.*

public class SarazaTests {
	public class Nombre {
		String value
	}
	
	def loopNames (){
		def nombres = [
			new Nombre(value: "Guillermo"),
			new Nombre(value: "Carlos"),
			new Nombre(value: "Jorge")
		]
		
		nombres.each {
			println "${it}: ${it.value}"
		}
		
	}

}

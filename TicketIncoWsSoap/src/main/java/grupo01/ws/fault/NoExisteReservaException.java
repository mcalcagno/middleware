package grupo01.ws.fault;

import javax.xml.ws.WebFault;

@WebFault(name="NoExisteReservaFault",targetNamespace="http://ws.grupo01/")
public class NoExisteReservaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String faultInfo;
	
	public NoExisteReservaException(String message) {
		super(message);
	}
	
	public NoExisteReservaException(){
		super();
	}

	public String getFaultInfo() {
		return this.faultInfo;
	}
	

}
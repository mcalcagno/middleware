package grupo01.ws.fault;

import javax.xml.ws.WebFault;

@WebFault(name="NoExistePagoFault",targetNamespace="http://ws.grupo01/")
public class NoExistePagoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String faultInfo;
	
	public NoExistePagoException(String message) {
		super(message);
	}
	
	public NoExistePagoException(){
		super();
	}

	public String getFaultInfo() {
		return this.faultInfo;
	}
	

}
package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.opensaml.soap.wsaddressing.SoapAction;

import com.ibm.wsdl.extensions.soap.SOAPAddressImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12AddressImpl;

import grupo01.ws.CallbackWs;


@WebService(targetNamespace = "http://ws.grupo01/", portName = "CallbackWsImplPort", serviceName = "CallbackWsImplService")
public class CallbackWsImpl implements CallbackWs {

	public CallbackWsImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "confirmarReservaVentaResponse", action = "urn:confirmarReservaVentaResponse")
	@Override
	public void ConfirmarReservaVentaResponse() {
		// TODO Auto-generated method stub
		System.out.println("Llego al Callback");

	}

}

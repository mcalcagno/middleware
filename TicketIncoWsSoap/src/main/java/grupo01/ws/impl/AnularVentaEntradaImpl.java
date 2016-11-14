package grupo01.ws.impl;

import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import grupo01.database.Confirmacion;
import grupo01.database.Manejador;
import grupo01.ws.data.Constantes;
import grupo01.ws.esb.PagoExternoEsb;
import grupo01.ws.esb.PagoLocalEsb;
import grupo01.ws.fault.NoExistePagoException;
import grupo01.ws.interfaces.AnularVentaEntrada;

@WebService(targetNamespace = "http://ws.grupo01/", portName = "AnularVentaEntradaPort", serviceName = "AnularVentaEntradaService")
public class AnularVentaEntradaImpl implements AnularVentaEntrada{

	public AnularVentaEntradaImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebResult(name="idAnulacion")
	@WebMethod(operationName = "anularVentaEntrada", action = "urn:AnularVentaEntrada")
	@Override
	public Long anularVentaEntrada(@WebParam(name = "idCoonfirmacion") Long idConfirmacion,
			@WebParam(name = "idMedioPago") Long idMedioPago) throws NoExistePagoException {

		Long idAnulacion = -1L;

		try {
			Confirmacion conf = Manejador.getConfirmacion(idConfirmacion);

			if (conf != null){
				if (idMedioPago == Constantes.MEDIO_PAGO_EXTERNO){
					PagoExternoEsb pagoExt = new PagoExternoEsb();
					idAnulacion = pagoExt.cancelarPago(idConfirmacion);

				} else {
					PagoLocalEsb pagoLocal = new PagoLocalEsb();
					//pagoLocal.confirmarPago(digitoVerificador.toString(), cal, idReserva, 10d, nroTarjeta);
				}
				Manejador.createAnulacion(idConfirmacion,idAnulacion);
			} else {
				throw new NoExistePagoException("No existe pago: "+idConfirmacion);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idAnulacion;
	}

	
	
}

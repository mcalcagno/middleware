/**
 * IPagosYaConfirmadorPagos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public interface IPagosYaConfirmadorPagos extends java.rmi.Remote {
    public esb.ws.ResponseConfirmacionPagosYaData confirmarPago(esb.ws.RequestConfirmacionPagosYaData req) throws java.rmi.RemoteException;
    public esb.ws.ResponseAnulacionPagosYaData cancelarPago(esb.ws.RequestAnulacionPagosYaData idConfirmacionPago) throws java.rmi.RemoteException;
}

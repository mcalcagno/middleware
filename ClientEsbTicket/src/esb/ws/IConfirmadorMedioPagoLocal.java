/**
 * IConfirmadorMedioPagoLocal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public interface IConfirmadorMedioPagoLocal extends java.rmi.Remote {
    public esb.ws.ResponseConfirmacionMedioPagoLocalData confirmarPago(esb.ws.RequestConfirmacionMedioPagoLocalData req) throws java.rmi.RemoteException;
    public esb.ws.ResponseAnulacionMedioPagoLocalData anularPago(esb.ws.RequestAnulacionMedioPagoLocalData req) throws java.rmi.RemoteException;
}

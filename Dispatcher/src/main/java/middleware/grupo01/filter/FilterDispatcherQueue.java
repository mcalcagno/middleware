package middleware.grupo01.filter;

import java.io.StringReader;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.integration.xml.transformer.XsltPayloadTransformer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import middleware.grupo01.xslt.XSLTTransformer;

public class FilterDispatcherQueue {

	private static final String ORDEN_MONTO_EXP = "/Orden/Facturacion/Monto";
	//private static final String ORDEN_CANT_EXP = "/Orden/Item/Cantidad";
	private static final String ORDEN_SUM_CANTXPREC_EXP = "sum ( /CantidadXPrecio/Item )";
	//private static final String ORDEN_PRECIO_EXP = "/Orden/Item/Precio";
	private static final String ORDEN_PAYMENT_EXP = "/Orden/FormaPago";
	private static final String ORDEN_MONEDA_EXP = "/Orden/Facturacion/Moneda";
	private static final String ORDEN_CUOTAS_EXP = "/Orden/Facturacion/Cuotas";
	
	public boolean isValid(String msg){
		System.out.println("*************************");
		System.out.println("****FILTERING MESSAGE*****");
		boolean ret = false;
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			Node nodePayment = (Node) xpath.evaluate(ORDEN_PAYMENT_EXP, 
					new InputSource(new StringReader(msg)), XPathConstants.NODE);
			Node nodeCuotas = (Node) xpath.evaluate(ORDEN_CUOTAS_EXP, 
					new InputSource(new StringReader(msg)), XPathConstants.NODE);
			if(((nodePayment.getFirstChild().getNodeValue().equals("E") ||
					nodePayment.getFirstChild().getNodeValue().equals("C") ||
					nodePayment.getFirstChild().getNodeValue().equals("D")) && 
					nodeCuotas.getFirstChild().getNodeValue().equals("1")) ||
				(nodePayment.getFirstChild().getNodeValue().equals("X") &&
					Integer.valueOf(nodeCuotas.getFirstChild().getNodeValue()) > 1)	){
				
				Node nodeMoneda = (Node) xpath.evaluate(ORDEN_MONEDA_EXP, 
						new InputSource(new StringReader(msg)), XPathConstants.NODE);
				
				if(nodeMoneda.getFirstChild().getNodeValue().equals("840") ||
						nodeMoneda.getFirstChild().getNodeValue().equals("858")){
					Node nodeMonto = (Node) xpath.evaluate(ORDEN_MONTO_EXP, 
							new InputSource(new StringReader(msg)), XPathConstants.NODE);
					
					Double totLin = (Double) xpath.evaluate(ORDEN_SUM_CANTXPREC_EXP, 
							new InputSource(new StringReader(XSLTTransformer.transform(msg,XSLTTransformer.TO_TOTALIZAR))), 
							XPathConstants.NUMBER);
					
					Double monto = new Double(nodeMonto.getFirstChild().getNodeValue());
					
					return monto.equals(new Double(totLin));
				}
			}
		}catch (XPathExpressionException e) {
			e.printStackTrace();
		}catch(TransformerException e){
			e.printStackTrace();
		}
		return ret;		
	}
		
}

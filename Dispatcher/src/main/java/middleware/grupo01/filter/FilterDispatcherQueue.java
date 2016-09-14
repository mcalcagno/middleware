package middleware.grupo01.filter;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FilterDispatcherQueue /*implements MessageSelector*/ {

	private static final String ORDEN_MONTO_EXP = "/Orden/Facturacion/Monto";
	private static final String ORDEN_CANT_EXP = "/Orden/Item/Cantidad";
	//private static final String ORDEN_SUM_CANTXPREC_EXP = "SUM( /Orden/Item/Cantidad )";
	private static final String ORDEN_PRECIO_EXP = "/Orden/Item/Precio";
	private static final String ORDEN_PAYMENT_EXP = "/Orden/FormaPago";
	private static final String ORDEN_CUOTAS_EXP = "/Orden/Facturacion/Cuotas";
	
	public boolean isValid(String msg){
		System.out.println("*************************");
		System.out.println("******FILTER INICIO******");
		System.out.println("*************************");
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
				
				Node nodeMonto = (Node) xpath.evaluate(ORDEN_MONTO_EXP, 
						new InputSource(new StringReader(msg)), XPathConstants.NODE);
				
				/*Node nodeSumCantxPrec = (Node) xpath.evaluate(ORDEN_SUM_CANTXPREC_EXP, 
						new InputSource(new StringReader(msg)), XPathConstants.NUMBER);*/
				
				NodeList nodesPrecio = (NodeList) xpath.evaluate(ORDEN_PRECIO_EXP, new InputSource(new StringReader(msg)), XPathConstants.NODESET);
				NodeList nodesCant = (NodeList) xpath.evaluate(ORDEN_CANT_EXP, new InputSource(new StringReader(msg)), XPathConstants.NODESET);
				Double monto = new Double(nodeMonto.getFirstChild().getNodeValue());
				double acumItem = 0.0;
				if(nodesPrecio.getLength()==nodesCant.getLength()){
					for(int i = 0;i<nodesPrecio.getLength();i++){
						acumItem += new Double(nodesPrecio.item(i).getFirstChild().getNodeValue())
								* new Double(nodesCant.item(i).getFirstChild().getNodeValue());
					}
					return monto.equals(new Double(acumItem));
				}
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return ret;		
	}
		
}

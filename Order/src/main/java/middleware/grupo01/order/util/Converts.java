package middleware.grupo01.order.util;

import middleware.grupo01.order.xml.CategoryXml;
import middleware.grupo01.order.xml.CurrencyXml;
import middleware.grupo01.order.xml.PaymentXml;

public class Converts {

	public PaymentXml getFormaPago(String fpago){

		if (PaymentXml.CHEQUE.equals(fpago)){
			return PaymentXml.CHEQUE;

		} else if (PaymentXml.CREDITO.equals(fpago)){
			return PaymentXml.CREDITO;

		} else if (PaymentXml.DEBITO.equals(fpago)){
			return PaymentXml.DEBITO;

		} else {
			return PaymentXml.EFECTVO;
		}

	}
	
	public static CategoryXml getCategoria(String categoria){
		
		if (ConstantsUtil.MOBILE_SYS.equals(categoria)){
			return CategoryXml.MOBILE;
		} else if (ConstantsUtil.DATA_SYS.equals(categoria)){
			return CategoryXml.DATA;
		} else{
			return CategoryXml.RED_STRAWBERRY;
		}
	}
	
	public static CurrencyXml getMoneda(String fPago){
		
		if (ConstantsUtil.PESOS.equals(fPago)){
			return CurrencyXml.PESOS;
		} else{
			return CurrencyXml.DOLARES;
		}
		
	}
	
}

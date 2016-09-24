package middleware.grupo01.order.util;

import org.apache.activemq.ActiveMQConnection;

public class ConstantsUtil {

	public static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static String DISPACHER_QUEUE = "DISPACHER_QUEUE"; 
	public static String OPCION_INGRESAR = "1";
	public static String OPCION_CARGAR = "2";
	public static String OPCION_FINALIZAR = "3";
	public static String OPCION_FINALIZAR_ITEM = "2";
	
	public static String EFECTIVO = "e";
	public static String DEBITO = "d";
	public static String CHEQUE = "c";
	public static String CREDITO = "cd";
	
	public static String PESOS = "$";
	public static String DOLARES = "usd";
	
	public static String MOBILE_SYS = "m";
	public static String DATA_SYS = "d";
	public static String RED_STRAWBERRY = "r";
	
	public static String PATH_FILE_LOAD = "C:\\obligatorio1\\middleware\\Order\\src\\main\\resources\\CargarDatos.properties";
}

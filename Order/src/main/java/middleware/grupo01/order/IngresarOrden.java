package middleware.grupo01.order;

import java.util.Date;
import java.util.Scanner;

import middleware.grupo01.order.util.ConstantsUtil;
import middleware.grupo01.order.util.Converts;
import middleware.grupo01.order.xml.FacturationXml;
import middleware.grupo01.order.xml.ItemXml;
import middleware.grupo01.order.xml.PurcharseOrderXml;

public class IngresarOrden {

	private static Scanner scan = new Scanner(System.in);
	
	public static void opcionIngresar(){

		Converts converter = new Converts();
		PurcharseOrderXml orden = new PurcharseOrderXml();
		System.out.println("############################################################################");
		System.out.println("############################################################################");
		
		orden.setFecCreacion(new Date());
		
		System.out.print(">Numero Orden: ");
		String nroOrden = scan.next();
		orden.setNroOrden(new Long(nroOrden));
		
		System.out.print(">Identificador Cliente: ");
		String idCliente = scan.next();
		orden.setIdCliente(new Long(idCliente));
		
		FacturationXml f = new FacturationXml();
		String fPago = "";
		while (!(ConstantsUtil.CHEQUE.equals(fPago) || ConstantsUtil.CREDITO.equals(fPago) || ConstantsUtil.DEBITO.equals(fPago) || ConstantsUtil.EFECTIVO.equals(fPago))){
			System.out.print(">Forma Pago: ");
			fPago = scan.next();
			if (!(ConstantsUtil.CHEQUE.equals(fPago) || ConstantsUtil.CREDITO.equals(fPago) || ConstantsUtil.DEBITO.equals(fPago) || ConstantsUtil.EFECTIVO.equals(fPago))){
				System.out.println("Forma de Pago no válida...");
			} else {
				orden.setfPago(converter.getFormaPago(fPago));
			}
		}
		
		FacturationXml fact = new FacturationXml();
		
		System.out.print(">Cuotas: ");
		String cuotas = scan.next();
		String moneda = "";
		while (!(ConstantsUtil.PESOS.equals(moneda) || ConstantsUtil.DOLARES.equals(moneda))){
			System.out.print(">Moneda: ");
			moneda = scan.next();
			if (!(ConstantsUtil.PESOS.equals(moneda) || ConstantsUtil.DOLARES.equals(moneda))){
				System.out.println(">Moneda no válida...");
			}
		}
		
		System.out.print(">Monto: ");
		String monto = scan.next();
		
		fact.setCuotas(new Integer(cuotas));
		fact.setMoneda(converter.getMoneda(moneda));
		fact.setMonto(new Double (monto));
		orden.setFacturacion(fact);
		
		ItemXml item = null; 
		boolean finAgregar = false;
		
		while (!finAgregar){
			item = agregarItem();
			if (item != null){
				orden.getItems().add(item);
			} else {
				finAgregar = true;
			}
		};
		
		EnviarOrden.enviar(orden);
		
	}
	
	
	
	private static ItemXml agregarItem(){

		System.out.println("############################################################################");
		System.out.println("##############################  AGREGAR ITEM  ##############################");
		System.out.println("############################################################################");
		System.out.println();
		System.out.println("Seleccionar Opción:");
		System.out.println(" 1) Ingresar Item");
		System.out.println(" 2) Finalizar");
		System.out.println();
		System.out.print(">");
		String opcion = scan.next();
		ItemXml item = null;
		Converts converter = new Converts();
		
		if (!ConstantsUtil.OPCION_FINALIZAR_ITEM.equals(opcion)){
			item = new ItemXml();
			System.out.println();
			System.out.println("############################################################################");
			System.out.println("############################################################################");
			System.out.print(">Numero Item: ");
			String nroItem = scan.next();
			item.setNroItem(new Long(nroItem));
			
			System.out.print(">Cantidad: ");
			String cantidad = scan.next();
			item.setCantidad(new Integer(cantidad));

			String categoria = "";
			while (!(ConstantsUtil.RED_STRAWBERRY.equals(categoria) || ConstantsUtil.DATA_SYS.equals(categoria) || ConstantsUtil.MOBILE_SYS.equals(categoria))){
				System.out.print(">Categoria: ");
				categoria = scan.next();
				if (!(ConstantsUtil.RED_STRAWBERRY.equals(categoria) || ConstantsUtil.DATA_SYS.equals(categoria) || ConstantsUtil.MOBILE_SYS.equals(categoria))){
					System.out.println("Categoria no válida...");
				} else {
					item.setCategoria(converter.getCategoria(categoria));
				}
			}

			System.out.print(">Descripcion: ");
			String descripcion = scan.next();
			item.setDescripcion(descripcion);
			
			System.out.print(">Identificador Producto: ");
			String idProducto = scan.next();
			item.setIdProducto(new Long(idProducto));
			
			System.out.print(">Precio: ");
			String precio = scan.next();
			item.setPrecio(new Double(precio));
			
		} 
			return item;
		
	}
	
}

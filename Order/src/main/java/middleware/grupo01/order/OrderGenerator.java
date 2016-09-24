package middleware.grupo01.order;

import java.util.Scanner;

import middleware.grupo01.order.util.ConstantsUtil;

public class OrderGenerator 
{

	public static void main( String[] args ) throws Exception
    {
		Scanner scan = new Scanner(System.in);
		String opcion = "";
		
		while (!ConstantsUtil.OPCION_FINALIZAR.equals(opcion)){
			
		System.out.println("############################################################################");
		System.out.println("##############################  GENERAR ORDEN ##############################");
		System.out.println("############################################################################");
		System.out.println();
		System.out.println("Seleccionar Opción:");
		System.out.println(" 1) Ingresar Orden");
		System.out.println(" 2) Cargar Orden");
		System.out.println(" 3) Finalizar");
		System.out.println();
		System.out.print(">");
		opcion = scan.next();
		
		if (ConstantsUtil.OPCION_INGRESAR.equals(opcion)){
			IngresarOrden.opcionIngresar();
		} else if (ConstantsUtil.OPCION_CARGAR.equals(opcion)){
			CargarOrden.cargar();
		} else if (!ConstantsUtil.OPCION_FINALIZAR.equals(opcion)){
			System.out.println("Opcion no válida...");
		}
		
		}
    }    
	
	
	
}

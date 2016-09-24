package middleware.grupo01.order;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import middleware.grupo01.order.util.ConstantsUtil;
import middleware.grupo01.order.util.Converts;
import middleware.grupo01.order.xml.CategoryXml;
import middleware.grupo01.order.xml.FacturationXml;
import middleware.grupo01.order.xml.ItemXml;
import middleware.grupo01.order.xml.PurcharseOrderXml;

public class CargarOrden {

	public static void cargar(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(ConstantsUtil.PATH_FILE_LOAD);
			prop.load(input);
			
			String nroOrden = prop.getProperty("nroOrden");
			String idCliente = prop.getProperty("idCliente");
			String formaPago = prop.getProperty("formaPago");
			String monto = prop.getProperty("monto");
			String moneda = prop.getProperty("moneda");
			String cuotas = prop.getProperty("cuotas");
			
			Converts converter = new Converts();
			PurcharseOrderXml orden = new PurcharseOrderXml();
			orden.setNroOrden(new Long(nroOrden));
			orden.setIdCliente(new Long(idCliente));
			orden.setFecCreacion(new Date());
			orden.setfPago(converter.getFormaPago(formaPago));
			
			FacturationXml factura = new FacturationXml();
			factura.setCuotas(new Integer(cuotas));
			factura.setMonto(new Double(monto));
			factura.setMoneda(converter.getMoneda(moneda));
			orden.setFacturacion(factura);
			
			String totalDataSys= prop.getProperty("totalDataSys");
			String nroItemDataSys = prop.getProperty("nroItemDataSys");
			String idProductoDataSys = prop.getProperty("idProductoDataSys");
			String descripcionDataSys = prop.getProperty("descripcionDataSys");
			String cantDataSys = prop.getProperty("cantDataSys");
			String precioDataSys = prop.getProperty("precioDataSys");
			
			Integer total;
			Long nroItem;
			Long idProducto;
			Integer cantItem;
			Double precio;
			ItemXml item;
			
			if (!totalDataSys.isEmpty() && (!"".equals(totalDataSys))){
				total = new Integer(totalDataSys);
				nroItem = new Long(nroItemDataSys);
				idProducto = new Long(idProductoDataSys);
				cantItem = new Integer(cantDataSys);
				precio = new Double(precioDataSys);
				
				for (int i = 0; i< total.intValue(); i++){
					item = new ItemXml();
					item.setIdProducto(idProducto);
					item.setPrecio(precio);
					item.setCantidad(cantItem);
					item.setDescripcion(descripcionDataSys);
					item.setCategoria(CategoryXml.DATA);
					item.setNroItem(nroItem);
					orden.getItems().add(item);
					idProducto++;
					nroItem++;
				}
			}
			
			
			
			String totalMobile = prop.getProperty("totalMobile");
			String nroItemMobile = prop.getProperty("nroItemMobile");
			String idProductoMobile = prop.getProperty("idProductoMobile");
			String descripcionMobile = prop.getProperty("descripcionMobile");
			String cantMobile = prop.getProperty("cantMobile");
			String precioMobile = prop.getProperty("precioMobile");
			
			if (!totalMobile.isEmpty() && (!"".equals(totalMobile))){
				total = new Integer(totalMobile);
				nroItem = new Long(nroItemMobile);
				idProducto = new Long(idProductoMobile);
				cantItem = new Integer(cantMobile);
				precio = new Double(precioMobile);
				
				for (int i = 0; i< total.intValue(); i++){
					item = new ItemXml();
					item.setIdProducto(idProducto);
					item.setPrecio(precio);
					item.setCantidad(cantItem);
					item.setDescripcion(descripcionMobile);
					item.setCategoria(CategoryXml.MOBILE);
					item.setNroItem(nroItem);
					orden.getItems().add(item);
					idProducto++;
					nroItem++;
				}
			}
			
			
			
			String totalStrawBerry = prop.getProperty("totalRedStrawBerry");
			String nroItemStrawBerry = prop.getProperty("nroItemRedStrawBerry");
			String idProdStrawBerry = prop.getProperty("idProductoRedStrawBerry");
			String descStrawBerry = prop.getProperty("descripcionRedStrawBerry");
			String cantStrawBerry = prop.getProperty("cantRedStrawBerry");
			String precioStrawBerry = prop.getProperty("precioRedStrawBerry");
			
			if (!totalStrawBerry.isEmpty() && (!"".equals(totalStrawBerry))){
				total = new Integer(totalStrawBerry);
				nroItem = new Long(nroItemStrawBerry);
				idProducto = new Long(idProdStrawBerry);
				cantItem = new Integer(cantStrawBerry);
				precio = new Double(precioStrawBerry);
				
				for (int i = 0; i< total.intValue(); i++){
					item = new ItemXml();
					item.setIdProducto(idProducto);
					item.setPrecio(precio);
					item.setCantidad(cantItem);
					item.setDescripcion(descStrawBerry);
					item.setCategoria(CategoryXml.RED_STRAWBERRY);
					item.setNroItem(nroItem);
					orden.getItems().add(item);
					idProducto++;
					nroItem++;
				}
			}		
			
			EnviarOrden.enviar(orden);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  
	}
}

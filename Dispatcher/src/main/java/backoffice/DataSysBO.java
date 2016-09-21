package backoffice;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerException;

import middleware.grupo01.entidad.DataSysItemOrden;
import middleware.grupo01.xslt.XSLTTransformer;

public class DataSysBO {

	
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/datasys";

	// Database Credentials
	static final String USER = "postgres";
	static final String PASS = "admin";
	
	
	public void receive(String message) {
		System.out.println("Realizando comunicacion con DataSys...");
		String messageDataSys;
		try {
			messageDataSys = XSLTTransformer.transformItemOrdenToDataSys(message);
			persistOrder(messageDataSys);
		} catch (TransformerException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	private DataSysItemOrden unmarshallListOfOrders(String orden) throws JAXBException{
		System.out.println("Parseando orden...");
		JAXBContext jaxbContext = JAXBContext.newInstance(DataSysItemOrden.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		DataSysItemOrden dataOrden = (DataSysItemOrden) unmarshaller.unmarshal(new StringReader(orden)); 
		System.out.println("Orden parseada: "+ "Id cliente: "+dataOrden.getIdCliente()+" - "+"Id producto: "+dataOrden.getIdProducto()+" - "+
		"cantidad: "+dataOrden.getCantidad()+" - "+ "Id orden: "+dataOrden.getIdOrden()+" - "+"Id item: "+dataOrden.getIdItem());
		return dataOrden;
	}
	
	private void persistOrder(String orden) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// Register JDBC Driver
			Class.forName(JDBC_DRIVER);

			// Open a Connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// Insert the Order
			System.out.println("Inserting records into the 'orders' table...");
			stmt = conn.createStatement();

			DataSysItemOrden dataOrden = unmarshallListOfOrders(orden);

			String sql = "INSERT INTO orders"
					+ "(clientId, productId, quantity, orderId, itemId) "
					+ "VALUES ("+dataOrden.getIdCliente()+","+dataOrden.getIdProducto()+","+dataOrden.getCantidad()+","
					+ ""+dataOrden.getIdOrden()+","+dataOrden.getIdItem()+")";

			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table..."); 

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
	
	
}

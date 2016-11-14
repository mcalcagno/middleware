package grupo01.ws.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.ws.CallbackWs;


@WebService(targetNamespace = "http://ws.grupo01/", portName = "CallbackWsImplPort", serviceName = "CallbackWsImplService")
public class CallbackWsImpl implements CallbackWs {

	public CallbackWsImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "notificacionConfirmacionReserva", action = "urn:notificacionConfirmacionReserva")
	@Override
	public void NotificacionConfirmacionReserva(@WebParam(name="entrada") EntradaData entrada) {
		
		try {
			File ent1File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\d\\ent1.jpg");
			ImageIO.write(toBufferImage(entrada.getImagenes().get(0)), "jpg", ent1File);
			File ent2File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\d\\ent2.jpg");
			ImageIO.write(toBufferImage(entrada.getImagenes().get(1)), "jpg", ent2File);
			File ent3File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\d\\ent3.png");
			ImageIO.write(toBufferImage(entrada.getImagenes().get(2)), "png", ent3File);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Llego al Callback-idConfirmacion->"+entrada.getIdConfirmacion());
	}

	
	
	private BufferedImage toBufferImage(Image img){
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    return bimage;
	}
	
}

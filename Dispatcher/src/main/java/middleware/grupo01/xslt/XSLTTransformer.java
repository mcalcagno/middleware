package middleware.grupo01.xslt;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XSLTTransformer {

	public static String transformOrdenToItemOrden(String input) throws TransformerException{

		StreamSource source = new StreamSource(new StringReader(input));
	    StreamSource stylesource = new StreamSource(new File("src\\main\\resources\\OrdenToItemOrden-XSLT.xml"));

	    StringWriter writer = new StringWriter();
	    
	    TransformerFactory factory = TransformerFactory.newInstance();
	    Transformer transformer = factory.newTransformer(stylesource);
	    StreamResult result = new StreamResult(writer);
	    transformer.transform(source, result);

	    return writer.toString();
	}
	
	public static String transformItemOrdenToMobileSys(String input) throws TransformerException{

		StreamSource source = new StreamSource(new StringReader(input));
	    StreamSource stylesource = new StreamSource(new File("src\\main\\resources\\ItemOrdenToMobileSys-XSLT.xml"));

	    StringWriter writer = new StringWriter();
	    
	    TransformerFactory factory = TransformerFactory.newInstance();
	    Transformer transformer = factory.newTransformer(stylesource);
	    StreamResult result = new StreamResult(writer);
	    transformer.transform(source, result);

	    return writer.toString();
	}
	
}

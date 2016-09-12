package middleware.grupo01.split;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;

import org.springframework.integration.annotation.Splitter;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import middleware.grupo01.xslt.XSLTTransformer;

public class SplitMessageByCategory {
	
	@Splitter
	public List<String> split(String msg) {
        List<String> list = new ArrayList<String>();
        try {
			String transform = XSLTTransformer.transformOrdenToItemOrden(msg);
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate("/ItemsOrden/ItemOrden", 
					new InputSource(new StringReader(transform)), XPathConstants.NODESET);
			for(int i=0;i<nodes.getLength();i++){
				//list.add(nodes.item(i));
				list.add(nodeToString(nodes.item(i)));
			}
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (XPathException e) {
			e.printStackTrace();
		}
		return list;
    }
	
	private String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			t.transform(new DOMSource(node), new StreamResult(sw));
		}catch (TransformerException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

}

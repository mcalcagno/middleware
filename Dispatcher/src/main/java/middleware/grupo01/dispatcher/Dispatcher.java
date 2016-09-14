package middleware.grupo01.dispatcher;


import org.apache.activemq.ActiveMQConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dispatcher 
{
	public static void main( String[] args ) throws JMSException
    {
    	System.out.println("*************************");
		System.out.println("****DISPATCHER INICIO****");
		System.out.println("*************************");
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/context.xml", Dispatcher.class);
    }
    
}

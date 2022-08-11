package pruebacola;


import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ClienteMensajeria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Context context;
		try {
		    final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080"));
            env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "sa4"));
            env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "asd"));
            context = new InitialContext(env);
 
            // Perform the JNDI lookups
            String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
 
            String destinationString = System.getProperty("destination", "java:/jms/queue/Test5");
            Destination destination = (Destination) context.lookup(destinationString);
 
            // Create the JMS connection, session, producer, and consumer
            Connection connection = connectionFactory.createConnection(System.getProperty("username", "sa4"), System.getProperty("password", "asd"));
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
           // consumer = session.createConsumer(destination);
            connection.start();
			// crear un producer para enviar mensajes usando la session
			MessageProducer producer = session.createProducer(destination);
			// crear un mensaje de tipo text y setearle el contenido
			TextMessage message = session.createTextMessage();
			message.setText("{\"idarticulo\" : \"1\" , \"codigo\" : \"4\", \"nombre\": \"Pintura\", \"descripcion\" : \"No Sirve\", \"deposito\" : \"DP01\" }");
			// enviar el mensaje
			producer.send(message);
			// TODO: recordar cerrar la session y la connection en un bloque “finally”
			connection.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

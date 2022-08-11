package mensajes.configuracionColaMensajes;

import java.io.Serializable; 
import javax.jms.*; 
import javax.naming.*;

public class MensajeAsincronico {
	public static void enviarObjeto(String url, String queueName, String user, String password, Serializable objeto) throws Exception {

		System.out.println("Enviando mensaje asincronico:" +
				" url: " + url + " queueName: " + queueName + " user: " + user + " password: " + password);

		Connection connection = null;
		Session session = null;

		try {
			// Creo la conexion 
			InitialContext context = new InitialContext(); 
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(url); 

			connection = connectionFactory.createConnection(user, password); 
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 

			Queue queue = session.createQueue(queueName); 
			MessageProducer producer = session.createProducer(queue); 
			connection.start();

			// Creo el mensaje 
			ObjectMessage message = session.createObjectMessage(); 

			// Asigno el objeto al mensaje 
			message.setObject(objeto); 

			// Envio mensaje 
			producer.send(message); 

			// Cierro la conexion 
			connection.close();
		} catch (Exception e) {
			throw e;
		} finally {
			// Cerrar la session y la connection
			if (session != null) session.close();
			if (connection != null) connection.close();
		}
	}
}

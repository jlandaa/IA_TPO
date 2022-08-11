package mensajes.colaMensajes;

import interfaces.remota.administradoresServicios.ServicioArticulos;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import mensajes.configuracionColaMensajes.Configuracion;
import mensajes.configuracionColaMensajes.Logger;
import ClasesVO.ArticuloVO;

//En la puesta en comun existira un solo topic en el modulo de logistica
//al cual todos los demas modulos se suscriben.
//Por ello, existir un solo OnMessage

//El MessageDriven es el que indica de que cola hay que leer los mensajes en este caso Test5
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jboss/exported/jms/topic/t_nuevosarticulos "), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jboss/exported/jms/topic/t_nuevosarticulos")


public class NuevoArticuloMDB implements MessageListener { 

	@EJB
	private ServicioArticulos servicioArticulos;
	
	//Tomo mensajes de esa cola
	public void onMessage(Message message) { 
		
		if (message instanceof ObjectMessage) { 

			try { 
				
				//PRUEBA
				TextMessage m = (TextMessage) message;
				//PRUEBA
				String contenido = m.getText();
				System.out.println(contenido);
				
				ObjectMessage inboundMessage = (ObjectMessage) message; 
				
				// PROBAR ESTO Y SI NO ANDA LO DE DAMIAN
				ArticuloVO articulo = (ArticuloVO) inboundMessage.getObject();
				
				/*En el topic de Logistica solo publica deposito por lo
				 * tanto, es un mensaje que contiene toda la informacion
				 * y solo hay que quedarnos con lo que necesitamos
				 * En este caso, con el OnMessage obtenemos el mensaje
				 * (en teoria es un String) se lo mandamos a la funcion
				 * ingresarArticulo y dentro hay que convertir el String
				 * en JSON y de JSON a ArticuloVO*/
				
				this.servicioArticulos.ingresarArticulo(articulo);
				
			} catch (Exception e) { 
				e.printStackTrace();
				Logger.error("DCH01", e.getMessage());
			} 
		} 
	}
}

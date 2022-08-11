package mensajes.configuracionColaMensajes;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MensajeSincronicoRest {

	public static void post(String url, Object objeto) throws Exception {
		try { 
			// Creo el JSON 
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String json = gson.toJson(objeto); 

			// Armo el request
			ClientRequest request = new ClientRequest(url); 
			request.accept("application/json"); 
			request.body("application/json", json);

			ClientResponse<String> response = request.post(String.class); 

			if (response.getStatus() != 200) { 
				// Error
				BufferedReader br = new BufferedReader(new InputStreamReader( 
						new ByteArrayInputStream(response.getEntity().getBytes())));

				String output;
				String responseText = "";

				while ((output = br.readLine()) != null) { 
					responseText = responseText + output; 
				}
				
				throw new Exception("Status Code: " + response.getStatus() + " - Message: " + responseText);
			}  

		} catch (Exception e) { 
			throw e;
		}
	}
}

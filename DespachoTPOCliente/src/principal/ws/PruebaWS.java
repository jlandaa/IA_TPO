package principal.ws;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class PruebaWS {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/DespachoTPOWeb/services/articulos/agregar");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "text/plain");
//		Alternativa 1: armar el String directamente en formato Json y enviarlo en el request
		IOUtils.write("{\"idarticulo\" : \"1\" , \"codigo\" : \"4\", \"nombre\": \"Pintura\", \"descripcion\" : \"No Sirve\", \"deposito\" : \"DP01\" }", urlConnection.getOutputStream());
		if(urlConnection.getResponseCode() != 200) {
			throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
		}
		String response = IOUtils.toString(urlConnection.getInputStream());
		System.out.println("Respuesta: " + response);
	}

}

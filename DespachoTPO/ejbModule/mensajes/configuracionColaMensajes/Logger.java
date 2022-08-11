package mensajes.configuracionColaMensajes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Logger {
	
	public static void error(String evento, String message) {
		logMessage(evento, "[ERROR] " + message, true);
	}
	
	public static void info(String evento, String message) {
		logMessage(evento, "[INFO] " + message, false);
	}
	
	public static void warning(String evento, String message) {
		logMessage(evento, "[WARNING] " + message, true);
	}
	
	private static void logMessage(String evento, String message, Boolean error) {
		try {
			System.out.println(message);
			
			String logCodigoModulo = Configuracion.getInstancia().get().get("CodigoModuloParaLog");
			String modulo = Configuracion.getInstancia().get().get("NombreDespacho");
			String logAsincrono = Configuracion.getInstancia().get().get("logAsincrono");
			
			if (logAsincrono == "true") {
				// Log por queue
				vo.MensajeLogVO mensajeLog = new vo.MensajeLogVO();
				mensajeLog.setCodModulo(Integer.parseInt(logCodigoModulo));
				mensajeLog.setModulo(modulo);
				mensajeLog.setEvento(evento);
				mensajeLog.setFecha(new Date());
				mensajeLog.setTipo(error ? 1 : 0);
				
				MensajeAsincronico.enviarObjeto(
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Url"),
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Nombre"), 
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Usuario"),
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Password"), 
						mensajeLog);
			}
			else if (logAsincrono == "false") {
				// Log por web service
				sessionBeans.MensajeLogVO mensajeLog = new sessionBeans.MensajeLogVO();
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(new Date());
				mensajeLog.setCodModulo(Integer.parseInt(logCodigoModulo));
				mensajeLog.setModulo(modulo);
				mensajeLog.setEvento(evento);
				mensajeLog.setFecha(calendar);
				mensajeLog.setTipo(error ? 1 : 0);
				
				MensajeSincronicoWS.loguearEvento(mensajeLog);
			}
		}
		catch (Throwable e) {
			// e.printStackTrace();
			System.out.println("[ERROR] Ocurrio un error al intentar loguear: " + e.getMessage());
		}
	}
}

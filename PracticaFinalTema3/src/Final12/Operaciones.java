package Final12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	private static String ficheroUsuario = "PracticaFinalTema3/src/Usuarios.txt";
	private static String ficheroHistorico = "PracticaFinalTema3/src/Historico.txt";

	public static boolean comprobacionCorreo(String correoEscrito) {
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(correoEscrito);
		
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static String prueba(String periodico, String seccionTitular) throws IOException {
		Document document = Jsoup.connect(periodico).get();
		Element titular = document.select(seccionTitular).get(0);
		
		return "- " + titular.text();
	}

	public static void escribirUsuario(Usuario nuevoUsuario) throws IOException {
		BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroUsuario, true));
		
		pw.write(nuevoUsuario.getIdUsuario() + ";" + nuevoUsuario.getNombreUsuario() + ";" + nuevoUsuario.getContrasenia() + ";" + nuevoUsuario.getCorreoElectronico() + ";" + nuevoUsuario.isPrimeraVez() + ";" + nuevoUsuario.getTu());
		pw.newLine();

		pw.close();
	}

	public static void borrarUsuario(int idUsuarioBorrar) throws IOException {
		List<String []> datos = ManejoFicheros.lectura(ficheroUsuario);
		int i = 0;

		BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroUsuario));
		while(i < datos.size()) {
			IO.println(idUsuarioBorrar);
			IO.println(datos.get(i)[0]);
			if(Integer.parseInt(datos.get(i)[0]) != idUsuarioBorrar) {
				bw.write(datos.get(i)[0] + ";" + datos.get(i)[1] + ";" + datos.get(i)[2] + ";" + datos.get(i)[3] + ";" + datos.get(i)[4] + ";" + datos.get(i)[5]);
				bw.newLine();
			}
			
			i++;
		}

		bw.close();
	}

	
	/*
	public static void anyadirSelecciones(int selecciones, Periodico periodico, Usuario usuario) {
		String[] seleccionesActuales = periodico.getSelecciones();
		String idUsuario = String.valueOf(usuario.getIdUsuario());
		String[] nuevoArray;

		if (seleccionesActuales == null) {
			nuevoArray = new String[]{idUsuario};
		} else {
			int longitudActual = seleccionesActuales.length;

			nuevoArray = Arrays.copyOf(seleccionesActuales, longitudActual + 1);
			nuevoArray[longitudActual] = idUsuario;
		}

		periodico.setSelecciones(nuevoArray);
	}
	*/

	public static void reescribirUsuarios(List<Usuario> listaUsuarios) throws IOException {
		BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroUsuario)); 
		
		for (Usuario u : listaUsuarios) {
			pw.write(u.getIdUsuario() + ";" + u.getNombreUsuario() + ";" + u.getContrasenia() + ";" + u.getCorreoElectronico() + ";" + u.isPrimeraVez() + ";" + u.getTu());
			pw.newLine();
		}

		pw.close();
	}

	public static boolean enviarEmailTest(String cuerpo) {
		try {
			enviarNoticias(cuerpo);

			return true;
		} catch(Exception e) {
			Eventos.error("Error a la hora de enviar el correo. Cerrando programa");
			Principal.v.dispose();
			System.exit(0);
			return false;
		}
	}

	public static void enviarNoticias(String contenidoEmail) {
		final String fromEmail = "bryanandreujimenezrojas@outlook.es";
		final String password = "KJ3BS-LTZ7D-2M9FU-7ZH3W-TTVB2";
		final String toEmail = "bryanandreujimenezrojas@outlook.es";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");	
		
		Authenticator auth = new Authenticator() {		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};	
			
		Session session = Session.getDefaultInstance(props, auth);
		
		enviarEmail(session, toEmail,"Noticias \"Galio Informativo\"", contenidoEmail);
	}
	
	public static boolean enviarEmail(Session session, String toEmail, String subject, String body){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "Noticias \"Galio Informativo\""));      	      
			msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));	      
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);

			return true;
		} catch (Exception e) {
			Eventos.error("Error en el envio del Correo");

			return false;
	    }
	}

	public static void escribirHistorico(Usuario usuario, String tipoNoticia, String titular, String url) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHora = LocalDateTime.now().format(dtf);
		String linea = String.format("%d;%s;%s;%s;%s", usuario.getIdUsuario(), fechaHora, tipoNoticia, titular.replace(";", ",").replace("\n", " "), url);

		BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroHistorico, true)); 
		pw.write(linea);
		pw.newLine();
		
		pw.close();
	}
}


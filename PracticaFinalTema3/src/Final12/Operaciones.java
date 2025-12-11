package Final12;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	public static void prueba() throws IOException {
		String web = "https://www.elperiodico.com/es/videojuegos/";
		Document document = Jsoup.connect(web).get();
		Element titular = document.select("h2.ft-org-cardHome__mainTitle").get(0);
		System.out.println((1) + ". " + titular.text());
	}
}


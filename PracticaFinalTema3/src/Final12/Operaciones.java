package Final12;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Operaciones {
	public static void prueba() throws IOException {
		String web = "https://elpais.com/espana/";
		Document document = Jsoup.connect(web).get();
		Elements titulares = document.select("h2.c_t, h3.c_t");
		
		for (int i = 0; i < 3; i++) {
			Element titular = titulares.get(i);
			System.out.println((i+1) + ". " + titular.text());
		}
	}
}


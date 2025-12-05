package Final12;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	public static String traducir(String text) throws IOException {
		String web = "https://www.spanishdict.com/translate/" + text;
		Document document = Jsoup.connect(web).get();
		Element palabraTraducida = document.select("div#quickdef1-es a.tCur1iYh").get(0);
		String palabra = palabraTraducida.html().toUpperCase();

		return palabra;
	}
}

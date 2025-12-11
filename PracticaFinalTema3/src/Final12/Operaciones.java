package Final12;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	public static String prueba(String periodico, String seccionTitular) throws IOException {
		Document document = Jsoup.connect(periodico).get();
		Element titular = document.select(seccionTitular).get(0);
		
		return (1) + ". " + titular.text();
	}
}


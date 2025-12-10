package Final12;

public class Periodicos {
	private int idPeriodico;
	private String urlPeriodico;
	private String contenedorNoticia;
	private TipoNoticia tn;
	
	public int getIdPeriodico() {
		return idPeriodico;
	}
	public void setIdPeriodico(int idPeriodico) {
		this.idPeriodico = idPeriodico;
	}

	public String getUrlPeriodico() {
		return urlPeriodico;
	}
	public void setUrlPeriodico(String urlPeriodico) {
		this.urlPeriodico = urlPeriodico;
	}
	
	public String getContenedorNoticia() {
		return contenedorNoticia;
	}
	public void setContenedorNoticia(String contenedorNoticia) {
		this.contenedorNoticia = contenedorNoticia;
	}
	
	public TipoNoticia getTn() {
		return tn;
	}
	public void setTn(TipoNoticia tn) {
		this.tn = tn;
	}

	public Periodicos(int idPeriodico, String urlPeriodico, String contenedorNoticia, TipoNoticia tn) {
		this.idPeriodico = idPeriodico;
		this.urlPeriodico = urlPeriodico;
		this.contenedorNoticia = contenedorNoticia;
		this.tn = tn;
	}
}

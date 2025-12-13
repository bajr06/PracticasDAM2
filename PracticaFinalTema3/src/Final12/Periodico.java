package Final12;

public class Periodico {
	private int idPeriodico;
	private String urlPeriodico;
	private String contenedorNoticia;
	private TipoNoticia tn;
	private String [] selecciones;
	
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

	public String[] getSelecciones() {
		return selecciones;
	}
	public void setSelecciones(String[] selecciones) {
		this.selecciones = selecciones;
	}

	public Periodico(int idPeriodico, String urlPeriodico, String contenedorNoticia, TipoNoticia tn, String[] selecciones) {
		this.idPeriodico = idPeriodico;
		this.urlPeriodico = urlPeriodico;
		this.contenedorNoticia = contenedorNoticia;
		this.tn = tn;
		this.selecciones = selecciones;
	}


	@Override
	public String toString() {
		return "Periodicos [ID del Periodico = " + idPeriodico + ", URL del Periodico = " + urlPeriodico + ", Contenedor de la Noticia = " + contenedorNoticia + ", Tipo de Noticia = " + tn + ", Usuarios que la siguen" + selecciones + "]";
	}
}

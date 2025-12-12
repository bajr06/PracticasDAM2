package Final12;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String contrasenia;
	private String correoElectronico;
	private boolean primeraVez;
	private TipoUsuario tu;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public boolean isPrimeraVez() {
		return primeraVez;
	}
	public void setPrimeraVez(boolean primeraVez) {
		this.primeraVez = primeraVez;
	}

	public TipoUsuario getTu() {
		return tu;
	}
	public void setTu(TipoUsuario tu) {
		this.tu = tu;
	}

	
	public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String correoElectronico, boolean primeraVez, TipoUsuario tu) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.correoElectronico = correoElectronico;
		this.primeraVez = primeraVez;
		this.tu = tu;
	}

	@Override
	public String toString() {
		return "Usuario: [ID del Usuario = " + idUsuario + ", Nombre del Usuario = " + nombreUsuario + ", Contraseña = " + contrasenia + ", Correo Electrónico = " + correoElectronico + ", Primer incio de sesión = " + primeraVez + " Tipo de Usuario = " + tu.toString() + "]";
	}
}

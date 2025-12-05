package Final12;

public class Usuario {
	private TipoUsuario tu;
	private String nombreUsuario;
	private String contrasenia;
	private String correoElectronico;
	private boolean primeraVez;
	
	public TipoUsuario getTu() {
		return tu;
	}
	public void setTu(TipoUsuario tu) {
		this.tu = tu;
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

	public Usuario(TipoUsuario tu, String nombreUsuario, String contrasenia, String correoElectronico, boolean primeraVez) {
		this.tu = tu;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.correoElectronico = correoElectronico;
		this.primeraVez = primeraVez;
	}

	@Override
	public String toString() {
		return "Usuario: [Tipo de Usuario = " + tu.toString() + ", Nombre del Usuario = " + nombreUsuario + ", Contraseña = " + contrasenia + ", Correo Electrónico = " + correoElectronico + ", Primer incio de sesión = " + primeraVez + "]";
	}
}

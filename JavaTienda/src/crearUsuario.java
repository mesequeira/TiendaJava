public class crearUsuario {
	private String primerNombre, apellido, nombreUsuario, contrasenia, repiteContrasenia;
	archivo crearUsuario = new archivo();
	private boolean correcto = false;
	buscarUsuariosRepetidos usuarioRepetido = new buscarUsuariosRepetidos();

	public crearUsuario(String primerNombre, String apellido, String nombreUsuario, String contrasenia, String repiteContrasenia) {
		super();
		this.primerNombre = primerNombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.repiteContrasenia = repiteContrasenia;

		crearUsuario.escribirFichero(primerNombre, apellido, nombreUsuario, contrasenia);
	}

	public boolean checkearContrasenia(String data1, String data2) {
		if (data1.equals(data2))
			return true;
		else
			return false;

	}

	public String getFirstName() {
		return primerNombre;
	}

	public String getLastName() {
		return apellido;
	}

	public String getUsername() {
		return nombreUsuario;
	}

	public String getRepeatPassword() {
		return repiteContrasenia;
	}

	public String getPassword() {
		return contrasenia;
	}

	public boolean isCorrect() {
		return correcto;
	}

	public void setCorrect(boolean correct) {
		this.correcto = correct;
	}

}
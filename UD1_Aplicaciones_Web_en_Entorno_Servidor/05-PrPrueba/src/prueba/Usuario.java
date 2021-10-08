/**
 * 
 */
package prueba;

/** 
 * @author frolik
 */
public class Usuario {
	/**
	 * login - Login del usuario
	 * @uml.property  name="login"
	 */
	private String login;
	/** 
	 * clave - Clave del usuario
	 * @uml.property name="clave"
	 */
	private String clave;
	
	/**
	 * Constructor con argumentos login y clave
	 */
	public Usuario(String login, String clave){
	this.login = login;
	this.clave = clave; 
	}

			
	/**
	 *  Constructor sin argumentos
	 */
	public Usuario(){
	this.login = "Sin login";
	this.clave = "Sin clave"; 
	}

	

	/**
	 * Getter of the property <tt>login</tt>
	 * @return  Returns the login.
	 * @uml.property  name="login"
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter of the property <tt>login</tt>
	 * @param login  The login to set.
	 * @uml.property  name="login"
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/** 
	 * Getter of the property <tt>clave</tt>
	 * @return  Returns the clave.
	 * @uml.property  name="clave"
	 */
	public String getClave() {
		return clave;
	}

	/** 
	 * Setter of the property <tt>clave</tt>
	 * @param clave  The clave to set.
	 * @uml.property  name="clave"
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

}

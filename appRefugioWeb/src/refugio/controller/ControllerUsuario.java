package refugio.controller;

import javax.ejb.EJB;
import javax.persistence.Column;

import refugio.model.manager.ManagerRefugio;

public class ControllerUsuario {
	private String apellido_usuario;
	private String cedula_usuario;
	private String clave_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String telefono_usuario;
	private String tipo_usuario;
	
	@EJB
	private ManagerRefugio managerRefugio;

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public ManagerRefugio getManagerRefugio() {
		return managerRefugio;
	}

	public void setManagerRefugio(ManagerRefugio managerRefugio) {
		this.managerRefugio = managerRefugio;
	}
	
	

}

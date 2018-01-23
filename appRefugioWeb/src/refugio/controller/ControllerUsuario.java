package refugio.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import refugio.model.entities.Usuario;
import refugio.model.manager.ManagerRefugio;
import refugio.view.util.JSFUtil;

public class ControllerUsuario {
	private int id_usuario;
	private String apellido_usuario;
	private String cedula_usuario;
	private String clave_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String telefono_usuario;
	private boolean tipo_usuario;
	
	private List<Usuario> listaUsuarios;
	
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
	
	public boolean isTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(boolean tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public ManagerRefugio getManagerRefugio() {
		return managerRefugio;
	}

	public void setManagerRefugio(ManagerRefugio managerRefugio) {
		this.managerRefugio = managerRefugio;
	}
	
	public void cargarUsuario(Usuario u) {
		id_usuario = u.getIdUsuario();
		cedula_usuario = u.getCedulaUsuario();
		nombre_usuario = u.getNombreUsuario();
		apellido_usuario = u.getApellidoUsuario();
		clave_usuario = u.getClaveUsuario();
		email_usuario = u.getEmailUsuario();
		telefono_usuario = u.getTelefonoUsuario();
		tipo_usuario = u.getTipoUsuario();
		}
	
	@PostConstruct
	
	
	public void actionRegistrar() {
		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			if (validadorDeCedula(cedula_usuario)) {
				if (validarCorreo(email_usuario)) {
						System.out.println("Registrado Exitosamente " );
						managerRefugio.registrarUsuario(apellido_usuario, cedula_usuario, clave_usuario, email_usuario, nombre_usuario, telefono_usuario, tipo_usuario);
						JSFUtil.crearMensajeInfo("Registrado Exitosamente");
						listaUsuarios = managerRefugio.findAllUsuarios();
						cedula_usuario = "";
						nombre_usuario = "";
						apellido_usuario = "";
						telefono_usuario= "";
						email_usuario = "";
						tipo_usuario = true;
					} else {
						JSFUtil.crearMensajeError("Correo incorrecto");
					}
				}  else {
				JSFUtil.crearMensajeError("Cédula incorrecta");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeError(e.getMessage());
		}

	}
	
	//VALIDAR CEDULA
	public boolean validadorDeCedula(String cedula_usuario) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula_usuario.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula_usuario.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula_usuario.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula_usuario.length() - 1); i++) {
						digito = Integer.parseInt(cedula_usuario.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrió en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	} 
	//VALIDAR CORREO
	public boolean validarCorreo(String correo) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(correo);
		boolean correcto = mather.find();
		return correcto;
	}

	public void ActualizarUsuario() {
		try {

			if (validarCorreo(email_usuario)) {

				managerRefugio.actualizarUsuario(apellido_usuario, cedula_usuario, clave_usuario, email_usuario, nombre_usuario, telefono_usuario, tipo_usuario);
				JSFUtil.crearMensajeInfo("Sus datos han sido actualizados");
				listaUsuarios = managerRefugio.findAllUsuarios();

			} else {
				JSFUtil.crearMensajeError("Correo incorrecto");
			}

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeError(e.getMessage());
		}

	}
	
	
}


package refugio.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import refugio.model.entities.Adoptante;
import refugio.model.manager.ManagerRefugio;
import refugio.view.util.JSFUtil;
@ManagedBean
@SessionScoped

public class ControllerAdoptante {
	private String cedula_adoptante;
	private String nombre_adoptante;
	private String apellido_adoptante;
	private String telefono_adoptante;
	private String celular_adoptante;
	private String email_adoptante;
	private int edad_adoptante;
	private String ocupacion_adoptante;
	private String direccion_adoptante;		
	private List<Adoptante> listaAdoptantes;	
	@EJB
	private ManagerRefugio managerRefugio;	
	
	
	public String getCedula_adoptante() {
		return cedula_adoptante;
	}

	public void setCedula_adoptante(String cedula_adoptante) {
		this.cedula_adoptante = cedula_adoptante;
	}

	public String getNombre_adoptante() {
		return nombre_adoptante;
	}

	public void setNombre_adoptante(String nombre_adoptante) {
		this.nombre_adoptante = nombre_adoptante;
	}

	public String getApellido_adoptante() {
		return apellido_adoptante;
	}

	public void setApellido_adoptante(String apellido_adoptante) {
		this.apellido_adoptante = apellido_adoptante;
	}

	public String getTelefono_adoptante() {
		return telefono_adoptante;
	}

	public void setTelefono_adoptante(String telefono_adoptante) {
		this.telefono_adoptante = telefono_adoptante;
	}

	public String getCelular_adoptante() {
		return celular_adoptante;
	}

	public void setCelular_adoptante(String celular_adoptante) {
		this.celular_adoptante = celular_adoptante;
	}

	public String getEmail_adoptante() {
		return email_adoptante;
	}

	public void setEmail_adoptante(String email_adoptante) {
		this.email_adoptante = email_adoptante;
	}

	public int getEdad_adoptante() {
		return edad_adoptante;
	}

	public void setEdad_adoptante(int edad_adoptante) {
		this.edad_adoptante = edad_adoptante;
	}

	public String getOcupacion_adoptante() {
		return ocupacion_adoptante;
	}

	public void setOcupacion_adoptante(String ocupacion_adoptante) {
		this.ocupacion_adoptante = ocupacion_adoptante;
	}

	public String getDireccion_adoptante() {
		return direccion_adoptante;
	}

	public void setDireccion_adoptante(String direccion_adoptante) {
		this.direccion_adoptante = direccion_adoptante;
	}

	public List<Adoptante> getListaAdoptantes() {
		return listaAdoptantes;
	}

	public void setListaAdoptantes(List<Adoptante> listaAdoptantes) {
		this.listaAdoptantes = listaAdoptantes;
	}

	public ManagerRefugio getManagerRefugio() {
		return managerRefugio;
	}

	public void setManagerRefugio(ManagerRefugio managerRefugio) {
		this.managerRefugio = managerRefugio;
	}

	public void cargarAdoptante(Adoptante a) {		
		cedula_adoptante = a.getCedulaAdoptante();
		nombre_adoptante = a.getNombreAdoptante();
		apellido_adoptante = a.getApellidoAdoptante();
		telefono_adoptante = a.getTelefonoAdoptante();
		celular_adoptante = a.getCelularAdoptante();
		email_adoptante = a.getEmailAdoptante();
		edad_adoptante = a.getEdadAdoptante();
		ocupacion_adoptante = a.getOcupacionAdoptante();
		direccion_adoptante = a.getDireccionAdoptante();
			}
	
	@PostConstruct
	
	public void actionRegistrar() {
		try {
			if (validadorDeCedula(cedula_adoptante)) {
				if (validarCorreo(email_adoptante)) {
						System.out.println("Registrado Exitosamente " );
						managerRefugio.registrarAdoptante(cedula_adoptante, nombre_adoptante, apellido_adoptante, telefono_adoptante, celular_adoptante, email_adoptante, edad_adoptante, ocupacion_adoptante, direccion_adoptante);
						JSFUtil.crearMensajeInfo("Registrado Exitosamente");
						listaAdoptantes = managerRefugio.findAllAdoptantes();
						cedula_adoptante = "";
						nombre_adoptante = "";
						apellido_adoptante = "";
						telefono_adoptante = "";
						celular_adoptante = "";
						email_adoptante = "";
						edad_adoptante = 0;
						ocupacion_adoptante = "";
						direccion_adoptante = "";
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
	public boolean validadorDeCedula(String cedula_adoptante) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula_adoptante.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula_adoptante.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula_adoptante.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula_adoptante.length() - 1); i++) {
						digito = Integer.parseInt(cedula_adoptante.substring(i, i + 1)) * coefValCedula[i];
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
			System.out.println("Una excepción ocurrió en el proceso de validación");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La cédula ingresada es incorrecta");
		}
		return cedulaCorrecta;
	} 
	//VALIDAR CORREO
	public boolean validarCorreo(String email_adoptante) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email_adoptante);
		boolean correcto = mather.find();
		return correcto;
	}

	public void ActualizarAdoptante() {
		try {
			if (validarCorreo(email_adoptante)) {
				managerRefugio.actualizarAdoptante(cedula_adoptante, nombre_adoptante, apellido_adoptante, telefono_adoptante, celular_adoptante, email_adoptante, edad_adoptante, ocupacion_adoptante, direccion_adoptante);
				JSFUtil.crearMensajeInfo("Sus datos han sido actualizados");
				listaAdoptantes = managerRefugio.findAllAdoptantes();

			} else {
				JSFUtil.crearMensajeError("Correo incorrecto");
			}

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeError(e.getMessage());
		}

	}
	
	
}


package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the espacio_asignado database table.
 * 
 */
@Entity
@Table(name="espacio_asignado")
@NamedQuery(name="EspacioAsignado.findAll", query="SELECT e FROM EspacioAsignado e")
public class EspacioAsignado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_espacio_asignado", unique=true, nullable=false)
	private Integer idEspacioAsignado;

	@Column(name="descripcion_espacio", length=2147483647)
	private String descripcionEspacio;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="espacioAsignado")
	private List<Seguimiento> seguimientos;

	public EspacioAsignado() {
	}

	public Integer getIdEspacioAsignado() {
		return this.idEspacioAsignado;
	}

	public void setIdEspacioAsignado(Integer idEspacioAsignado) {
		this.idEspacioAsignado = idEspacioAsignado;
	}

	public String getDescripcionEspacio() {
		return this.descripcionEspacio;
	}

	public void setDescripcionEspacio(String descripcionEspacio) {
		this.descripcionEspacio = descripcionEspacio;
	}

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setEspacioAsignado(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setEspacioAsignado(null);

		return seguimiento;
	}

}
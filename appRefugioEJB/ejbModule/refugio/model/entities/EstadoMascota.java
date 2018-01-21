package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_mascota database table.
 * 
 */
@Entity
@Table(name="estado_mascota")
@NamedQuery(name="EstadoMascota.findAll", query="SELECT e FROM EstadoMascota e")
public class EstadoMascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_mascota", unique=true, nullable=false)
	private Integer idEstadoMascota;

	@Column(name="descripcion_estado", length=2147483647)
	private String descripcionEstado;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="estadoMascota")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="estadoMascota")
	private List<Seguimiento> seguimientos;

	public EstadoMascota() {
	}

	public Integer getIdEstadoMascota() {
		return this.idEstadoMascota;
	}

	public void setIdEstadoMascota(Integer idEstadoMascota) {
		this.idEstadoMascota = idEstadoMascota;
	}

	public String getDescripcionEstado() {
		return this.descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setEstadoMascota(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setEstadoMascota(null);

		return mascota;
	}

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setEstadoMascota(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setEstadoMascota(null);

		return seguimiento;
	}

}
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
	@Column(name="id_estado_mascota")
	private Integer idEstadoMascota;

	@Column(name="descripcion_estado")
	private String descripcionEstado;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="estadoMascota1")
	private List<Mascota> mascotas1;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="estadoMascota2")
	private List<Mascota> mascotas2;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="estadoMascota1")
	private List<Seguimiento> seguimientos1;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="estadoMascota2")
	private List<Seguimiento> seguimientos2;

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

	public List<Mascota> getMascotas1() {
		return this.mascotas1;
	}

	public void setMascotas1(List<Mascota> mascotas1) {
		this.mascotas1 = mascotas1;
	}

	public Mascota addMascotas1(Mascota mascotas1) {
		getMascotas1().add(mascotas1);
		mascotas1.setEstadoMascota1(this);

		return mascotas1;
	}

	public Mascota removeMascotas1(Mascota mascotas1) {
		getMascotas1().remove(mascotas1);
		mascotas1.setEstadoMascota1(null);

		return mascotas1;
	}

	public List<Mascota> getMascotas2() {
		return this.mascotas2;
	}

	public void setMascotas2(List<Mascota> mascotas2) {
		this.mascotas2 = mascotas2;
	}

	public Mascota addMascotas2(Mascota mascotas2) {
		getMascotas2().add(mascotas2);
		mascotas2.setEstadoMascota2(this);

		return mascotas2;
	}

	public Mascota removeMascotas2(Mascota mascotas2) {
		getMascotas2().remove(mascotas2);
		mascotas2.setEstadoMascota2(null);

		return mascotas2;
	}

	public List<Seguimiento> getSeguimientos1() {
		return this.seguimientos1;
	}

	public void setSeguimientos1(List<Seguimiento> seguimientos1) {
		this.seguimientos1 = seguimientos1;
	}

	public Seguimiento addSeguimientos1(Seguimiento seguimientos1) {
		getSeguimientos1().add(seguimientos1);
		seguimientos1.setEstadoMascota1(this);

		return seguimientos1;
	}

	public Seguimiento removeSeguimientos1(Seguimiento seguimientos1) {
		getSeguimientos1().remove(seguimientos1);
		seguimientos1.setEstadoMascota1(null);

		return seguimientos1;
	}

	public List<Seguimiento> getSeguimientos2() {
		return this.seguimientos2;
	}

	public void setSeguimientos2(List<Seguimiento> seguimientos2) {
		this.seguimientos2 = seguimientos2;
	}

	public Seguimiento addSeguimientos2(Seguimiento seguimientos2) {
		getSeguimientos2().add(seguimientos2);
		seguimientos2.setEstadoMascota2(this);

		return seguimientos2;
	}

	public Seguimiento removeSeguimientos2(Seguimiento seguimientos2) {
		getSeguimientos2().remove(seguimientos2);
		seguimientos2.setEstadoMascota2(null);

		return seguimientos2;
	}

}
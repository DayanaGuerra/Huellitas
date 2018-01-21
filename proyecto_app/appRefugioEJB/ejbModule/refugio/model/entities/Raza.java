package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the raza database table.
 * 
 */
@Entity
@Table(name="raza")
@NamedQuery(name="Raza.findAll", query="SELECT r FROM Raza r")
public class Raza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_raza", unique=true, nullable=false)
	private Integer idRaza;

	@Column(name="tipo_animal", length=2147483647)
	private String tipoAnimal;

	@Column(name="tipo_raza", nullable=false, length=2147483647)
	private String tipoRaza;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="raza")
	private List<Mascota> mascotas;

	public Raza() {
	}

	public Integer getIdRaza() {
		return this.idRaza;
	}

	public void setIdRaza(Integer idRaza) {
		this.idRaza = idRaza;
	}

	public String getTipoAnimal() {
		return this.tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getTipoRaza() {
		return this.tipoRaza;
	}

	public void setTipoRaza(String tipoRaza) {
		this.tipoRaza = tipoRaza;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setRaza(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setRaza(null);

		return mascota;
	}

}
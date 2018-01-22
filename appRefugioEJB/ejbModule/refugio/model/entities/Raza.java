package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the raza database table.
 * 
 */
@Entity
@NamedQuery(name="Raza.findAll", query="SELECT r FROM Raza r")
public class Raza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_raza")
	private Integer idRaza;

	@Column(name="tipo_animal")
	private String tipoAnimal;

	@Column(name="tipo_raza")
	private String tipoRaza;

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

}
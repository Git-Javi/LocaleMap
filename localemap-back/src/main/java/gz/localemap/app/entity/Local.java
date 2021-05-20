package gz.localemap.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "local")
public class Local {
	
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "coordenadas")
	private String coordenadas;	
}

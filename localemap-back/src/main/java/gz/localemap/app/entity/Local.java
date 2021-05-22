package gz.localemap.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "local")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

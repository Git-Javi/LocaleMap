package gz.localemap.app.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalDto {

	@NotEmpty
	private String nombre;
	@NotEmpty
	private String coordenadas;
}

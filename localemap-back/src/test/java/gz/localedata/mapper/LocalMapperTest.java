package gz.localedata.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gz.localemap.app.Application;
import gz.localemap.app.dto.LocalDto;
import gz.localemap.app.entity.Local;
import gz.localemap.app.mapper.LocalMapper;

// @RunWith(SpringRunner.class) Proporciona un puente entre las funciones de prueba de Spring Boot y JUnit.
// Siempre que utilicemos alguna de las funciones de prueba de Spring Boot en nuestras pruebas de JUnit,se requerirá esta anotación.
@RunWith(SpringRunner.class)
//@SpringBootTest Le dice al test que cargue todo el Contexto de Spring (beans) cada vez que se ejecute esta prueba.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@EnableAutoConfiguration 
public class LocalMapperTest {

	
	@Autowired
	LocalMapper localMapper;

	@Test
	public void comprobarCamposConversionLocalToLocalDtoDevuelvenValor() {
		Local local = new Local(1,"LocalTest","CategoriaTest","{ \"lat\": 00.000000000, \"lng\": 0.0000000 })");
		LocalDto localDto = localMapper.toDto(local);
		assertNotNull("El nombre SI apunta a null", localDto.getNombre());
		assertNotNull("El campo coordendas SI apunta a null", localDto.getCoordenadas());
	}
	
	@Test
	public void comprobarCamposConversionLocalToLocalDtoDevuelvenMismoValorQueReciben() {
		Local local = new Local(1,"LocalTest","CategoriaTest","{ \"lat\": 00.000000000, \"lng\": 0.0000000 })");
		LocalDto localDto = localMapper.toDto(local);
		assertEquals("El nombre NO es igual en ambos objetos", localDto.getNombre(),local.getNombre());
		assertEquals("El nombre NO es igual en ambos objetos", localDto.getCoordenadas(),local.getCoordenadas());
	}
}




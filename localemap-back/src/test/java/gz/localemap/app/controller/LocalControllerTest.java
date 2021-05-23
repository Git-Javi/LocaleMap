package gz.localemap.app.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import gz.localemap.app.dto.LocalDto;
import gz.localemap.app.service.LocalService;

@RunWith(SpringRunner.class) // Proporciona soporte para cargar un Spring ApplicationContext y tener beans @Autowired en la instancia de prueba (JUnit).
@WebMvcTest(LocalController.class) // Prueba de Spring MVC que se enfoca solo en los componentes de Spring MVC (P.E: Controllers)
public class LocalControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private LocalService localService;
	
	@Test
	public void exampleTest() throws Exception {
		LocalDto localDto = new LocalDto("La Pelicano","{ \"lat\": 43.36838796543832, \"lng\": -8.399788101905386 }");
		List<LocalDto> listaLocalesTest = new ArrayList<>();
		listaLocalesTest.add(localDto);
	    when(localService.getAllLocalByCategoria("Discotecas")).thenReturn(listaLocalesTest);
	     
	    final String expectedResponseContent = objectMapper.writeValueAsString(listaLocalesTest);
	    
        this.mockMvc.perform(get("/locales/discotecas"))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedResponseContent));
    
        verify(localService).getAllLocalByCategoria("Discotecas"); // verify that the repository was called correctly
    }
	
}





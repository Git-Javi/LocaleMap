package gz.localemap.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gz.localemap.app.dto.LocalDto;
import gz.localemap.app.service.LocalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@Slf4j
public class LocalController {
	
	@Autowired
	private LocalService localService;
	// Configuración local de CORS, que es un mecanismo implementado por los navegadores 
	// que por razones de seguridad bloquean las peticiones AJAX a recursos fuera del origen actual. 
	// Utiliza cabeceras HTTP adicionales para permitir a un cliente (user agent) 
	// acceder a recursos desde un origen (servidor) diferente al sitio (servidor actual) 
	// Como la página de index.html se está abriendo con el sistema de ficheros y no desde un servidor el origen es "null"
	@CrossOrigin(origins = "null") 
	@GetMapping(value = "/locales/{categoria}")
	public List<LocalDto> getAllLocalByCategoria(@PathVariable("categoria") @Valid @NotEmpty String categoria) {	
		log.info("LocalController :: categoria ===> "+categoria);
		List <LocalDto> listaLocalesDto = localService.getAllLocalByCategoria(categoria.trim());
		listaLocalesDto.stream().forEach(localDto->{log.info("LocalController :: LocalesDto ===> "+localDto);});
		return listaLocalesDto;
	}

}
package gz.localemap.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

	@GetMapping(value = "/locales/{categoria}")
	public List<LocalDto> getAllLocalByCategoria(@PathVariable("categoria") @Valid @NotEmpty String categoria) {	
		log.info("LocalController :: categoria ===> "+categoria);
		List <LocalDto> listaLocalesDto = localService.getAllLocalByCategoria(categoria.trim());
		listaLocalesDto.stream().forEach(localDto->{log.info("LocalController :: LocalesDto ===> "+localDto);});
		return listaLocalesDto;
	}

}
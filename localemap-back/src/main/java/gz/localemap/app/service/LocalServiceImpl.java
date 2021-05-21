package gz.localemap.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import gz.localemap.app.dto.LocalDto;
import gz.localemap.app.entity.Local;
import gz.localemap.app.mapper.LocalMapper;
import gz.localemap.app.repository.LocalRepository;
import gz.localemap.app.repository.LocalSpecifications;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
public class LocalServiceImpl implements LocalService {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private LocalMapper localMapper;

	@Override
	public List<LocalDto> getAllLocalByCategoria(@Valid @NotEmpty String categoria) {
		log.info("LocalServiceImpl :: categoria ===> " + categoria);
		List<Local> listaLocales = localRepository.findAll(LocalSpecifications.categoriaLike(categoria));
		List<LocalDto> listaLocalesDto = new ArrayList<>();
		listaLocales.stream().forEach((local) -> {
			listaLocalesDto.add(localMapper.toDto(local));
		});
		listaLocalesDto.stream().forEach(LocalDto -> {
			log.info("LocalServiceImpl :: LocalesDto ===> " + LocalDto);
		});
		return listaLocalesDto;
	}

}

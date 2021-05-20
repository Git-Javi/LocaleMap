package gz.localemap.app.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import gz.localemap.app.entity.Local;
import gz.localemap.app.repository.LocalRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
public class LocalServiceImpl implements LocalService {
	
	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public List<Local> getAllLocalByCategoria(@Valid @NotEmpty String categoria) {
		log.info("LocalServiceImpl :: categoria ===> "+categoria);
		List<Local> locales = localRepository.getAllLocalByCategoria(categoria);
		locales.stream().forEach(local->{log.info("LocalServiceImpl :: Locales ===> "+local);});
		return locales;
	}

}

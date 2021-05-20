package gz.localemap.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gz.localemap.app.entity.Local;
import gz.localemap.app.repository.LocalRepository;

@Service
public class LocalServiceImpl implements LocalService {
	
	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public List<Local> getAllLocalByCategoria(String categoria) {
		List<Local> locales = localRepository.getAllLocalByCategoria(categoria);
		return locales;
	}

}

package gz.localemap.app.service;

import java.util.List;

import gz.localemap.app.dto.LocalDto;

public interface LocalService {
	
	public List<LocalDto> getAllLocalByCategoria(String categoria);

}

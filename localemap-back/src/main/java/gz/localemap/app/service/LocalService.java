package gz.localemap.app.service;

import java.util.List;

import gz.localemap.app.entity.Local;

public interface LocalService {
	
	public List<Local> getAllLocalByCategoria(String categoria);

}

package gz.localemap.app.repository;

import java.util.List;

import gz.localemap.app.entity.Local;

public interface LocalRepositoryCustom {
	
	public List<Local> readALLByCat(String categoria);

}

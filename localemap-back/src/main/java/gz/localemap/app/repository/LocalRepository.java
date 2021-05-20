package gz.localemap.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gz.localemap.app.entity.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
	
	//@Query("SELECT lo FROM local as lo WHERE lo.categoria=?1")
	@Query(value = "SELECT * FROM local WHERE categoria=?1", nativeQuery = true)
	public List<Local> getAllLocalByCategoria(String categoria);

}

package gz.localemap.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gz.localemap.app.entity.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>, JpaSpecificationExecutor<Local> {
	/*@Query(value = "SELECT * FROM local WHERE categoria=?1", nativeQuery = true)
	public List<Local> getAllLocalByCategoria(String categoria);*/
}

package gz.localemap.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import gz.localemap.app.entity.Local;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class LocalRepositoryImpl implements LocalRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Local> readALLByCat(String categoria) {
		Query query = entityManager.createNativeQuery("SELECT l.* FROM locales_map.local as l " +
			    "WHERE l.categoria LIKE ?", Local.class);
			query.setParameter(1, categoria + "%");
        return query.getResultList();
	}

}

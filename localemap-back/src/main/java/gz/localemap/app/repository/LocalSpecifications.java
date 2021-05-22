package gz.localemap.app.repository;

import org.springframework.data.jpa.domain.Specification;

import gz.localemap.app.entity.Local;

public class LocalSpecifications {

	// Usando Specifications podemos construir predicados atómicos y combinar esos predicados para construir consultas dinámicas complejas.
	public static Specification<Local> categoriaLike(String categoria) {
		if (categoria == null) {
			return null;
		}
		// Cuando construimos una consulta Criteria, debemos construir y administrar objetos Root, CriteraQuery y CriteriaBuilder por nosotros mismos:
		// "root, query, cb" son los parámetros que necesitamos para crear el predicado que usará la especificación
		// root: El punto (Entidad) de partida de la consulta
		// cb: CriteriaBuilder -> crea el objeto de configuración
		return (root, query, cb) -> {
			return cb.like(root.get("categoria"), "%" + categoria + "%");
		};
	}
}

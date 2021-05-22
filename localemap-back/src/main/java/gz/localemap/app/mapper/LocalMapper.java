package gz.localemap.app.mapper;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.mapstruct.Mapper;
import org.springframework.validation.annotation.Validated;

import gz.localemap.app.dto.LocalDto;
import gz.localemap.app.entity.Local;

@Validated
@Mapper(componentModel = "spring")
public interface LocalMapper {

	public LocalDto toDto(@Valid @NotNull Local local);
	
}

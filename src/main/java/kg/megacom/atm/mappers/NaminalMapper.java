package kg.megacom.atm.mappers;

import kg.megacom.atm.mappers.base.CrudMapper;
import kg.megacom.atm.models.Naminal;
import kg.megacom.atm.models.dto.NaminalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface NaminalMapper extends CrudMapper<Naminal, NaminalDto> {
    NaminalMapper INSTANCE = Mappers.getMapper(NaminalMapper.class);

    @Override
    @Mapping(target = "count", defaultValue = "1")
    HashSet<NaminalDto> toDtos(List<Naminal> naminals);
}

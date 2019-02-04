package id.co.mandiri.dto;

import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import id.co.mandiri.entity.CapacityUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CapacityUnitMapperRequestNew extends ObjectMapper<CapacityUnit, CapacityUnitDTO.CapacityUnitRequestNewDTO> {

    CapacityUnitMapperRequestNew converter = Mappers.getMapper(CapacityUnitMapperRequestNew.class);

}

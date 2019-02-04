package id.co.mandiri.dto;

import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import id.co.mandiri.entity.CapacityUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CapacityUnitMapperRequestUpdate extends ObjectMapper<CapacityUnit, CapacityUnitDTO.CapacityUnitRequestUpdateDTO> {

    CapacityUnitMapperRequestUpdate converter = Mappers.getMapper(CapacityUnitMapperRequestUpdate.class);
}

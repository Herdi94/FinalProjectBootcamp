package id.co.mandiri.dto;

import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import id.co.mandiri.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapperRequestNew extends ObjectMapper<Inventory, InventoryDTO.InventoryRequestNewDTO> {

    InventoryMapperRequestNew converter = Mappers.getMapper(InventoryMapperRequestNew.class);

}

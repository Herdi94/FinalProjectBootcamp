package id.co.mandiri.dto;

import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import id.co.mandiri.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapperRequestUpdate extends ObjectMapper<Inventory, InventoryDTO.InventoryRequestUpdateDTO> {

    InventoryMapperRequestUpdate converter = Mappers.getMapper(InventoryMapperRequestUpdate.class);
}

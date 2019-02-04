package id.co.mandiri.dto;

import com.maryanto.dimas.plugins.web.commons.mappers.ObjectMapper;
import id.co.mandiri.entity.CategoryBrand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryBrandMapperRequestUpdate extends ObjectMapper<CategoryBrand, CategoryBrandDTO.CategoryBrandRequestUpdateDTO> {

    CategoryBrandMapperRequestUpdate converter = Mappers.getMapper(CategoryBrandMapperRequestUpdate.class);
}

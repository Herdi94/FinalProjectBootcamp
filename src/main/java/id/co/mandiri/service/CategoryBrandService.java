package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.CategoryBrandDao;
import id.co.mandiri.entity.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryBrandService implements ServiceCrudDataTablesPattern<CategoryBrand, String> {

    @Autowired
    private CategoryBrandDao categoryDao;

    @Override
    public CategoryBrand findId(String s) {
        return categoryDao.findId(s);
    }

    @Override
    public List<CategoryBrand> findAll() {
        return null;
    }

    @Override
    @Transactional
    public CategoryBrand save(CategoryBrand value) {
        return categoryDao.save(value);
    }

    @Override
    @Transactional
    public CategoryBrand update(CategoryBrand value) {
        return categoryDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(CategoryBrand value) {
        return categoryDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return categoryDao.removeById(s);
    }

    @Override
    public DataTablesResponse<CategoryBrand> datatables(DataTablesRequest<CategoryBrand> params) {
        List<CategoryBrand> values = categoryDao.datatables(params);
        Long rowCount = categoryDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

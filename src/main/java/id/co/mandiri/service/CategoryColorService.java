package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.CategoryColorDao;
import id.co.mandiri.dao.CategoryDeviceDao;
import id.co.mandiri.entity.CategoryColor;
import id.co.mandiri.entity.CategoryDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryColorService implements ServiceCrudDataTablesPattern<CategoryColor, String> {

    @Autowired
    private CategoryColorDao categoryDao;

    @Override
    public CategoryColor findId(String s) {
        return categoryDao.findId(s);
    }

    @Override
    public List<CategoryColor> findAll() {
        return null;
    }

    @Override
    @Transactional
    public CategoryColor save(CategoryColor value) {
        return categoryDao.save(value);
    }

    @Override
    @Transactional
    public CategoryColor update(CategoryColor value) {
        return categoryDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(CategoryColor value) {
        return categoryDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return categoryDao.removeById(s);
    }

    @Override
    public DataTablesResponse<CategoryColor> datatables(DataTablesRequest<CategoryColor> params) {
        List<CategoryColor> values = categoryDao.datatables(params);
        Long rowCount = categoryDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

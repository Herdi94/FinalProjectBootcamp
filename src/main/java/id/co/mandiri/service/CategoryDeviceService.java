package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.CategoryDeviceDao;
import id.co.mandiri.entity.CategoryDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryDeviceService implements ServiceCrudDataTablesPattern<CategoryDevice, String> {

    @Autowired
    private CategoryDeviceDao CategoryDeviceDao;

    @Override
    public CategoryDevice findId(String s) {
        return CategoryDeviceDao.findId(s);
    }

    @Override
    public List<CategoryDevice> findAll() {
        return null;
    }

    @Override
    @Transactional
    public CategoryDevice save(CategoryDevice value) {
        return CategoryDeviceDao.save(value);
    }

    @Override
    @Transactional
    public CategoryDevice update(CategoryDevice value) {
        return CategoryDeviceDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(CategoryDevice value) {
        return CategoryDeviceDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return CategoryDeviceDao.removeById(s);
    }

    @Override
    public DataTablesResponse<CategoryDevice> datatables(DataTablesRequest<CategoryDevice> params) {
        List<CategoryDevice> values = CategoryDeviceDao.datatables(params);
        Long rowCount = CategoryDeviceDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

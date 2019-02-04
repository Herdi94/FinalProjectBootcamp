package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.CapacityUnitDao;
import id.co.mandiri.entity.CapacityUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CapacityUnitService implements ServiceCrudDataTablesPattern<CapacityUnit, String> {

    @Autowired
    private CapacityUnitDao categoryDao;

    @Override
    public CapacityUnit findId(String s) {
        return categoryDao.findId(s);
    }

    @Override
    public List<CapacityUnit> findAll() {
        return null;
    }

    @Override
    @Transactional
    public CapacityUnit save(CapacityUnit value) {
        return categoryDao.save(value);
    }

    @Override
    @Transactional
    public CapacityUnit update(CapacityUnit value) {
        return categoryDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(CapacityUnit value) {
        return categoryDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return categoryDao.removeById(s);
    }

    @Override
    public DataTablesResponse<CapacityUnit> datatables(DataTablesRequest<CapacityUnit> params) {
        List<CapacityUnit> values = categoryDao.datatables(params);
        Long rowCount = categoryDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

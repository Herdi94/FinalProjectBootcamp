package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.InventoryDao;
import id.co.mandiri.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class InventoryService implements ServiceCrudDataTablesPattern<Inventory, String> {

    @Autowired
    private InventoryDao InventoryDao;

    @Override
    public Inventory findId(String s) {
        return InventoryDao.findId(s);
    }

    @Override
    public List<Inventory> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Inventory save(Inventory value) {
        return InventoryDao.save(value);
    }

    @Override
    @Transactional
    public Inventory update(Inventory value) {
        return InventoryDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(Inventory value) {
        return InventoryDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return InventoryDao.removeById(s);
    }

    @Override
    public DataTablesResponse<Inventory> datatables(DataTablesRequest<Inventory> params) {
        List<Inventory> values = InventoryDao.datatables(params);
        Long rowCount = InventoryDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

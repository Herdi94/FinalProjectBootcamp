package id.co.mandiri.service;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesResponse;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.service.ServiceCrudDataTablesPattern;
import id.co.mandiri.dao.LoanStatusDao;
import id.co.mandiri.entity.LoanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LoanStatusService implements ServiceCrudDataTablesPattern<LoanStatus, String> {

    @Autowired
    private LoanStatusDao loanDao;

    @Override
    public LoanStatus findId(String s) {
        return loanDao.findId(s);
    }

    @Override
    public List<LoanStatus> findAll() {
        return null;
    }

    @Override
    @Transactional
    public LoanStatus save(LoanStatus value) {
        return loanDao.save(value);
    }

    @Override
    @Transactional
    public LoanStatus update(LoanStatus value) {
        return loanDao.update(value);
    }

    @Override
    @Transactional
    public boolean remove(LoanStatus value) {
        return loanDao.remove(value);
    }

    @Override
    @Transactional
    public boolean removeById(String s) {
        return loanDao.removeById(s);
    }

    @Override
    public DataTablesResponse<LoanStatus> datatables(DataTablesRequest<LoanStatus> params) {
        List<LoanStatus> values = loanDao.datatables(params);
        Long rowCount = loanDao.datatables(params.getValue());
        return new DataTablesResponse<>(values, params.getDraw(), rowCount, rowCount);
    }
}

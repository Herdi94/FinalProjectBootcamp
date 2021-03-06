package id.co.mandiri.dao;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.dao.DaoCrudDataTablesPattern;


import id.co.mandiri.entity.DeviceCondition;
import id.co.mandiri.repository.DeviceConditionRepository;
import id.co.mandiri.utils.QueryComparator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceConditionDao implements DaoCrudDataTablesPattern<DeviceCondition, String> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private DeviceConditionRepository DeviceConditionRepository;

    @Override
    public DeviceCondition findId(String s) {
        return DeviceConditionRepository.findOne(s);
    }

    @Override
    @Deprecated
    public List<DeviceCondition> findAll() {
        return null;
    }

    @Override
    public DeviceCondition save(DeviceCondition deviceCondition) {
        return DeviceConditionRepository.save(deviceCondition);
    }

    @Override
    public DeviceCondition update(DeviceCondition deviceCondition) {
        return DeviceConditionRepository.save(deviceCondition);
    }

    @Override
    public boolean remove(DeviceCondition deviceCondition) {
        DeviceConditionRepository.delete(deviceCondition);
        return true;
    }

    @Override
    public boolean removeById(String s) {
        DeviceConditionRepository.delete(s);
        return true;
    }

    @Override
    public List<DeviceCondition> datatables(DataTablesRequest<DeviceCondition> params) {
        String baseQuery = "select id, name, description\n" +
                "from device_condition\n" +
                "where 1 = 1 ";

        DeviceCondition param = params.getValue();

        ConditionQueryCompare compare = new ConditionQueryCompare(baseQuery);
        StringBuilder query = compare.getQuery(param);
        MapSqlParameterSource values = compare.getParameters();

        switch (params.getColOrder().intValue()) {
            case 0:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id asc ");
                else
                    query.append(" order by id desc ");
                break;
            case 1:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by name asc ");
                else
                    query.append(" order by name desc ");
                break;
            case 2:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by description asc ");
                else
                    query.append(" order by description desc ");
                break;
            default:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id asc ");
                else
                    query.append(" order by id desc ");
                break;
        }

        query.append("limit :limit offset :offset");
        values.addValue("offset", params.getStart());
        values.addValue("limit", params.getLength());

        return this.jdbcTemplate.query(query.toString(), values, (resultSet, i) ->
                new DeviceCondition(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                ));
    }

    @Override
    public Long datatables(DeviceCondition param) {
        String baseQuery = "select count(id) as rows \n" +
                "from device_condition\n" +
                "where 1 = 1 ";

        ConditionQueryCompare compare = new ConditionQueryCompare(baseQuery);
        StringBuilder query = compare.getQuery(param);
        MapSqlParameterSource values = compare.getParameters();

        return this.jdbcTemplate.queryForObject(
                query.toString(),
                values,
                (resultSet, i) -> resultSet.getLong("rows")
        );

    }

    private class ConditionQueryCompare implements QueryComparator<DeviceCondition> {

        private MapSqlParameterSource parameterSource;
        private StringBuilder query;

        ConditionQueryCompare(String query) {
            this.parameterSource = new MapSqlParameterSource();
            this.query = new StringBuilder(query);
        }


        @Override
        public StringBuilder getQuery(DeviceCondition param) {
            if (StringUtils.isNoneBlank(param.getId())) {
                query.append(" and lower(id) like :id ");
                parameterSource.addValue("id",
                        new StringBuilder("%")
                                .append(param.getId().toLowerCase())
                                .append("%")
                                .toString());
            }

            if (StringUtils.isNoneBlank(param.getName())) {
                query.append(" and lower(name) like :name ");
                parameterSource.addValue("name", new StringBuilder("%")
                        .append(param.getName().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getDescription())) {
                query.append(" and lower(description) like :description ");
                parameterSource.addValue("description", new StringBuilder("%")
                        .append(param.getDescription().toLowerCase())
                        .append("%")
                        .toString());
            }
            return query;
        }

        @Override
        public MapSqlParameterSource getParameters() {
            return this.parameterSource;
        }
    }
}

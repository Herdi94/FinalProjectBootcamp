package id.co.mandiri.dao;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.dao.DaoCrudDataTablesPattern;
import id.co.mandiri.entity.Inventory;
import id.co.mandiri.repository.InventoryRepository;
import id.co.mandiri.utils.QueryComparator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDao implements DaoCrudDataTablesPattern<Inventory, String> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private InventoryRepository InventoryRepository;

    @Override
    public Inventory findId(String s) {
        return InventoryRepository.findOne(s);
    }

    @Override
    @Deprecated
    public List<Inventory> findAll() {
        return null;
    }

    @Override
    public Inventory save(Inventory Inventory) {
        return InventoryRepository.save(Inventory);
    }

    @Override
    public Inventory update(Inventory Inventory) {
        return InventoryRepository.save(Inventory);
    }

    @Override
    public boolean remove(Inventory Inventory) {
        InventoryRepository.delete(Inventory);
        return true;
    }

    @Override
    public boolean removeById(String s) {
        InventoryRepository.delete(s);
        return true;
    }

    @Override
    public List<Inventory> datatables(DataTablesRequest<Inventory> params) {
        String baseQuery = "select i.id, id_device, id_device_category, id_device_condition, id_capacity_unit" +
                "id_brand_category, id_color, id_loan \n" +
                "from Inventory i join device_category d on d.id = i.id_device join device_condition dc on dc.id = i.id_device_condition join capacity_unit ca on ca.id = i.id_capacity_unit join brand_category b on b.id = i.id_brand_category join color_category cc on cc.id = i.id_color" +
                "join loan_status l on l.id = i.id_loan \n" +
                "where 1 = 1 ";

        Inventory param = params.getValue();

        InventoryQueryCompare compare = new InventoryQueryCompare(baseQuery);
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
                    query.append(" order by id_device asc ");
                else
                    query.append(" order by id_device desc ");
                break;

            case 2:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_device_category asc ");
                else
                    query.append(" order by id_device_category desc ");
                break;

            case 3:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_device_condition asc ");
                else
                    query.append(" order by id_device_condition desc ");
                break;

            case 4:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_capacity_unit asc ");
                else
                    query.append(" order by id_capacity_unit desc ");
                break;

            case 5:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_brand_category asc ");
                else
                    query.append(" order by id_brand_category desc ");
                break;

            case 6:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_color asc ");
                else
                    query.append(" order by id_color desc ");
                break;

            case 7:
                if (StringUtils.equalsIgnoreCase(params.getColDir(), "asc"))
                    query.append(" order by id_loan asc ");
                else
                    query.append(" order by id_loan desc ");
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
                new Inventory(
                        resultSet.getString("id")
                ));
    }

    @Override
    public Long datatables(Inventory param) {
        String baseQuery = "select count(id) as rows \n" +
                "from Inventory\n" +
                "where 1 = 1 ";

        InventoryQueryCompare compare = new InventoryQueryCompare(baseQuery);
        StringBuilder query = compare.getQuery(param);
        MapSqlParameterSource values = compare.getParameters();

        return this.jdbcTemplate.queryForObject(
                query.toString(),
                values,
                (resultSet, i) -> resultSet.getLong("rows")
        );

    }

    private class InventoryQueryCompare implements QueryComparator<Inventory> {

        private MapSqlParameterSource parameterSource;
        private StringBuilder query;

        InventoryQueryCompare(String query) {
            this.parameterSource = new MapSqlParameterSource();
            this.query = new StringBuilder(query);
        }


        @Override
        public StringBuilder getQuery(Inventory param) {
            if (StringUtils.isNoneBlank(param.getId())) {
                query.append(" and lower(id) like :id ");
                parameterSource.addValue("id",
                        new StringBuilder("%")
                                .append(param.getId().toLowerCase())
                                .append("%")
                                .toString());
            }

            /*if (StringUtils.isNoneBlank(param.getDevice())) {
                query.append(" and lower(id_device) like :id_device ");
                parameterSource.addValue("id_device", new StringBuilder("%")
                        .append(param.getDevice().toLowerCase())
                        .append("%")
                        .toString());
            }*/

            /*if (StringUtils.isNoneBlank(param.getId_device_category())) {
                query.append(" and lower(id_device_category) like :id_device_category");
                parameterSource.addValue("id_device_category", new StringBuilder("%")
                        .append(param.getId_device_category().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getId_device_category())) {
                query.append(" and lower(id_device_condition) like :id_device_condition");
                parameterSource.addValue("id_device_condition", new StringBuilder("%")
                        .append(param.getId_device_condition().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getId_capacity_unit())) {
                query.append(" and lower(id_capacity_unit) like :id_capacity_unit");
                parameterSource.addValue("id_capacity_unit", new StringBuilder("%")
                        .append(param.getId_capacity_unit().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getId_brand_category())) {
                query.append(" and lower(id_brand_category) like :id_brand_category");
                parameterSource.addValue("id_brand_category", new StringBuilder("%")
                        .append(param.getId_brand_category().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getId_color())) {
                query.append(" and lower(id_color) like :id_color");
                parameterSource.addValue("id_color", new StringBuilder("%")
                        .append(param.getId_color().toLowerCase())
                        .append("%")
                        .toString());
            }

            if (StringUtils.isNoneBlank(param.getId_loan())) {
                query.append(" and lower(id_loan) like :id_loan");
                parameterSource.addValue("id_loan", new StringBuilder("%")
                        .append(param.getId_loan().toLowerCase())
                        .append("%")
                        .toString());
            }*/


            return query;
        }

        @Override
        public MapSqlParameterSource getParameters() {
            return this.parameterSource;
        }
    }
}

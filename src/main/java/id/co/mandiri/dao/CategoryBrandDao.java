package id.co.mandiri.dao;

import com.maryanto.dimas.plugins.web.commons.ui.datatables.DataTablesRequest;
import com.maryanto.dimas.plugins.web.commons.ui.datatables.dao.DaoCrudDataTablesPattern;
import id.co.mandiri.entity.CategoryBrand;
import id.co.mandiri.repository.CategoryBrandRepository;
import id.co.mandiri.utils.QueryComparator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryBrandDao implements DaoCrudDataTablesPattern<CategoryBrand, String> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private CategoryBrandRepository categoryBrandRepository;

    @Override
    public CategoryBrand findId(String s) {
        return categoryBrandRepository.findOne(s);
    }

    @Override
    public List<CategoryBrand> findAll() {
        return null;
    }

    @Override
    public CategoryBrand save(CategoryBrand categoryBrand) {
        return categoryBrandRepository.save(categoryBrand);
    }

    @Override
    public CategoryBrand update(CategoryBrand categoryBrand) {
        return categoryBrandRepository.save(categoryBrand);
    }

    @Override
    public boolean remove(CategoryBrand categoryBrand) {
        categoryBrandRepository.save(categoryBrand);
        return true;
    }

    @Override
    public boolean removeById(String s) {
        categoryBrandRepository.delete(s);
        return true;
    }


    @Override
    public List<CategoryBrand> datatables(DataTablesRequest<CategoryBrand> params) {
        String baseQuery = "select id, name, code ,description\n" +
                "from brand_category\n" +
                "where 1 = 1 ";

        CategoryBrand param = params.getValue();

        CategoryBrandQueryCompare compare = new CategoryBrandQueryCompare(baseQuery);
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
                new CategoryBrand(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code"),
                        resultSet.getString("description")
                ));
    }



    private class CategoryBrandQueryCompare implements QueryComparator<CategoryBrand> {

        private MapSqlParameterSource parameterSource;
        private StringBuilder query;

        CategoryBrandQueryCompare(String query) {
            this.parameterSource = new MapSqlParameterSource();
            this.query = new StringBuilder(query);
        }


        @Override
        public StringBuilder getQuery(CategoryBrand param) {
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

            if (StringUtils.isNoneBlank(param.getName())) {
                query.append(" and lower(code) like :code ");
                parameterSource.addValue("code", new StringBuilder("%")
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




    @Override
    public Long datatables(CategoryBrand param) {
        String baseQuery = "select count(id) as rows \n" +
                "from brand_category\n" +
                "where 1 = 1 ";

        CategoryBrandQueryCompare compare = new CategoryBrandQueryCompare(baseQuery);
        StringBuilder query = compare.getQuery(param);
        MapSqlParameterSource values = compare.getParameters();

        return this.jdbcTemplate.queryForObject(
                query.toString(),
                values,
                (resultSet, i) -> resultSet.getLong("rows")
        );
    }
}

package com.example.batch1.batch.job.api;

import com.example.batch1.batch.domain.ProductDTO;
import com.example.batch1.batch.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryGenerator {
    public static ProductDTO[] getProductList(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ProductDTO> productList = jdbcTemplate.query("select type from product group by type", new ProductRowMapper() {
            @Override
            public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ProductDTO.builder().type(rs.getString("type")).build();
            }
        });
        return productList.toArray(new ProductDTO[]{});
    }

    public static Map<String, Object> getParameterForQuery(String parameter, String value) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(parameter, value);
        return parameters;
    }
}

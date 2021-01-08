package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.vo.ColumnInfo;

@Service
public class GeneratorService {

	@PersistenceContext
    private EntityManager em;

    public List<ColumnInfo> getColumns(String tableName) {
        StringBuilder sql = new StringBuilder("select column_name, is_nullable, data_type, column_comment, column_key, extra from information_schema.columns where ");
        if(!ObjectUtils.isEmpty(tableName)){
            sql.append("table_name = '").append(tableName).append("' ");
        }
        sql.append("and table_schema = (select database()) order by ordinal_position");
        Query query = em.createNativeQuery(sql.toString());
        List result = query.getResultList();
        List<ColumnInfo> columnInfos = new ArrayList<>();
        for (Object o : result) {
            Object[] obj = (Object[])o;
            columnInfos.add(new ColumnInfo((String)obj[0],obj[1],(String)obj[2],(String)obj[3],obj[4],obj[5]));
        }
        return columnInfos;
    }
}

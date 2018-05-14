package com.shiyue.bm.core.datetime;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.Date;

/**
 * Author: huangyue03@baidu.com.
 * Data: 2016/10/31.
 */
public class IopDateHandler extends BaseTypeHandler<IopDate> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, IopDate date, JdbcType
            jdbcType) throws SQLException {
        if (date == null) {
            preparedStatement.setTimestamp(i, new Timestamp(new Date().getTime()));
            return;
        }
        preparedStatement.setTimestamp(i, new Timestamp(date.getTime()));
    }

    @Override
    public IopDate getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (resultSet.getDate(s) == null) {
            return null;
        }
        IopDate date = new IopDate(resultSet.getDate(s));
        return date;
    }

    @Override
    public IopDate getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (resultSet.getDate(i) == null) {
            return null;
        }
        IopDate date = new IopDate(resultSet.getDate(i));
        return date;
    }

    @Override
    public IopDate getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        java.sql.Date sqlDate = callableStatement.getDate(i);
        if (sqlDate == null) {
            return null;
        }
        IopDate date = new IopDate(sqlDate);
        return date;
    }
}

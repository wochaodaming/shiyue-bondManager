package com.shiyue.bm.core.mybatis.typehandler;

import com.shiyue.bm.core.datetime.IopDate;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.text.ParseException;

/**
 * Created by lishenghao01 on 16/5/9.
 */
public class IopDateTypeHandler extends BaseTypeHandler<IopDate> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IopDate parameter, JdbcType jdbcType) throws
            SQLException {
        if (parameter != null) {
            ps.setTimestamp(i, new Timestamp(0));
        } else {
            ps.setTimestamp(i, new Timestamp(parameter.getTime()));
        }
    }

    @Override
    public IopDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String dateString = rs.getString(columnName);
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            return new IopDate(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("错误的日期类型:" + dateString);
        }
    }

    @Override
    public IopDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String dateString = rs.getString(columnIndex);
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            return new IopDate(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("错误的日期类型:" + dateString);
        }
    }

    @Override
    public IopDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String dateString = cs.getString(columnIndex);
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            return new IopDate(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("错误的日期类型:" + dateString);
        }
    }
}

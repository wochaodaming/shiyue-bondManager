package com.shiyue.bm.sysmanger.dictionary.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class DictionaryProvider {

    static final String tableName = "dictionary";

    public String insert() {
        BEGIN();
        INSERT_INTO(tableName);
        VALUES("id", "#{id}");
        VALUES("configGroup", "#{configGroup}");
        VALUES("configValue", "#{configGroup}");
        VALUES("configComment", "#{configComment}");
        VALUES("configOrder", "#{configOrder}");
        VALUES("updatetime", "#{updatetime}");
        return SQL();
    }
}

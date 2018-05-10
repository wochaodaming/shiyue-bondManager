package com.shiyue.bm.sysmanger.dictionary.dao;

import com.shiyue.bm.module.dictionary.Dictionary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DictionaryMapper {
    @InsertProvider(type = DictionaryProvider.class, method = "insert")
    @SelectKey(resultType = Long.class, keyProperty = "id", statement = {"select @@IDENTITY"}, before = false)
    Long insertDictionary(Dictionary dict);

    @Deprecated
    List<Long> insertDictionary(List<Dictionary> dictList);

    @Update("update t_dictionary set group=#{group}, value=#{value}, comments=#{comments} where id=#{id}")
    Long updateDictionary(Dictionary dict);

    @Deprecated
    Long updateDictionary(List<Dictionary> dictList);

    @Select("select * from t_dictionary where group=#{group}")
    List<Dictionary> selectDictionaryByGroup(@Param("group") String group);

    @Delete("delete from t_dictionary where id=#{id}")
    Long deleteDictionary(@Param("id") Long id);
}

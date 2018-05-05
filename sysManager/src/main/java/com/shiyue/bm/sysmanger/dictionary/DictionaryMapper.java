package com.shiyue.bm.sysmanger.dictionary;

import com.shiyue.bm.module.dictionary.Dictionary;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface DictionaryMapper {
    @InsertProvider(type = DictionaryProvider.class, method = "insert")
    @SelectKey(resultType = Long.class, keyProperty = "id", statement = {"select @@IDENTITY"}, before = false)
    Long insertDictionary(Dictionary dict) throws Exception;

    List<Long> insertDictionary(List<Dictionary> dictList) throws Exception;

    Long updateDictionary(Dictionary dict) throws Exception;

    Long updateDictionary(List<Dictionary> dictList) throws Exception;

    List<Dictionary> selectDictionary(String group) throws Exception;
}

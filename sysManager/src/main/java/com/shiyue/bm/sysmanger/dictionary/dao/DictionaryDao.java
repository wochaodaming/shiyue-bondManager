package com.shiyue.bm.sysmanger.dictionary.dao;

import com.shiyue.bm.module.dictionary.Dictionary;

import java.util.List;

public interface DictionaryDao {
    List<Long> insert(List<Dictionary> dictList);

    List<Dictionary> query(String group);

    List<Long> update(List<Dictionary> dictList);

    List<Long> delete(List<Long> ids);
}

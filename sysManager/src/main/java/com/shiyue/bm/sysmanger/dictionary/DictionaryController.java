package com.shiyue.bm.sysmanger.dictionary;

import com.shiyue.bm.module.dictionary.Dictionary;

import java.util.List;

public interface DictionaryController {

    List<Long> insert(List<Dictionary> dictList);

    List<Dictionary> query(String group);

    List<Long> update(List<Dictionary> dictList);

    Long delete(Long id);

    List<Long> delete(List<Long> ids);
}

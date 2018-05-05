package com.shiyue.bm.sysmanger.dictionary;

import com.shiyue.bm.module.dictionary.Dictionary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DictionaryDaoImpl implements DictionaryDao {
    @Override
    public List<Long> insert(List<Dictionary> dictList) {
        return null;
    }

    @Override
    public List<Dictionary> query(String group) {
        return null;
    }

    @Override
    public List<Long> update(List<Dictionary> dictList) {
        return null;
    }
}

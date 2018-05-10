package com.shiyue.bm.sysmanger.dictionary.dao;

import com.shiyue.bm.module.dictionary.Dictionary;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DictionaryDaoImpl implements DictionaryDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Long> insert(List<Dictionary> dictList) {
        SqlSession session = this.sqlSessionFactory.openSession();
        try {
            DictionaryMapper mapper = session.getMapper(DictionaryMapper.class);
            List<Long> ids = new ArrayList<>();
            for (Dictionary dict : dictList) {
                Long id = mapper.insertDictionary(dict);
                dict.setId(id);
                ids.add(id);
            }
            return ids;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Dictionary> query(String group) {
        SqlSession session = this.sqlSessionFactory.openSession();
        try {
            DictionaryMapper mapper = session.getMapper(DictionaryMapper.class);
            List<Dictionary> dictList = mapper.selectDictionaryByGroup(group);
            return dictList;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Long> update(List<Dictionary> dictList) {
        SqlSession session = this.sqlSessionFactory.openSession();
        try {
            DictionaryMapper mapper = session.getMapper(DictionaryMapper.class);
            List<Long> ids = new ArrayList<>();
            for (Dictionary dict :
                    dictList) {
                ids.add(mapper.updateDictionary(dict));
            }
            return ids;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Long> delete(List<Long> ids) {
        SqlSession session = this.sqlSessionFactory.openSession();
        try {
            DictionaryMapper mapper = session.getMapper(DictionaryMapper.class);
            for (Long id :
                    ids) {
                mapper.deleteDictionary(id);
            }
            return ids;
        } finally {
            session.close();
        }
    }


}

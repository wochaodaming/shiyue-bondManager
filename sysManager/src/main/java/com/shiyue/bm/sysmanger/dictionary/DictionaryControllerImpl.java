package com.shiyue.bm.sysmanger.dictionary;

import com.shiyue.bm.module.dictionary.Dictionary;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DictionaryControllerImpl implements DictionaryController {
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

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<Long> delete(List<Long> ids) {
        return null;
    }
}

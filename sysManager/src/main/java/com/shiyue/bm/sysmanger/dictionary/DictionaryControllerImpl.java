package com.shiyue.bm.sysmanger.dictionary;

import com.shiyue.bm.module.base.BaseResponse;
import com.shiyue.bm.module.dictionary.Dictionary;
import com.shiyue.bm.sysmanger.dictionary.dao.DictionaryDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/dict", produces = {APPLICATION_JSON_VALUE})
@Api(value = "dictionary", description = "配置的管理接口")
public class DictionaryControllerImpl implements DictionaryController {
    @Autowired
    private DictionaryDao dictionaryDao;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加配置", value = "添加配置", response = Long.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful responses",
            response = Long.class)})
    @Override
    public BaseResponse<List<Long>> insert(@RequestBody List<Dictionary> dictList) {
        BaseResponse<List<Long>> ret = new BaseResponse<>(this.dictionaryDao.insert(dictList));
        return ret;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据分组查询配置", value = "根据分组查询配置", response = Dictionary.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful responses",
            response = Dictionary.class)})
    @Override
    public BaseResponse<List<Dictionary>> query(String group) {
        BaseResponse<List<Dictionary>> ret = new BaseResponse<>(this.dictionaryDao.query(group));
        return ret;
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

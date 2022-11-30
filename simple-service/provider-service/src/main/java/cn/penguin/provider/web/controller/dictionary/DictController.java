package cn.penguin.provider.web.controller.dictionary;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.penguin.provider.entity.dictionary.DictDTO;
import cn.penguin.provider.service.dictionary.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wensy
 * @since 2022/11/27 15:48
 */
@RestController
@RequestMapping("/dict")
public class DictController {
    private final IDictService dictService;

    @Autowired
    public DictController(IDictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping("/query")
    public DictDTO query(DictDTO query){
        return dictService.selectOne(query);
    }

    @GetMapping("/list")
    public List<DictDTO> list(DictDTO query){
        return dictService.selectList(query);
    }

    @PostMapping("/save")
    @OperationLog(bizId = "#entity.id",bizType = "insert")
    public DictDTO save(@RequestBody DictDTO entity) {
        return dictService.save(entity);
    }

    @PostMapping("/update")
    @OperationLog(bizId = "#entity.id",bizType = "update")
    public Boolean update(@RequestBody DictDTO entity) {
        return dictService.update(entity);
    }
}

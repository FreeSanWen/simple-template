package cn.penguin.provider.web.controller.dictionary;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.penguin.provider.entity.dictionary.DictItemDTO;
import cn.penguin.provider.service.dictionary.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wensy
 * @since 2022/11/27 15:48
 */
@RestController
@RequestMapping("/dict/item")
public class DictItemController {
    private final IDictItemService dictItemService;

    @Autowired
    public DictItemController(IDictItemService dictItemService) {
        this.dictItemService = dictItemService;
    }

    @GetMapping("/query")
    public DictItemDTO query(DictItemDTO query){
        return dictItemService.selectOne(query);
    }

    @GetMapping("/list")
    public List<DictItemDTO> list(DictItemDTO query){
        return dictItemService.selectList(query);
    }

    @PostMapping("/save")
    @OperationLog( bizId = "#entity.id",bizType = "inesrt")
    public DictItemDTO save(@RequestBody DictItemDTO entity) {
        return dictItemService.save(entity);
    }

    @PostMapping("/update")
    @OperationLog( bizId = "#entity.id",bizType = "update")
    public Boolean update(@RequestBody DictItemDTO entity) {
        return dictItemService.update(entity);
    }
}

package cn.penguin.provider.web.controller.dictionary;

import cn.penguin.provider.entity.dictionary.DictItem;
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
    public DictItem query(DictItem query){
        return dictItemService.selectOne(query);
    }

    @GetMapping("/list")
    public List<DictItem> list(DictItem query){
        return dictItemService.selectList(query);
    }

    @PostMapping("/save")
    public DictItem save(@RequestBody DictItem entity) {
        return dictItemService.insert(entity);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody DictItem entity) {
        return dictItemService.update(entity);
    }
}

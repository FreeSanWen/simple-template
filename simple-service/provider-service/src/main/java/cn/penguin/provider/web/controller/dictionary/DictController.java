package cn.penguin.provider.web.controller.dictionary;

import cn.penguin.provider.entity.dictionary.Dict;
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
    public Dict query(Dict query){
        return dictService.selectOne(query);
    }

    @GetMapping("/list")
    public List<Dict> list(Dict query){
        return dictService.selectList(query);
    }

    @PostMapping("/save")
    public Dict save(@RequestBody Dict entity) {
        return dictService.insert(entity);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody Dict entity) {
        return dictService.update(entity);
    }
}

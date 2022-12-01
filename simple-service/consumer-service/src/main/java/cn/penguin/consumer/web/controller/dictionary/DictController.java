package cn.penguin.consumer.web.controller.dictionary;

import cn.penguin.consumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@RestController
@RequestMapping("/dict")
public class DictController {
    private final ProviderFeign providerDictFeign;

    @Autowired
    public DictController(ProviderFeign providerDictFeign) {
        this.providerDictFeign = providerDictFeign;
    }

    @GetMapping("/list")
    public String list(){
        return providerDictFeign.list();
    }
}

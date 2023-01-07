package cn.penguin.provider.web.controller.authentic;

import cn.penguin.provider.domain.dto.authentic.Resources;
import cn.penguin.provider.service.authentic.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wensy
 * @since 2023/01/07 22:54
 */
@RestController
@RequestMapping("/resources")
public class ResourcesController {

    private final IResourcesService resourcesService;

    @Autowired
    public ResourcesController(IResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping("/init-menu-list")
    public List<Resources> initMenuList(){
        return resourcesService.initMenuList();
    }
}

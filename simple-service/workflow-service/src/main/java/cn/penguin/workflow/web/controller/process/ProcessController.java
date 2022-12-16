package cn.penguin.workflow.web.controller.process;

import cn.penguin.workflow.service.process.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wensy
 * @since 2022/12/7 16:02
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

    private final IProcessService processService;

    @Autowired
    public ProcessController(IProcessService processService) {
        this.processService = processService;
    }

    /**
     * 所有流程名称
     *
     * @return
     */
    @GetMapping("/list")
    public List list(){
        return processService.list();
    }

    /**
     * 开始流程
     *
     * @param key
     * @return
     */
    @GetMapping("/start/{key}")
    public Boolean start(@PathVariable(name = "key") String key){
        return processService.start(key);
    }


}

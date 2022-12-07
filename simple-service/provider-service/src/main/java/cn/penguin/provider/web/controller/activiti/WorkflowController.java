package cn.penguin.provider.web.controller.activiti;

import cn.penguin.provider.service.activiti.IWorkflowService;
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
@RequestMapping("/workflow")
public class WorkflowController {

    private final IWorkflowService workflowService;

    @Autowired
    public WorkflowController(IWorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    /**
     * 所有流程名称
     *
     * @return
     */
    @GetMapping("/process/list")
    public List list(){
        return workflowService.list();
    }

    /**
     * 开始流程
     *
     * @param key
     * @return
     */
    @GetMapping("/process/start/{key}")
    public Boolean start(@PathVariable(name = "key") String key){
        return workflowService.start(key);
    }

    /**
     * 获取当前流程下某个角色的任务
     *
     * @return
     */
    @GetMapping("/task/list/{id}")
    public List taskList(@PathVariable String id){
        return workflowService.taskList(id);
    }

    /**
     * 完成任务
     *
     * @param id 角色id
     * @param key 流程id
     * @return
     */
    @GetMapping("/task/complete/{id}/{key}")
    public Boolean complete(@PathVariable String id,@PathVariable String key){
        return workflowService.complete(id,key);
    }
}

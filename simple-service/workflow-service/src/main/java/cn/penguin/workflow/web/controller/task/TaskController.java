package cn.penguin.workflow.web.controller.task;

import cn.penguin.workflow.service.task.ICustomTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final ICustomTaskService taskService;

    @Autowired
    public TaskController(ICustomTaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 获取当前流程下某个角色的任务
     *
     * @return
     */
    @GetMapping("/list/{id}")
    public List list(@PathVariable String id){
        return taskService.list(id);
    }

    /**
     * 完成任务
     *
     * @param id 角色id
     * @param key 流程id
     * @return
     */
    @GetMapping("/complete/{id}/{key}")
    public Boolean complete(@PathVariable String id,@PathVariable String key){
        return taskService.complete(id,key);
    }
}

package cn.penguin.workflow.service.task.impl;

import cn.penguin.workflow.service.task.ICustomTaskService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CustomTaskService implements ICustomTaskService {

    @Resource
    private TaskService taskService;

    @Override
    public List list(String id) {
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("leave").taskAssignee(id).list();
        List<Map> list = new ArrayList<>();
        for (Task task : taskList) {
            Map map = new HashMap();
            map.put("instanceId",task.getProcessInstanceId());
            map.put("id",task.getId());
            map.put("assignee",task.getAssignee());
            map.put("name",task.getName());
            list.add(map);
        }
        return list;
    }

    @Override
    public Boolean complete(String id, String key) {
        //对应各流程节点流转下一步人名称，这里第一步从worker开始，分别为worker-->leader-->finance
        Task task = taskService.createTaskQuery().processDefinitionKey(key).taskAssignee(id).singleResult();
        Map map = new HashMap();
        map.put("status",0);
        //完成任务，参数：任务id
        taskService.complete(task.getId(), map);
        return true;
    }
}

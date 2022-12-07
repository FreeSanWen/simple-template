package cn.penguin.provider.service.activiti.impl;

import cn.penguin.provider.service.activiti.IWorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wensy
 * @since 2022/12/7 16:03
 */
@Slf4j
@Service
public class WorkflowService implements IWorkflowService {


    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    @Override
    public List list() {
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> definitionList = definitionQuery.list();
        //提取所有的流程名称
        List<String> processList = new ArrayList<>();
        for (ProcessDefinition processDefinition : definitionList) {
            processList.add(processDefinition.getName());
        }
        return processList;
    }

    @Override
    public Boolean start(String key) {
        Map<String,Object> map = new HashMap<>();
        map.put("user","Jack");
        map.put("leader","Marry");
        map.put("finance","Bob");
        //启动 key 标识的流程定义，并指定 流程定义中的两个参数：assignee0和assignee1
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);
        log.info("流程实例的内容：{}，信息：{}", processInstance, processInstance.getProcessDefinitionName());
        return true;

    }

    @Override
    public List taskList(String id) {
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

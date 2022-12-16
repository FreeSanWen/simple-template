package cn.penguin.workflow.service.process.impl;

import cn.penguin.workflow.service.process.IProcessService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProcessService implements IProcessService {

    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;

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
}

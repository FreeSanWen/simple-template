package cn.penguin.provider.service.activiti;

import java.util.List;

/**
 * @author wensy
 * @since 2022/12/7 16:03
 */
public interface IWorkflowService {

    List list();

    Boolean start(String key);

    List taskList(String id);

    Boolean complete(String id, String key);
}

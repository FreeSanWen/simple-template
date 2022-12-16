package cn.penguin.workflow.service.task;

import java.util.List;

public interface ICustomTaskService {
    List list(String id);

    Boolean complete(String id, String key);
}

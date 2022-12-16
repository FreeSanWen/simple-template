package cn.penguin.workflow.service.process;

import java.util.List;

public interface IProcessService {
    List list();

    Boolean start(String key);
}

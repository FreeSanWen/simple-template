package cn.penguin.common.service;

import cn.penguin.common.entity.LogRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


@ConditionalOnMissingBean(name = "customLogService")
public interface ILogService {

    void saveLog(LogRecord entity);
}

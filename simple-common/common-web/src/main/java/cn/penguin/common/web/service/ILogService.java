package cn.penguin.common.web.service;

import cn.penguin.common.web.entity.LogRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


@ConditionalOnMissingBean(name = "customLogService")
public interface ILogService {

    void saveLog(LogRecord entity);
}

package cn.penguin.common.web.service.impl;

import cn.penguin.common.core.constant.LogbackConstant;
import cn.penguin.common.web.entity.LogRecord;
import cn.penguin.common.web.mapper.LogRecordMapper;
import cn.penguin.common.web.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ConditionalOnMissingBean(name = "customLogService")
public class LogService implements ILogService {

    private final LogRecordMapper logRecordMapper;

    @Autowired
    public LogService(LogRecordMapper logRecordMapper) {
        this.logRecordMapper = logRecordMapper;
    }

    @Override
    public void saveLog(LogRecord entity) {
        log.info("{}保存操作日志开始", LogbackConstant.LOG_PREFIX);
        logRecordMapper.insert(entity);
        log.info("{}保存操作日志结束", LogbackConstant.LOG_PREFIX);
    }
}

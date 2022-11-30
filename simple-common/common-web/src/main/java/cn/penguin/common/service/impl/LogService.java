package cn.penguin.common.service.impl;

import cn.penguin.common.entity.LogRecordDTO;
import cn.penguin.common.mapper.LogRecordMapper;
import cn.penguin.common.service.ILogService;
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
    public void saveLog(LogRecordDTO entity) {
        log.info("==>保存操作日志开始");
        logRecordMapper.insert(entity);
        log.info("==>保存操作日志结束");
    }
}

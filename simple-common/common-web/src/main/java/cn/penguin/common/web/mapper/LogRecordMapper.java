package cn.penguin.common.web.mapper;

import cn.penguin.common.web.entity.LogRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRecordMapper {

    int insert(LogRecord entity);

    List<LogRecord> selectList(LogRecord query);
}

package cn.penguin.common.mapper;

import cn.penguin.common.entity.LogRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRecordMapper {

    int insert(LogRecord entity);

    List<LogRecord> selectList(LogRecord query);
}

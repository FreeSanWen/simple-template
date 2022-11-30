package cn.penguin.common.mapper;

import cn.penguin.common.entity.LogRecordDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRecordMapper {

    int insert(LogRecordDTO entity);

    List<LogRecordDTO> selectList(LogRecordDTO query);
}

package cn.penguin.provider.mapper.dictionary;


import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.provider.domain.dto.dictionary.Dict;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wensy
 * @since 2022-11-27 11:02:58
 */
@Mapper
public interface DictMapper extends GenericMapper<Dict> {

}

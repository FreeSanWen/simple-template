package cn.penguin.provider.service.dictionary.impl;

import cn.penguin.common.mybatis.service.impl.BaseService;
import cn.penguin.provider.domain.dto.dictionary.DictItem;
import cn.penguin.provider.mapper.dictionary.DictItemMapper;
import cn.penguin.provider.service.dictionary.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Wensy
 * @since 2022/11/27 17:51:00
 */
@Service
public class DictItemService extends BaseService<DictItemMapper, DictItem> implements IDictItemService {


    private final DictItemMapper dictItemMapper;

    @Autowired
    public DictItemService(DictItemMapper dictItemMapper) {
        this.dictItemMapper = dictItemMapper;
    }

}

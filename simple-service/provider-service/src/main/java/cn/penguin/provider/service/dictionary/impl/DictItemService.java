package cn.penguin.provider.service.dictionary.impl;

import cn.penguin.common.service.impl.BaseService;
import cn.penguin.provider.entity.dictionary.DictItemDTO;
import cn.penguin.provider.mapper.dictionary.DictItemMapper;
import cn.penguin.provider.service.dictionary.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Wensy
 * @since 2022/11/27 17:51:00
 */
@Service
public class DictItemService extends BaseService<DictItemDTO> implements IDictItemService {

    private final DictItemMapper dictItemMapper;

    @Autowired
    public DictItemService(DictItemMapper dictItemMapper) {
        super(dictItemMapper);
        this.dictItemMapper = dictItemMapper;
    }

}

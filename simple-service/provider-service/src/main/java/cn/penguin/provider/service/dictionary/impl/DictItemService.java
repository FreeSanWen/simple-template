package cn.penguin.provider.service.dictionary.impl;

import cn.penguin.common.service.impl.BaseService;
import cn.penguin.provider.entity.dictionary.DictItem;
import cn.penguin.provider.mapper.dictionary.DictItemMapper;
import cn.penguin.provider.repository.dictionary.DictItemRepository;
import cn.penguin.provider.service.dictionary.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Wensy
 * @since 2022/11/27 17:51:00
 */
@Service
public class DictItemService extends BaseService<DictItem, Long> implements IDictItemService {

    private final DictItemMapper dictItemMapper;
    private final DictItemRepository dictItemRepository;

    @Autowired
    public DictItemService(DictItemMapper dictItemMapper, DictItemRepository dictItemRepository) {
        super(dictItemMapper,dictItemRepository);
        this.dictItemMapper = dictItemMapper;
        this.dictItemRepository = dictItemRepository;
    }

}

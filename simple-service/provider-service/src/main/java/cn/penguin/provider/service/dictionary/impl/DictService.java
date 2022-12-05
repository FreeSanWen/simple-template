package cn.penguin.provider.service.dictionary.impl;

import cn.penguin.common.service.impl.BaseService;
import cn.penguin.provider.entity.dictionary.Dict;
import cn.penguin.provider.mapper.dictionary.DictMapper;
import cn.penguin.provider.repository.dictionary.DictRepository;
import cn.penguin.provider.service.dictionary.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wensy
 * @since 2022/11/27 17:51:00
 */
@Service
public class DictService extends BaseService<Dict, Long> implements IDictService {

    private final DictMapper dictMapper;
    private final DictRepository dictRepository;

    @Autowired
    public DictService(DictMapper dictMapper, DictRepository dictRepository) {
        super(dictMapper,dictRepository);
        this.dictMapper = dictMapper;
        this.dictRepository = dictRepository;
    }

}

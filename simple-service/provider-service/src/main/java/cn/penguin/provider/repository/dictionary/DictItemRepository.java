package cn.penguin.provider.repository.dictionary;

import cn.penguin.common.repository.BaseRepository;
import cn.penguin.provider.entity.dictionary.DictItem;
import org.springframework.stereotype.Repository;

/**
 * @author wensy
 * @since 2022/12/5 16:06
 */
@Repository
public interface DictItemRepository extends BaseRepository<DictItem, Long> {
}

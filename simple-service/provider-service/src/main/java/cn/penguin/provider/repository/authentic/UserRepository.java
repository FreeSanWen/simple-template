package cn.penguin.provider.repository.authentic;

import cn.penguin.common.repository.BaseRepository;
import cn.penguin.provider.entity.authentic.User;
import org.springframework.stereotype.Repository;

/**
 * @author wensy
 * @since 2022/12/5 13:53
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}

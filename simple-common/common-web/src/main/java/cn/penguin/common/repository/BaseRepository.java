package cn.penguin.common.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author wensy
 * @since 2022/12/5 15:27
 */
public interface BaseRepository<T,ID> extends PagingAndSortingRepository<T, ID> {

}

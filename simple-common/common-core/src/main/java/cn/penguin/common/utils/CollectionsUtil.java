package cn.penguin.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public class CollectionsUtil extends CollectionUtils {

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static <R, T> Map<R, T> list2Map(List<T> list, Function<T,R> key) {
        return isEmpty(list) ? null : list.stream().collect(Collectors.toMap(key, value -> value));
    }

    public static <R, T, V> Map<R, V> list2Map(List<T> list, Function<T, R> key, Function<T, V> value) {
        return isEmpty(list) ? null : list.stream().collect(Collectors.toMap(key, value));
    }

    public static <R, T> Map<R, List<T>> list2MapList(List<T> list, Function<T, R> key) {
        return isEmpty(list) ? null : list.stream().collect(Collectors.groupingBy(key));
    }

    public static <R, T> ConcurrentMap<R, List<T>> list2ConcurrentMapList(List<T> list, Function<T, R> key) {
        return isEmpty(list) ? null : list.stream().collect(Collectors.groupingByConcurrent(key));
    }
}

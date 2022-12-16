package cn.penguin.common.core.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public class TreeUtil {

    /**
     * 构建树形集合
     *
     * @param list 数据源
     * @param parentKey 上层 id
     * @param childKey 下层对应的上层id
     * @param setMethod 设置下层集合的方法
     * @param checkParentCondition 判断顶层的逻辑
     * @return
     * @param <Entity> 集合泛型对象
     * @param <Basic> id 类型
     */
    public static <Entity, Basic> List<Entity> create(List<Entity> list, Function<Entity, Basic> parentKey, Function<Entity, Basic> childKey, BiConsumer<Entity, List<Entity>> setMethod, Predicate<Basic> checkParentCondition) {
        if (CollectionsUtil.isNotEmpty(list)) {
            //获取最顶层
            List<Entity> parent = list.stream().filter(object -> checkParentCondition.test(childKey.apply(object))).collect(Collectors.toList());
            //获取子类
            createChild(parent, list, parentKey, childKey, setMethod);
            return parent;
        }
        return new ArrayList<>(1);
    }

    private static <Entity, Basic> void createChild(List<Entity> parentList, List<Entity> list, Function<Entity,Basic> parentKey, Function<Entity,Basic> childKey, BiConsumer<Entity, List<Entity>> setMethod) {
        Optional.of(parentList).ifPresent(parents ->parents.forEach(parent ->{
                //得到当前下的子类
                List<Entity> collect = list.stream().filter(obj -> parentKey.apply(parent).equals(childKey.apply(obj))).collect(Collectors.toList());
                //递归获取所有子类的子类
                createChild(collect, list, parentKey, childKey, setMethod);
                //递归结束
                setMethod.accept(parent, collect);
            }));
    }

}

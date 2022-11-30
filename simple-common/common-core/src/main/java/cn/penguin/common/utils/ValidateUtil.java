package cn.penguin.common.utils;

import cn.penguin.common.exception.BizException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author wensy
 * @since 2022-11-22 11:38:00
 */
public class ValidateUtil {

    private  static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void verifyParam(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> {
            if (value == null) {
                sb.append(key).append("|");
            } else if (value instanceof String) {
                String str = String.valueOf(value);
                if (ObjectUtil.isEmpty(str)) {
                    sb.append(key).append("|");
                }
            } else if (value instanceof List) {
                List list = (List) value;
                if (CollectionsUtil.isEmpty(list)) {
                    sb.append(key).append("|");
                }
            } else if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                if (file.isEmpty() || file.getSize() == 0) {
                    sb.append(key).append("|");
                }
            }
        });
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            throw new BizException(String.format("缺少参数%s",sb));
        }

    }

    /**
     * 取自hashmap方法tableSizeFor(int cap)
     */
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}

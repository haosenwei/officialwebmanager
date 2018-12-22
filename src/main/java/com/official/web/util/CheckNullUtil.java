package com.official.web.util;


import java.util.Collection;
import java.util.Map;


/**
 * 检查是否为空
 * @author hsw
 *
 */
public class CheckNullUtil {
	/**
	 * 是否空
	 * @param obj
	 * @return 不为空=true,为空==false
	 */
	public static boolean isNotNullOrEmpty(Object obj) {
		boolean f =isNullOrEmpty(obj);
		return !f;
	}
	/**
     * 对象是否为空
     * 为空返回 true
     * @param obj
     * @return 为空=true,不为空==false
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }
}

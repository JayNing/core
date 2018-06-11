package com.zx.util;

import java.util.*;

/**
 * Created by ning on 2018/3/5 11:31.
 */
public class CollectionUtils {

    public static void main(String[] args){
        String[] arr = {"1","2","3","4"};
        String are = "4";
        List list = arrayToList(arr);
        System.out.println(list);
        System.out.println("111111111111111");
        String[] arr2 = {"5","2","3"};
        List list2 = arrayToList(arr2);
        System.out.println(containsInstance(list,are));
        System.out.println(containsAny(list2,list));
        System.out.println(findFirstMatch(list,list2));


    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection)
    {
        return (collection == null) || (collection.isEmpty());
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null) || (map.isEmpty());
    }

    /**
     * 将数组元素转成list集合
     * @param source
     * @return
     */
    public static List arrayToList(Object source)
    {
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }

    /**
     * 检验元素是否在集合中
     * @param collection
     * @param element
     * @return
     */
    public static boolean containsInstance(Collection<?> collection, Object element)
    {
        Iterator i$;
        if (collection != null) {
            for (i$ = collection.iterator(); i$.hasNext(); ) { Object candidate = i$.next();
                if (candidate == element) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检测目的集合中是否有相同元素在源集合中
     * @param source
     * @param candidates
     * @return
     */
    public static boolean containsAny(Collection<?> source, Collection<?> candidates) {
        if ((isEmpty(source)) || (isEmpty(candidates))) {
            return false;
        }
        for (Iterator i$ = candidates.iterator(); i$.hasNext(); ) {
            Object candidate = i$.next();
            if (source.contains(candidate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到目标集合中与源集合中第一个相同的元素
     * @param source
     * @param candidates
     * @param <T>
     * @return
     */
    public static <T> T findFirstMatch(Collection<T> source, Collection<T> candidates)
    {
        if ((isEmpty(source)) || (isEmpty(candidates))) {
            return null;
        }
        for (Iterator i = candidates.iterator(); i.hasNext(); ) {
            Object candidate = i.next();
            if (source.contains(candidate)) {
                return (T) candidate;
            }
        }
        return null;
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] array)
    {
        ArrayList elements = new ArrayList();
        while (enumeration.hasMoreElements()) {
            elements.add(enumeration.nextElement());
        }
        return (A[])elements.toArray(array);
    }
}

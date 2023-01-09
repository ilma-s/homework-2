package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUtil {

    //sort a map by value
    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> getFirstN(Map<K, V> map, int n) {
        List<Map.Entry<K, V>> listSort = new LinkedList<>(map.entrySet());
        listSort.sort((o1, o2) -> o2.getValue().compareTo((o1.getValue())));
        return listSort.subList(0, n);
    }

}

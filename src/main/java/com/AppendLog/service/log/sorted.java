package com.AppendLog.service.log;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class sorted {
    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {

            // 비교 후 순서 변경
            public int compare(K k1, K k2) {
                int comp = map.get(k2).compareTo(
                        map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}

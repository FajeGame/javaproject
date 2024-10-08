package org.example;

import java.util.HashMap;
import java.util.Map;

public class MapInverter {
    public static <K, V> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
}

package org.example;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class MapUtilTest {

    @Test
    public void generate() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        List<Map.Entry<String, Integer>> listSort = MapUtil.getFirstN(map, 3);
        assertEquals(3, listSort.size());
        assertEquals("e", listSort.get(0).getKey());
        assertEquals(5, listSort.get(0).getValue().intValue());
        assertEquals("d", listSort.get(1).getKey());
        assertEquals(4, listSort.get(1).getValue().intValue());
        assertEquals("c", listSort.get(2).getKey());
        assertEquals(3, listSort.get(2).getValue().intValue());
    }
}
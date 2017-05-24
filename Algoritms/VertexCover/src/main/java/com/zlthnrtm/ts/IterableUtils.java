package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IterableUtils {
    
    public static <T> List<T> listFromSet(Set<T> set) {
        List<T> list = new ArrayList<>(set.size());
        for(T i: set) {
            list.add(i);
        }
        return list;
        
    }
}
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author manjaro
 */
public class IterableUtils {
    
    public static <T> List<T> listFromSet(Set<T> set) {
        List<T> list = new ArrayList<>(set.size());
        for(T i: set) {
            list.add(i);
        }
        return list;
        
    }
    
    public static <T> T takeFirst(Iterable<T> iterable){
        for(T i: iterable) {
            if (i != null) {
                return i;
            }
        }
        return null;
    }
}
 
package com.teacher.common.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 15:18 2017/12/13
 * @Modified By:
 */
public class ThreadLocalMap {
    private static ThreadLocal<Map<String,Object>> pool = new ThreadLocal<>();
    public static void put(String key,Object value){
        if (pool.get() == null){
            pool.set(new HashMap());
        }
        Map map = pool.get();
        map.put(key,value);
    }
    public static  Object get(String key){
        Map map = pool.get();
        if (map == null){
            return null;
        }
        return map.get(key);
    }
    public static Object remove(String key){
        Map map =pool.get();
        if (map == null){
            return null;
        }
        return map.remove(key);
    }
    public static Map getMap(){
        return pool.get();
    }
    public static void clear(){
        pool.set(null);
    }
}

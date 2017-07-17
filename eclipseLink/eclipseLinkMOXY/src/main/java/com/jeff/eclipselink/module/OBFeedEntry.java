package com.jeff.eclipselink.module;

import java.util.*;

/**
 * Created by Jeff.Ma on 7/13/2017.
 */
public class OBFeedEntry {
    // private Map<String, Object> extensions = new HashMap<String, Object>();

    private MyType<String, Object> extensions = new MyType<String, Object>();

    public static class MyType<K, V> {
        Map<K, V> map = new HashMap<K, V>();

        public V get(K key) {
            return map.get(key);
        }

        public void put(K key, V value) {
            map.put(key, value);
        }

        public boolean isEmpty() {
            return map.size() == 0;
        }

        public Map<K, V> getMap() {
            return map;
        }
    }

    public MyType getMap() {

        return extensions;
    }

    public <T> T get(String property) {
        return (T) extensions.get(property);
    }

    public <T> T get(String property, Class<T> returnType) {
        return (T) extensions.get(property);
    }

    public Boolean getBoolean(String property) {
        return get(property, Boolean.class);
    }

    public String getString(String property) {
        return get(property, String.class);
    }

    public Long getLong(String property) {
        return get(property, Long.class);
    }

    public Integer getInteger(String property) {
        return get(property, Integer.class);
    }

    public Float getFloat(String property) {
        return get(property, Float.class);
    }

    public Double getDouble(String property) {
        return get(property, Double.class);
    }

    public Date getDate(String property) {
        return get(property, Date.class);
    }

    public Calendar getCalendar(String property) {
        return get(property, Calendar.class);
    }

    public List getList(String property) {
        return get(property, List.class);
    }

    public OBFeedEntry getEntry(String property) {
        return get(property, OBFeedEntry.class);
    }

    public void put(String property, Object value) {
        if (value != null) {
            extensions.put(property, value);
        }
    }

    public void set(String property, Object value) {
        if (value != null) {
            extensions.put(property, value);
        }
    }

    public Map<String, String> toStringMap() {
        Map<String, String> stringMap = new HashMap<String, String>();
        if (this.isNotEmpty()) {
            for (String key : this.extensions.getMap().keySet()) {
                Object valueObj = this.extensions.get(key);
                if (valueObj instanceof String) {
                    stringMap.put(key, (String) valueObj);
                }
            }
        }
        return stringMap;
    }

    public boolean isEmpty() {
        return extensions.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}

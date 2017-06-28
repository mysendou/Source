package com.jeff.cache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

public class DataCache {
    private CacheManager cacheManager;
    private Cache cache;
    private static final Logger logger = Logger.getLogger(DataCache.class);

    public void setupCache() {
        cacheManager = CacheManager.create("D:/MyworkspaceTest/ehcacheDemo1/src/config/ehcache.xml");
//        cache = new Cache("ehcacheSimple1", 1, true, false, 50000, 20000);
//        cacheManager.addCache(cache);
        cache = cacheManager.getCache("ehcacheSimple1");
        logger.info("Cache setup is done");
    }

    public List<String> getFromCache() {
        Element find = cache.get("all-peeps");
        if (null!=find) {
            return (List<String>) find.getObjectValue();
        } else {
            return null;
        }
    }

    public void addToCache(List<String> line) {
        Element element = new Element("all-peeps", line);
        cache.put(element);
    }

    public void clearCache() {
        cacheManager.removeCache("ehcacheSimple1");
    }

    public void close() {
        // TODO Auto-generated method stub

    }

}

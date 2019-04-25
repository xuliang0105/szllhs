package com.yzjk.common.ehcache;


import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Slf4j
public class EhCacheProvider {
	 
	private static CacheManager cacheManager;
	
	static {
		if(cacheManager == null) {
			cacheManager = CacheManager.create();
			log.info("CacheManager is created!");
		}
	}
	
	/**
	 * 获取cache对象，如果配置文件中没有，就新增一个cache
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache == null) {
			log.warn("Could not find configuration [" + cacheName + "]");
			cacheManager.addCache(cacheName);
			cache = cacheManager.getCache(cacheName);
		}
		return cache;
	}
	
	/**
	 * 根据cache名称和key获取以保存的cache数据
	 * @param cacheName
	 * @param key
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Object get(String cacheName, Object key) {
		if(cacheName != null && key != null) {
			Cache cache = getCache(cacheName);
			Element element = cache.get(key);
			if(element != null) {
 				log.info("获取缓存数据成功");
				return element.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 往缓存中添加cache数据
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, Object key, Object value) {
		if(cacheName != null && key != null && value != null)
			getCache(cacheName).put(new Element(key, value));
	}
	
	/**
	 * 清楚缓存中某个数据
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, Object key) {
		if(cacheName != null && key != null) {
			Cache cache = getCache(cacheName);
			if(cache != null)
				cache.remove(key);
		}
	}
}

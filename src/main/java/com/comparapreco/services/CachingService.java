package com.comparapreco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class CachingService {
	
	@Autowired
	CacheManager cacheManager;

	@Scheduled(fixedRate = 86400000)
    public void evictAllCaches() {
		cacheManager.getCacheNames().stream()
		  .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
}


package com.comparapreco.services;

public class CachingService {

    public void evictAllCaches() {
    cacheManager.getCacheNames().stream()
      .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
}


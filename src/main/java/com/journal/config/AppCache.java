package com.journal.config;

import com.journal.entity.Config;
import com.journal.services.ConfigServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public Map<String, String> appCache;
    
    @Autowired
    private ConfigServices configServices;

    @PostConstruct
    public void setCache() {
        appCache = new java.util.HashMap<>();
        List<Config> config = configServices.findConfig();
        for (Config c : config) {
            appCache.put(c.getName(), c.getValue());
        }
    }
}

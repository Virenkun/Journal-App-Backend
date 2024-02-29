package com.journal.services;

import com.journal.entity.Config;
import com.journal.repositry.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServices {

    @Autowired
    private ConfigRepository configRepository;

    public List<Config> findConfig() {
        return configRepository.findAll();
    }

}

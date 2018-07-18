package com.alern.sericefeign.service.impl;

import com.alern.sericefeign.service.SchedualService;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceImpl implements SchedualService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

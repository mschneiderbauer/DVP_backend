package com.dvp.demo.controllers;

import com.dvp.demo.models.LeistungserbringerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LeistungserbringerRepo extends CrudRepository<LeistungserbringerEntity, Long> {
}

package com.dvp.demo.controllers;

import com.dvp.demo.models.LeistungserbringungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface Leistungserbringung extends CrudRepository<LeistungserbringungEntity, Long> {
}

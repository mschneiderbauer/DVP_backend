package com.dvp.demo.controllers;

import com.dvp.demo.models.LeistungserbringungEntity;
import com.dvp.demo.models.LeistungserbringungId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface Leistungserbringung extends CrudRepository<LeistungserbringungEntity, LeistungserbringungId> {
}

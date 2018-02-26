package com.dvp.demo.controllers;

import com.dvp.demo.models.BewilligungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface BewilligungRepo extends CrudRepository <BewilligungEntity, Long> {
}

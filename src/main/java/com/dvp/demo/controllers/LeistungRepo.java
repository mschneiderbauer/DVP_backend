package com.dvp.demo.controllers;

import com.dvp.demo.models.LeistungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LeistungRepo extends CrudRepository<LeistungEntity, Long> {
}

package com.dvp.demo.controllers;

import com.dvp.demo.models.VerordnungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface VerordnungRepo extends CrudRepository<VerordnungEntity, Long> {
}

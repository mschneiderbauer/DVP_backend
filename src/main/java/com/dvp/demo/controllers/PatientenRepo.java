package com.dvp.demo.controllers;

import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.PatientenId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatientenRepo extends CrudRepository<PatientenEntity,PatientenId> {
}

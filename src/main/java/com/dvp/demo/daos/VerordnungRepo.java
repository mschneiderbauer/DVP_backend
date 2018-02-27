package com.dvp.demo.daos;

import com.dvp.demo.models.VerordnungEntity;
import com.dvp.demo.models.VerordnungId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface VerordnungRepo extends CrudRepository<VerordnungEntity, VerordnungId> {
}

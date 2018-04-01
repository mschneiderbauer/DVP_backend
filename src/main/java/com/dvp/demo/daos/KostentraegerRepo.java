package com.dvp.demo.daos;

import com.dvp.demo.models.KostentraegerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface KostentraegerRepo extends CrudRepository<KostentraegerEntity, Integer>{
}

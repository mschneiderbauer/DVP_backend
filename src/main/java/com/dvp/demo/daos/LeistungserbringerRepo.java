package com.dvp.demo.daos;

import com.dvp.demo.models.LeistungserbringerEntity;
import com.dvp.demo.models.LeistungserbringerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LeistungserbringerRepo extends CrudRepository<LeistungserbringerEntity, LeistungserbringerId> {
}

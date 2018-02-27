package com.dvp.demo.daos;

import com.dvp.demo.models.SendungEntity;
import com.dvp.demo.models.SendungId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface SendungRepo extends CrudRepository<SendungEntity, SendungId> {
}

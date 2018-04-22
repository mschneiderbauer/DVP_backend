package com.dvp.demo.daos;

import com.dvp.demo.models.SendungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface SendungRepo extends CrudRepository<SendungEntity, Long> {
    public SendungEntity findByidAndKundennummer(long id, long kundennummer);
}

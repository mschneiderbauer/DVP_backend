package com.dvp.demo.daos;

import com.dvp.demo.models.SendungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SendungRepo extends CrudRepository<SendungEntity, Long> {

    public List<SendungEntity> findByperiodeAndKundennummer(String periode, long kundennummer);

    public List<SendungEntity> findBykundennummer(long kundennummer);
}

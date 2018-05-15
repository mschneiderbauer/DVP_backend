package com.dvp.demo.daos;

import com.dvp.demo.models.LeistungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface LeistungRepo extends CrudRepository<LeistungEntity, Integer> {
    @Transactional
    public void deleteByVid(long vid);

    public List<LeistungEntity> findByVid(long vid);
}

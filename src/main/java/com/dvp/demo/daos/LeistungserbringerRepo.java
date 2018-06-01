package com.dvp.demo.daos;

import com.dvp.demo.models.LeistungserbringerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface LeistungserbringerRepo extends CrudRepository<LeistungserbringerEntity, Long> {
    @Transactional
    public void deleteByVid(long vid);

    public List<LeistungserbringerEntity> findByvid(long vid);
}

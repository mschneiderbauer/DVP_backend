package com.dvp.demo.daos;

import com.dvp.demo.models.BewilligungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BewilligungRepo extends CrudRepository <BewilligungEntity,Long> {
    @Transactional
    public void deleteByVid(long vid);

    public List<BewilligungEntity> findByvid(long vid);
}

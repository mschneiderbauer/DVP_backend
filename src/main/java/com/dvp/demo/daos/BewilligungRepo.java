package com.dvp.demo.daos;

import com.dvp.demo.models.BewilligungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface BewilligungRepo extends CrudRepository <BewilligungEntity,Long> {
    public void deleteByvo_id(long vo_id);
}

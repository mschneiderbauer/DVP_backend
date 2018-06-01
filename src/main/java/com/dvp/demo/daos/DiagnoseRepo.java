package com.dvp.demo.daos;

import com.dvp.demo.models.DiagnoseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface DiagnoseRepo extends CrudRepository<DiagnoseEntity, Integer> {
    @Transactional
    public void deleteByVid(long vid);

    public List<DiagnoseEntity> findByvid(long vid);
}

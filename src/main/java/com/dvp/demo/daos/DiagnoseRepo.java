package com.dvp.demo.daos;

import com.dvp.demo.models.DiagnoseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface DiagnoseRepo extends CrudRepository<DiagnoseEntity, Integer> {
}
package com.dvp.demo.daos;

import com.dvp.demo.models.PatientenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatientenRepo extends CrudRepository<PatientenEntity,Long> {
    public PatientenEntity findByvsnrpAndKundennummer(long vsnrp, long kundennummer);
}

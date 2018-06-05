package com.dvp.demo.daos;

import com.dvp.demo.models.VerordnungEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface VerordnungRepo extends CrudRepository<VerordnungEntity, Long> {

    public List<VerordnungEntity> findByvsnrpAndKundennummer(long VSNRP, long kundennummer);

    public List<VerordnungEntity> findByperiodeAndKundennummer(String periode, long kundennummer);

    public VerordnungEntity findByvidAndKundennummer(long vid, long kundennummer);

    @Transactional
    public void deleteByVidAndKundennummer(long vid, long kundennummer);
}

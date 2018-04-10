package com.dvp.demo.daos;

import com.dvp.demo.models.VerordnungEntity;
import com.dvp.demo.models.VerordnungId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VerordnungRepo extends CrudRepository<VerordnungEntity, VerordnungId> {

    public List<VerordnungEntity> findByVSNRPAndId_Kundennummer(long VSNRP, long kundennummer);

    public List<VerordnungEntity> findBySendung_idAndId_Kundennummer(long Sendung_id, long kundennummer);
}

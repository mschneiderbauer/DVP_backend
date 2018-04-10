package com.dvp.demo.daos;

import com.dvp.demo.models.VerordnungEntity;
import com.dvp.demo.models.VerordnungId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VerordnungRepo extends CrudRepository<VerordnungEntity, VerordnungId> {

    public List<VerordnungEntity> findByvsnrpAndId_Kundennummer(long VSNRP, long kundennummer);

    public List<VerordnungEntity> findBysendungidAndId_Kundennummer(long sendungid, long kundennummer);
}

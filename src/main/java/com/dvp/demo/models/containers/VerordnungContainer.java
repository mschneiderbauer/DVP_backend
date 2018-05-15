package com.dvp.demo.models.containers;

import com.dvp.demo.models.*;

import java.util.List;

public class VerordnungContainer {
    public VerordnungEntity verordnungEntity;
    public List<BewilligungEntity> bewilligungEntities;
    public List<DiagnoseEntity> diagnoseEntities;
    public List<LeistungEntity> leistungEntities;
    public List<LeistungserbringerEntity> leistungserbringerEntities;
}

package com.dvp.demo.models.containers;

import com.dvp.demo.models.*;

import java.util.List;

public class VerordnungContainer {
    public VerordnungEntity vo;
    public List<BewilligungEntity> bewilligungen;
    public List<DiagnoseEntity> diagnosen;
    public List<LeistungEntity> leistungen;
    public List<LeistungserbringerEntity> leistungserbringer;

    @Override
    public String toString() {
        return "VerordnungContainer{" +
                "vo=" + vo +
                ", bewilligungen=" + bewilligungen +
                ", diagnosen=" + diagnosen +
                ", leistungen=" + leistungen +
                ", leistungserbringer=" + leistungserbringer +
                '}';
    }
}

package com.mjc813.master_refer_interface;

import com.mjc813.master_refer_id.MasterTable;

public interface IRefer {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    Long getMasterTableId();
    void setMasterTableId(Long masterTableId);

    MasterTable getMaster();
    void setMaster(MasterTable masterTableId);


    default void copyMembers(IRefer src) {
        setId(src.getId());
        setName(src.getName());
        setMasterTableId(src.getMasterTableId());
        setMaster(src.getMaster());
    }
}

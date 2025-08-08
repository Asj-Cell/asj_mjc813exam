package com.mjc813.master_refer_interface;

import com.mjc813.master_refer_id.MasterTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReferEntity implements IRefer {
    private Long id;
    private String name;
    private Long masterTableId;
    private MasterTable master;

    public void setMasterTableId(Long masterTableId) {
        this.masterTableId = masterTableId;
        if (master != null) {
            master.setId(masterTableId);
        }
    }

    public Long getMasterTableId() {
        if (master != null) {
            return master.getId();
        }
        return masterTableId;
    }
}

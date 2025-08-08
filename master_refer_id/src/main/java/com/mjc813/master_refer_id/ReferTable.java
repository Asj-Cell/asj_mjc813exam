package com.mjc813.master_refer_id;

import lombok.*;
@Getter @Setter
@NoArgsConstructor
public class ReferTable {
    private Long id;
    private String name;
    private Long materTableId;
    private MasterTable master;

    public ReferTable(Long id, String name, Long materTableId, MasterTable master) {
        this.id = id;
        this.name = name;
        this.materTableId = materTableId;
        //this.master = master;
        if (master != null) {
            this.master = new MasterTable(master.getId(), master.getName());
        }else{
            this.master = new MasterTable(materTableId,"master");
        }
    }

    public void setMaterTableId(Long materTableId) {

        this.materTableId = materTableId;
        if (master == null) {
            this.master = new MasterTable();
        }
        master.setId(materTableId);

    }

    public Long getMaterTableId() {
        if (master != null) {
            return master.getId();
        }
        return materTableId;
    }


}

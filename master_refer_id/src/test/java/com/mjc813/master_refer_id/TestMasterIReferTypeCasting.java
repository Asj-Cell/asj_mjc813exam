package com.mjc813.master_refer_id;

import com.mjc813.master_refer_interface.ReferDto;
import com.mjc813.master_refer_interface.ReferEntity;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMasterIReferTypeCasting {
    @Test
    public void referDto2Entity() {
        ReferDto dto = new ReferDto(10L, "referDto", 20L, new MasterTable(20L, "master"));
        ReferEntity entity = new ReferEntity();

        entity.copyMembers(dto);
        assertThat(entity.getId()).isEqualTo(dto.getId());
        assertThat(entity.getName()).isEqualTo(dto.getName());
        assertThat(entity.getMasterTableId()).isEqualTo(dto.getMasterTableId());
        assertThat(entity.getMaster().getId()).isEqualTo(dto.getMaster().getId());
        assertThat(entity.getMaster().getName()).isEqualTo(dto.getMaster().getName());

        entity.getMaster().setId(876L);
        AssertionsForClassTypes.assertThat(entity.getMaster().getId()).isEqualTo(876L);
        AssertionsForClassTypes.assertThat(entity.getMasterTableId()).isEqualTo(876L);

        entity.setMasterTableId(471L);
        AssertionsForClassTypes.assertThat(entity.getMasterTableId()).isEqualTo(471L);
        AssertionsForClassTypes.assertThat(entity.getMaster().getId()).isEqualTo(471L);
    }

    @Test
    public void referEntity2Dto() {
        ReferEntity entity = new ReferEntity(300L, "referEntity", 400L, new MasterTable(400L, "master"));
        ReferDto dto = new ReferDto();

        dto.copyMembers(entity);
        assertThat(dto.getId()).isEqualTo(entity.getId());
        assertThat(dto.getName()).isEqualTo(entity.getName());
        assertThat(dto.getMasterTableId()).isEqualTo(entity.getMasterTableId());
        assertThat(dto.getMaster().getId()).isEqualTo(entity.getMaster().getId());
        assertThat(dto.getMaster().getName()).isEqualTo(entity.getMaster().getName());

        dto.setMasterTableId(96L);
        AssertionsForClassTypes.assertThat(dto.getMasterTableId()).isEqualTo(96L);
        AssertionsForClassTypes.assertThat(dto.getMaster().getId()).isEqualTo(96L);

        dto.getMaster().setId(154L);
        AssertionsForClassTypes.assertThat(dto.getMaster().getId()).isEqualTo(154L);
        AssertionsForClassTypes.assertThat(dto.getMasterTableId()).isEqualTo(154L);
    }
}

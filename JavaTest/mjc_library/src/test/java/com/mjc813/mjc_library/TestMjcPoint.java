package com.mjc813.mjc_library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMjcPoint {
    @Test
    public void test_MjcPoint() {
        MjcPoint mp = new MjcPoint();
        assertThat(mp.getMarketPoint()).isEqualTo(100);
        assertThat(mp.addPoint(null, 10)).isEqualTo(100);
        assertThat(mp.addPoint(new SampleMarketInfo(), 50)).isEqualTo(150);
        assertThat(mp.subPoint(null, 20)).isEqualTo(150);
        assertThat(mp.subPoint(new SampleMarketInfo(), 20)).isEqualTo(130);
    }
}

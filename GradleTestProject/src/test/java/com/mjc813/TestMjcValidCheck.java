package com.mjc813;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMjcValidCheck {

    MjcValidCheck mvc = new MjcValidCheck();

    @Test
    public void testIsValidPhoneNumber() {
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-39a2-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
    }

    @Test
    public void testIsValidZipNumber() {
        assertThat(mvc.isValidZipNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("41501")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("412H1")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("26836")).isEqualTo(true);
    }

    @Test
    public void testIsValidEmail() {
        assertThat(mvc.isValidEmail(null)).isEqualTo(false);
        assertThat(mvc.isValidEmail("")).isEqualTo(false);
        assertThat(mvc.isValidEmail("abd@google.dqdq")).isEqualTo(false);
        assertThat(mvc.isValidEmail("abd@goo@@gle.dqdq")).isEqualTo(false);
        assertThat(mvc.isValidEmail("abd@google.com")).isEqualTo(true);
    }

}

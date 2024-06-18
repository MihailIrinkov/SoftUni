package org.softuni.mobilele.web;

import org.junit.jupiter.api.Test;
import org.softuni.mobilele.testutils.TestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyRestControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtil testData;

    @Test
    public void testConvert() throws Exception {
        testData.createExchangeRate("EUR", BigDecimal.valueOf(0.54));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/currency/convert")
                .param("target", "EUR")
                .param("amount", "1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency", is("EUR")))
                .andExpect(jsonPath("$.amount", is(540.0)));
    }
}
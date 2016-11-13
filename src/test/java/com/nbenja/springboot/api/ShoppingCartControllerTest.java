package com.nbenja.springboot.api;

import com.nbenja.springboot.repository.ProductRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartControllerTest {

    private MockMvc mockMvc;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductInventoryController subject;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
    }

    @Test
    public void getCart_validCar_returnAllItems() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/home/products").accept("application/vnd.nbenja-v1.1+json")).andDo(print()).andExpect(status().isOk()).andReturn();
        assertThat(mvcResult.getResponse().getStatus(), is(200));
    }
}
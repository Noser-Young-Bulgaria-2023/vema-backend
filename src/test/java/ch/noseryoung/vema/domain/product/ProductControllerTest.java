package ch.noseryoung.vema.domain.product;

import ch.noseryoung.vema.domain.product.dto.ProductMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService service;

    @Mock
    private ProductMapper productMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProductController controller;

    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void testCreate() throws Exception {
        Product product = new Product("321", "Sprite", 3.99f, 5);

        given(service.create(any())).willReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                        .content(objectMapper.writeValueAsString(product)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sprite"));
    }

    @Test
    void testReadAll() throws Exception {
        List<Product> mockedProducts = new ArrayList<>();
        mockedProducts.add(new Product("123", "Coca-Cola", 2.99f, 10));

        when(service.readAll()).thenReturn(mockedProducts);

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json("[{\"id\":\"123\", \"name\": \"Coca-Cola\", \"price\": 2.99, \"amount\": 10}]"));
    }

    @Test
    void testRead() throws Exception {
        Product mockedProduct = new Product("123", "Coca-Cola", 2.99f, 10);

        when(service.read(anyString())).thenReturn(mockedProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("123"));
    }

    @Test
    void testUpdate() throws Exception {
        String json = "{\"id\":\"321\", \"name\": \"Fanta\", \"price\": 3.99, \"amount\": 5}";

        when(service.update(anyString(), any(Product.class))).thenReturn(new Product("321", "Fanta", 3.99f, 5));

        mockMvc.perform(MockMvcRequestBuilders.put("/product/321").content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(json));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/product/321"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

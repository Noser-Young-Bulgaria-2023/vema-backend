package ch.noseryoung.vema.domain.product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @MockBean
    ProductRepository repository;

    @Test
    void testCreate() throws Exception {
        String json = "{\"id\":\"321\", \"name\": \"Sprite\", \"price\": 3.99, \"amount\": 5}";

        when(service.create(any())).thenReturn(new Product("321", "Sprite", 3.99f, 5));

        mockMvc.perform(MockMvcRequestBuilders.post("/product").content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content()
                        .json(json));
    }

    @Test
    void testReadAll() throws Exception {
        List<Product> mockedProducts = new ArrayList<Product>();
        mockedProducts.add(new Product("123", "Coca-Cola", 2.99f, 10));

        when(service.readAll()).thenReturn(mockedProducts);

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content()
                        .json("[{\"id\":\"123\", \"name\": \"Coca-Cola\", \"price\": 2.99, \"amount\": 10}]"));
    }

    @Test
    void testRead() throws Exception {
        Product mockedProduct = new Product("123", "Coca-Cola", 2.99f, 10);
        String json = "{\"id\":\"123\", \"name\": \"Coca-Cola\", \"price\": 2.99, \"amount\": 10}";

        when(service.read(anyString())).thenReturn(mockedProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content()
                        .json(json));
    }

    @Test
    void testUpdate() throws Exception {
        String json = "{\"id\":\"321\", \"name\": \"Fanta\", \"price\": 3.99, \"amount\": 5}";

        when(service.update(anyString(), any(Product.class))).thenReturn(new Product("321", "Fanta", 3.99f, 5));

        mockMvc.perform(MockMvcRequestBuilders.put("/product/321").content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content()
                        .json(json));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/product/321"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

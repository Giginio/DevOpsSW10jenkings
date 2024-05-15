package ch.zhaw.iwi.devops.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(newStuffController.class)
public class NewStuffControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private newStuffController newStuffController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        // Initialize any required setup for the tests
    }

    @Test
    void testGetCar() throws Exception {
        mockMvc.perform(get("/car/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Toyota Yaris TS"));
    }

    @Test
    void testCreateCar() throws Exception {
        Cars car = new Cars(4, "Honda Civic");
        mockMvc.perform(post("/car")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/car/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("Honda Civic"));
    }

    @Test
    void testUpdateCar() throws Exception {
        Cars car = new Cars(2, "Suzuki Swift");
        mockMvc.perform(put("/car/2")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/car/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Suzuki Swift"));
    }

    @Test
    void testDeleteCar() throws Exception {
        mockMvc.perform(delete("/car/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/car/3"))
                .andExpect(status().isNotFound());
    }
}

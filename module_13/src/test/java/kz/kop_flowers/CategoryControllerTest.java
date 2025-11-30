package kz.kop_flowers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.kop_flowers.controller.CategoryController;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllCategories() throws Exception {
        List<CategoryDto> categories = List.of(
                CategoryDto.builder().id(1).name("Present").build(),
                CategoryDto.builder().id(2).name("8March").build()
        );

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/category/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Present"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("8March"));

        verify(categoryService).getAllCategories();
    }

    @Test
    void testCreateCategory() throws Exception {
        CategoryDto inputDto = CategoryDto.builder().name("Present").build();
        CategoryDto categoryDto = CategoryDto.builder().id(1).name("Present").build();

        when(categoryService.createCategory(any(CategoryDto.class))).thenReturn(categoryDto);
        mockMvc.perform(post("/api/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Present"));

        verify(categoryService).createCategory(any(CategoryDto.class));
    }
}
package kz.kop_flowers;


import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.exception.CategoryNotFoundException;
import kz.kop_flowers.repository.CategoryRepository;
import kz.kop_flowers.service.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private FlowerMapper mapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testGetCategoryById(){
        Category category = Category.builder().id(1).name("Present").build();
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));


        Category result = categoryService.getCategoryById(1);

        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Present", result.getName());
    }

    @Test
    public void testGetCategoryByIdNotFound(){
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategoryById(any()));
    }

    @Test
    public void testGetAllCategories(){
        List<Category> categories = List.of(
                Category.builder().id(1).name("Present").build(),
                Category.builder().id(2).name("Other").build()
        );
        List<CategoryDto> categoryDtos = List.of(
                CategoryDto.builder().id(1).name("Present").build(),
                CategoryDto.builder().id(2).name("Other").build()
        );

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        Mockito.when(mapper.fromEntityToDto(categories.get(0))).thenReturn(categoryDtos.get(0));
        Mockito.when(mapper.fromEntityToDto(categories.get(1))).thenReturn(categoryDtos.get(1));


        List<CategoryDto> result = categoryService.getAllCategories();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(1, result.get(0).getId());
    }

    @Test
    public void testGetAllCategoriesEmpty(){
        Mockito.when(categoryRepository.findAll()).thenReturn(Collections.emptyList());
        List<CategoryDto> result = categoryService.getAllCategories();
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void testCreateCategory(){
        CategoryDto inputDto = CategoryDto.builder().name("Present").build();
        Category saved = Category.builder().id(1).name("Present").build();
        CategoryDto categoryDto = CategoryDto.builder().id(1).name("Present").build();

        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(saved);
        Mockito.when(mapper.fromEntityToDto(saved)).thenReturn(categoryDto);


        CategoryDto result = categoryService.createCategory(inputDto);

        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Present", result.getName());
    }



}

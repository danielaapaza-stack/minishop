package com.tecsup.minishop.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tecsup.minishop.dto.ProductRequestDTO;
import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.service.ProductService;

class ProductControllerTest {

    @Test
    void create_conDtoValido_retornaCreatedYProductoGuardado() {
        // Arrange
        ProductService productService = mock(ProductService.class);
        ProductController controller = new ProductController(productService);

        ProductRequestDTO request = new ProductRequestDTO("Teclado", 120.0, 10);
        Product saved = Product.builder()
                .id(1L)
                .name("Teclado")
                .price(120.0)
                .stock(10)
                .build();

        when(productService.save(any(Product.class))).thenReturn(saved);

        // Act
        ResponseEntity<Product> response = controller.create(request);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Teclado", response.getBody().getName());
        verify(productService).save(any(Product.class));
    }
}
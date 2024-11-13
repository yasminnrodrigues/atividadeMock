package com.example.applications;
import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AppTest {

    @InjectMocks
    ProductApplication application;

    @Mock
    ProductService service;

    @Test
    public void SalvarImagemCorretamente() {
        Product produto = any(Product.class);
        application.append(product);
        Mockito.verify(service, Mockito.times(1)).save(product);
    }

    @Test
    public void DeletarImagemCorretamente() {
        Product produto = any(Product.class);
        application.remove(1);
        Mockito.verify(service, Mockito.times(1)).remove((1));
    }

    @Test
    public void AtualizarImagemCorretamente() {
        Product product = new Product(1);
        int productId = 1;
        application.update(1, product);
        Mockito.verify(service, Mockito.times(1)).update((product));
    }
}

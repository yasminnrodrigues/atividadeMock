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
        Product product = new Product(1); // Crie uma instância real do produto
        application.append(product);
        Mockito.verify(service, Mockito.times(1)).save(Mockito.eq(product)); 
    }

    @Test
    public void DeletarImagemCorretamente() {
        int productId = 1; // ID específico
        application.remove(productId);
        Mockito.verify(service, Mockito.times(1)).remove(Mockito.eq(productId)); 
    }

    @Test
    public void AtualizarImagemCorretamente() {
        Product product = new Product(); // Crie uma instância real do produto
        int productId = 1; // ID específico
        application.update(productId, product);
        Mockito.verify(service, Mockito.times(1)).update(Mockito.eq(product)); 
    }
}

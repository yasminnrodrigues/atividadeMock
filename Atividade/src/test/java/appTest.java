import com.example.applications.ProductApplication;
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
public class ProductApplicationTest {
    @InjectMocks
    ProductApplication application;

    @Mock
    ProductService service;

    @Test
    public void SalvarImagemCorretamente() {
        Product produto = any(Product.class);

        application.append(produto);

        Mockito.verify(service, Mockito.times(1)).save(produto);
    }

    @Test
    public void DeletarImagemCorretamente() {
        Product produto = any(Product.class);

        application.remove(1);

        Mockito.verify(service, Mockito.times(1)).remove((1));
    }

    @Test
    public void AtualizarImagemCorretamente() {
        Product produto = any(Product.class);

        application.update(1, produto);

        Mockito.verify(service, Mockito.times(1)).update((produto));
    }
}

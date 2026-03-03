package phattrienungdungvoi2ee.bai4_qlsp.Service;

import phattrienungdungvoi2ee.bai4_qlsp.Model.Product;
import org.springframework.stereotype.Service;
import phattrienungdungvoi2ee.bai4_qlsp.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}

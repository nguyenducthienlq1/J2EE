package phattrienungdungvoi2ee.bai4_qlsp.Controller;

import jakarta.validation.Valid;
import phattrienungdungvoi2ee.bai4_qlsp.Model.Product;
import phattrienungdungvoi2ee.bai4_qlsp.Service.CategoryService;
import phattrienungdungvoi2ee.bai4_qlsp.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/list";
    }
    @GetMapping("/create")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/create";
    }
    @PostMapping("/save")
    public String saveProduct(@Valid Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        // Nếu nhập sai, trả lại form sửa kèm báo lỗi
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product/edit";
        }
        product.setId(id); // Đảm bảo đúng ID đang sửa
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        productService.deleteProductById(id);
        return "redirect:/products"; // Đã thêm 's'
    }
}

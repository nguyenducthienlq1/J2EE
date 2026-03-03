package phattrienungdungvoi2ee.bai4_qlsp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Column(nullable = false, length = 255)
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Max(value = 9999999, message = "Giá sản phẩm không được lớn hơn 9999999")
    @Min(value = 1, message = "Giá phải lớn hơn 0")
    @Column(nullable = false)
    private double price;

    @Length(min = 0, max = 200, message = "tên hình ảnh không vượt quá 200 kí tự")
    @Column(nullable = false, length = 200)
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id" ,nullable = false)
    private Category category;
}

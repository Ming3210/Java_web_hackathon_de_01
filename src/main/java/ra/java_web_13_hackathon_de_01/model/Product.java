package ra.java_web_13_hackathon_de_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private String imageUrl;
    private boolean status;
    private Date createDate;
    private int categoryId;
    private MultipartFile imageFile;
}

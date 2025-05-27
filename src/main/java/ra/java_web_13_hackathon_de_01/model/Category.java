package ra.java_web_13_hackathon_de_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    private int categoryId;

    @NotBlank (message = "Category name cannot be blank")
    private String categoryName;

    private String description;

    private boolean status;
}

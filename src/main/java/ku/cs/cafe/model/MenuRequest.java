//Nachpol Ruangnam 6410406568
package ku.cs.cafe.model;

import lombok.Data;
import java.util.UUID;
@Data
public class MenuRequest {
    private String name;
    private UUID categoryId;
    private String price;
}

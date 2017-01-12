package woods.admin.productmanage.service;

import org.springframework.web.multipart.MultipartFile;
import woods.admin.productmanage.model.FaneraAdding;

/**
 * Created by MagicDeCore on 26.12.2016.
 */
public interface FaneraAddingService {

    void save(FaneraAdding faneraAdding);

    FaneraAdding findByFaneraname(String faneraName);

    String uploadImage(MultipartFile multipartFile, String path);
}

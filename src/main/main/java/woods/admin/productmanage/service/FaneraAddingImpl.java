package woods.admin.productmanage.service;

import org.springframework.web.multipart.MultipartFile;
import woods.admin.productmanage.dao.FaneraAddingDao;
import woods.admin.productmanage.model.FaneraAdding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by MagicDeCore on 26.12.2016.
 */

@Service
public class FaneraAddingImpl implements FaneraAddingService {

    String SAVE_LOCATION ="/Documents/efTech/FaneraDsp/src/main/webapp/resources/assets/images/products";
//            "/Documents/efTech/FaneraDsp/src/main/resources/image";

    @Autowired
    private FaneraAddingDao faneraAddingDao;


    @Override
    public void save(FaneraAdding faneraAdding) {

        faneraAddingDao.save(faneraAdding);

    }

    @Override
    public FaneraAdding findByFaneraname(String faneraName) {
        return faneraAddingDao.findByFaneraName(faneraName);
    }


    @Override
    public String uploadImage(MultipartFile multipartFile, String path) {

        String fileName = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION+path+"/";
        File pathFile = new File(location);
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        pathFile = new File(location + fileName);
        try {
            multipartFile.transferTo(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path + File.separator + multipartFile.getOriginalFilename();

    }

}

package woods.admin.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import woods.admin.productmanage.model.FaneraAdding;
import woods.admin.productmanage.model.FaneraBean;
import woods.admin.productmanage.service.FaneraAddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


/**
 * Created by MagicDeCore on 26.12.2016.
 */

@Controller
public class FaneraAddingController {



    @Autowired
    private FaneraAddingService faneraAddingService;

    @RequestMapping(value = "/addfanera", method = RequestMethod.GET)
    public String addfanera(Model model){
        model.addAttribute("faneraForm", new FaneraBean());

        return "addfanera";
    }

    @RequestMapping(value = "/addfanera", method = RequestMethod.POST)
    public String createfanera(@ModelAttribute("faneraForm")FaneraBean faneraBean, @RequestParam("image") MultipartFile file, BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors()){
            System.out.println("FAaaaaanera addding ERRRROOOR");
            return "redirect:/welcome";
        }

        String filePath = faneraAddingService.uploadImage(file, "/fanera/" + faneraBean.getFaneraName());
        FaneraAdding faneraAdding = new FaneraAdding();
        faneraAdding.setFaneraName(faneraBean.getFaneraName());
        faneraAdding.setSizeFormat(faneraBean.getSizeFormat());
        faneraAdding.setDepth(faneraBean.getDepth());
        faneraAdding.setTreatment(faneraBean.getTreatment());
        faneraAdding.setWater_resistance(faneraBean.getWater_resistance());
        faneraAdding.setWetness(faneraBean.getWetness());
        faneraAdding.setMaterial(faneraBean.getMaterial());
        faneraAdding.setDescription(faneraBean.getDescription());
        faneraAdding.setPrice(faneraBean.getPrice());
        faneraAdding.setImage(filePath);

        faneraAddingService.save(faneraAdding);

        return "redirect:/welcome";
    }


//    @RequestMapping (value = "/uploadfanerapic", method = RequestMethod.POST)
//    @ResponseBody
//    public String uploadFaneraPic(@RequestParam("image") MultipartFile file){
//
//        saveImage(file, "image");
//
//        return "redirect:/welcome";
//    }


}

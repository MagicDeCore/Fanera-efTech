package woods.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import woods.phone.fanera.Fanera;
import woods.phone.fanera.FaneraJDBCTemplate;
import woods.phone.fanera.SelectFanera;
import woods.phone.iphone.Iphone;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by MagicDeCore on 01.12.2016.
 */

@Controller
public class ControllerFanera {

    @Autowired
    FaneraJDBCTemplate faneraJDBCTemplate;


    @RequestMapping(value = "/fanera", method = RequestMethod.GET)   // /iphones
    public ModelAndView mcf(HttpSession session) {
        ModelAndView mvfanera = new ModelAndView("ru_fanera_all");

        int shlef = 0;
        int noShlef = 0;
        String sort = "n";
        String depth = "n";
        int page_nomber = 1;

        try {

            shlef = (int) session.getAttribute("shlef");
            noShlef = (int) session.getAttribute("noShlef");
            sort = (String) session.getAttribute("sort");
            depth = (String) session.getAttribute("depth");
            page_nomber = (int) session.getAttribute("page_nomber");


        } catch (Exception e) {
        }

        String page;
        try {
            page = (String) session.getAttribute("page");
        } catch (Exception e) {
            page = "index";
        }

        SelectFanera select = new SelectFanera();

        select.setShlef(shlef);
        select.setNoShlef((noShlef));
        select.setSortFanera(sort);
        select.setDepthFanera(depth);


        List<Fanera> listFanera = faneraJDBCTemplate.listFanera(select, page_nomber);


        mvfanera.addObject("listFanera", listFanera);

        session.setAttribute("page", "faneras");
        return mvfanera;
    }


    @RequestMapping(value = "/fanera-{id}", method = RequestMethod.GET)
    public ModelAndView fanira(@PathVariable("id") int id, HttpSession session) {

        ModelAndView mv = new ModelAndView("ru_one_fanera");
        Fanera fanera = faneraJDBCTemplate.getFanera(id);
        mv.addObject("fanera", fanera);
        session.setAttribute("page", "fanera-" + id);

        return mv;
    }


    @RequestMapping(value = "/fanera_select", method = RequestMethod.GET)
    public String vmc_select(
//                 @RequestParam(value = "page") String page,
            @RequestParam(value = "shlef", defaultValue = "0") int shlef,
            @RequestParam(value = "noShlef", defaultValue = "0") int noShlef,

            @RequestParam(value = "sort", defaultValue = "n") String sort,
            @RequestParam(value = "depth", defaultValue = "n") String depth,
            HttpSession session
    ) {

        session.setAttribute("shlef", shlef);
        session.setAttribute("noShlef", noShlef);

        session.setAttribute("sort", sort);
        session.setAttribute("depth", depth);
        session.setAttribute("page_nomber", 1);

        return "redirect:/fanera.htm";
    }
}

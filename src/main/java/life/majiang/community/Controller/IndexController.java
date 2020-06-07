package life.majiang.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ljt
 * @create 2020-06-07-9:17
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index";

    }

}

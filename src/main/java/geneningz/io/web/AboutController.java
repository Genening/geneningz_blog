package geneningz.io.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        System.out.println("-----about-----");
        return "about";
    }
}

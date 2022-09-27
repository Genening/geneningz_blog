package geneningz.io.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogController {
    
    @GetMapping(value = "/blog")
    public String blog(String name, Integer id){
        System.out.println("name: " + name);
        System.out.println("id: " + id);

        System.out.println("-----index-----");

        return "blog";
    }
}

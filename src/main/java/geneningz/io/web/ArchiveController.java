package geneningz.io.web;

import geneningz.io.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ArchiveController {

    @Autowired
    private BlogService blogService;
    
    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archivesMap", blogService.archivesBlog());
        model.addAttribute("blogCount", blogService.countBlog());

        System.out.println("-----archives-----");

        return "archives";
    }
}

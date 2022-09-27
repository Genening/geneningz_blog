package geneningz.io.web;

import geneningz.io.po.Tag;
import geneningz.io.service.BlogService;
import geneningz.io.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;
    
    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                           @PathVariable Long id, Pageable pageable, Model model){

        List<Tag> tagList = tagService.listTagTop(10000);
        if (id == -1){
            id = tagList.get(0).getId();
        }
        model.addAttribute("tags", tagList);
        model.addAttribute("page", blogService.listBlog(pageable, id));
        model.addAttribute("activeTagId", id);
        System.out.println("-----index-----");

        return "tags";
    }

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                      Pageable pageable, Model model){

        List<Tag> tagList = tagService.listTagTop(10000);
        Long id = tagList.get(0).getId();
        model.addAttribute("tags", tagList);
        model.addAttribute("page", blogService.listBlog(pageable, id));
        model.addAttribute("activeTagId", id);
        System.out.println("-----index-----");

        return "tags";
    }
}

package geneningz.io.web;

import geneningz.io.po.Type;
import geneningz.io.service.BlogService;
import geneningz.io.service.TypeService;
import geneningz.io.vo.BlogQuery;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
            @PathVariable Long id, Pageable pageable, Model model){

        List<Type> typeList = typeService.listTypeTop(10000);
        if (id == -1){
            id = typeList.get(0).getId();
        }

        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types", typeList);
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        model.addAttribute("activeTypeId", id);
        System.out.println("-----index-----");

        return "types";
    }

    @GetMapping("/types")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                           Pageable pageable, Model model){

        List<Type> typeList = typeService.listTypeTop(10000);
        Long id = typeList.get(0).getId();


        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types", typeList);
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        model.addAttribute("activeTypeId", id);
        System.out.println("-----index-----");

        return "types";
    }


}

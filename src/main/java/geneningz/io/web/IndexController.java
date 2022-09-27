package geneningz.io.web;

import geneningz.io.po.Comment;
import geneningz.io.po.User;
import geneningz.io.service.BlogService;
import geneningz.io.service.CommentService;
import geneningz.io.service.TagService;
import geneningz.io.service.TypeService;
import geneningz.io.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                            Pageable pageable, Model model){
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6)); // temporary value 6
        model.addAttribute("tags", tagService.listTagTop(10)); // temporary value 10
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));

        System.out.println("-----index-----");

        return "index";
    }

    @GetMapping("/index")
    public String index2(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6)); // temporary value 6
        model.addAttribute("tags", tagService.listTagTop(10)); // temporary value 10
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));

        System.out.println("-----index-----");

        return "index";
    }

    // search blog in web
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                         Pageable pageable, Model model,@RequestParam String query){
        model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));
        model.addAttribute("query",query);

        return "search";
    }

    @GetMapping("blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        List<Comment> commentList = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", commentList);
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));

        return "_fragments :: newblogList";
    }

}

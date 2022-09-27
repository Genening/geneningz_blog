package geneningz.io.web.admin;

import geneningz.io.po.Tag;
import geneningz.io.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Geneningz ZHANG on 9/20/2022.
 */
@Controller
@RequestMapping("/admin")
public class AdminTagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){

        model.addAttribute("page", tagService.listTag(pageable));

        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag", new Tag());

        return "admin/tags-input";
    }

//    编辑跳转
    @GetMapping("/tags/{id}/input")
    public String editGet(Tag tag, @PathVariable Long id, Model model){

        Tag tag1 = tagService.getTag(id);
        model.addAttribute(tag1);

        return "admin/tags-input";
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){

        Tag tag2 = tagService.getTagByName(tag.getName());
        if (tag2 != null){
            result.rejectValue("name", "nameError", "不能重复添加标签");
        }


        if (result.hasErrors()){
            return "admin/tags-input";
        }

        Tag tag1 = tagService.updateTag(id, tag);
        if (tag1 == null){
            attributes.addFlashAttribute("message", "更新失败");
        }else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }

//    新增数据
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){

        Tag tag2 = tagService.getTagByName(tag.getName());
        if (tag2 != null){
            result.rejectValue("name", "nameError", "不能重复添加标签");
        }


        if (result.hasErrors()){
            return "admin/tags-input";
        }

        Tag tag1 = tagService.saveTag(tag);
        if (tag1 == null){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }

//    删除数据
    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");

        return "redirect:/admin/tags";
    }
}

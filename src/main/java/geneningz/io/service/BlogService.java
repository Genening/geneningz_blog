package geneningz.io.service;

import geneningz.io.po.Blog;
import geneningz.io.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Geneningz ZHANG on 9/20/2022.
 */
@Service
public interface BlogService {

    Blog saveBlog(Blog blog);

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Pageable pageable, Long tagId);

    Page<Blog> listBlog(String query, Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String, List<Blog>> archivesBlog();

    Long countBlog();

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}

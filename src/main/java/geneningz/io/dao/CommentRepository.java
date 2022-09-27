package geneningz.io.dao;

import geneningz.io.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Geneningz ZHANG on 9/26/2022.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogId(Long blogId, Sort sort);
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}

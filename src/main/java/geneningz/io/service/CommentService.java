package geneningz.io.service;

import geneningz.io.po.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Geneningz ZHANG on 9/26/2022.
 */
@Service
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}

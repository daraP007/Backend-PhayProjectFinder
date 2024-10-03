package devDara.phayStudyBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devDara.phayStudyBackend.model.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
    Comment findById(int id);
    List<Comment> findAllByProjectId(int projectId);
} 

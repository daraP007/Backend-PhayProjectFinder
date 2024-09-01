package devDara.phayStudyBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devDara.phayStudyBackend.model.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {

    Comment findById(int id);

    
} 

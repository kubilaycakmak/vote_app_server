package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);
}

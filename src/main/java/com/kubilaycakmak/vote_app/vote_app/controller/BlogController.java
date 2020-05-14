package com.kubilaycakmak.vote_app.vote_app.controller;

import com.kubilaycakmak.vote_app.vote_app.model.Blog;
import com.kubilaycakmak.vote_app.vote_app.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    BlogRepo blogRepo;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRepo.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRepo.findById(blogId).get();
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRepo.save(new Blog(title, content));
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);

        Blog blog = blogRepo.findById(blogId).get();
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepo.save(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRepo.deleteById(blogId);
        return true;
    }


}

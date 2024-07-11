package com.luancastelhano.workshopmongo.resources;

import com.luancastelhano.workshopmongo.domain.Post;
import com.luancastelhano.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    // Annotation @PathVariable para indicar que o id passado como parâmetro deve casar com o id passado na URI
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

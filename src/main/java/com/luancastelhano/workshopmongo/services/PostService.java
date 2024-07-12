package com.luancastelhano.workshopmongo.services;

import com.luancastelhano.workshopmongo.domain.Post;
import com.luancastelhano.workshopmongo.repository.PostRepository;
import com.luancastelhano.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        // Retorna o objeto(usuário) com o id providenciado, caso tal não exista, é lançada a exceção customizada
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found"));

    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}

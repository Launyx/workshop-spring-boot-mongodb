package com.luancastelhano.workshopmongo.repository;

import com.luancastelhano.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query method para buscar um "Title" (nome do atributo desejado), que contenha o texto passado como parâmetro
    // Ignore case para ignorar diferença entre letras maiúsculas e minúsculas
    List<Post> findByTitleContainingIgnoreCase(String text);
}

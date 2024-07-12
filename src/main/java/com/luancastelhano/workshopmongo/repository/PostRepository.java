package com.luancastelhano.workshopmongo.repository;

import com.luancastelhano.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // "?0" indica o comando jSON que o primeiro parâmetro do método será utilizado
    @Query("{ title: { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // Query method para buscar um "Title" (nome do atributo desejado), que contenha o texto passado como parâmetro
    // Ignore case para ignorar diferença entre letras maiúsculas e minúsculas
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxData);
}

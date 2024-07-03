package com.luancastelhano.workshopmongo.services;

import com.luancastelhano.workshopmongo.domain.User;
import com.luancastelhano.workshopmongo.dto.UserDTO;
import com.luancastelhano.workshopmongo.repository.UserRepository;

import com.luancastelhano.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        // Retorna o objeto(usuário) com o id providenciado, caso tal não exista, é lançada a exceção customizada
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

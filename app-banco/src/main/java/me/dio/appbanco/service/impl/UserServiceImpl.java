package me.dio.appbanco.service.impl;

import me.dio.appbanco.domain.model.User;
import me.dio.appbanco.domain.repository.UserRepository;
import me.dio.appbanco.service.UserService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;


/*implementação da camada de serviço*/
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    método que implementa o findById do JPA, e caso não encontre o Id passado como parâmetro, lança a exceção
    NoSuchElementException
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /*
    método que inicialmente faz uma verificação se o User já existe, através do método
    instanciado manualmente 'existsByAccountNumber' onde ele busca o usuário por número da conta
    e este método retorna uma exceção IllegalArgumentException caso o usuário já exista no banco de dados.
    caso o usuário não exista, o mesmo é salvo no banco de dados.
     */
    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}

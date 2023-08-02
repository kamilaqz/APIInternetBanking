package me.dio.appbanco.service;

import me.dio.appbanco.domain.model.User;

/*camada de serviço do User*/
public interface UserService {

    /*
    método de retorno de um User passando como parâmetro o ID
     */
    User findById(Long id);

    /*
    método de criação de um novo usuário na tabela através do objeto User
     */
    User create(User userToCreate);
}

package me.dio.appbanco.controller;

import me.dio.appbanco.domain.model.User;
import me.dio.appbanco.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

/*classe de controle REST*/
@RestController
@RequestMapping("/users")
public class UserRESTController {

    private final UserService userService;

    public UserRESTController(UserService userService) {
        this.userService = userService;
    }

    /*criação do endpoint HTTp 'GET' que recebe o Id como parametro
    e retorna o objeto User
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    /*criação do endpoint HTTp 'POST' para criação de um novo usuário através do objeto passado no
    'RequestBody'. o método também retorna a localização URI do Id do usuário em questão.
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}

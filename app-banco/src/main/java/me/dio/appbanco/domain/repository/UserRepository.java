package me.dio.appbanco.domain.repository;

import me.dio.appbanco.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*repositório JPA*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

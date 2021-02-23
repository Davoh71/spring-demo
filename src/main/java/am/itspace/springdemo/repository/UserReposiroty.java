package am.itspace.springdemo.repository;

import am.itspace.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User,Integer> {



}

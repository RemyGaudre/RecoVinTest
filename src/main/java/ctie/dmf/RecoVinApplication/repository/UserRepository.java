package ctie.dmf.RecoVinApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ctie.dmf.RecoVinApplication.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
}

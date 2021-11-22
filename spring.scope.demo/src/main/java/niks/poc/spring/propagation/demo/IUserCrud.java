package niks.poc.spring.propagation.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import niks.poc.spring.scope.demo.entities.UserDetail;

@Repository("userDao")
public interface IUserCrud extends JpaRepository<UserDetail, Integer>{

}

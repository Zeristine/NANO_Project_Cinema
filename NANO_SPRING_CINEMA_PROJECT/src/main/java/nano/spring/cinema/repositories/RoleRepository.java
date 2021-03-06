/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HaAnh
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("Select r From Role r Where r.name = ?1")
    List<Role> findByName(String name);

}

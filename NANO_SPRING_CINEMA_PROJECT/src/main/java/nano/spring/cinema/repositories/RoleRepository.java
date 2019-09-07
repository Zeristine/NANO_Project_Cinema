/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import nano.spring.cinema.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HaAnh
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}

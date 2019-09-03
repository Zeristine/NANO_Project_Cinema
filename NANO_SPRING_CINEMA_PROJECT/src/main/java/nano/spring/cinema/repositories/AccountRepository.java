/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    
    @Query("Select a From Account a where a.username = ?1 and a.password = ?2")
    Account findByUsernameAndPassword(String username, String password);
    
    @Query("Select a From Account a where a.username = ?1")
    List<Account> findByUsername(String username);
    
}

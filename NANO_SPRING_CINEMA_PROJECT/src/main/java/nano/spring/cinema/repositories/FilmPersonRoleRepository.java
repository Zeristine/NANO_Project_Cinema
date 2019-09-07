/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.FilmPersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface FilmPersonRoleRepository extends JpaRepository<FilmPersonRole, Long> {

    @Query("Select fpr From FilmPersonRole fpr Where fpr.person.name = ?1")
    List<FilmPersonRole> findByPersonName(String name);
}

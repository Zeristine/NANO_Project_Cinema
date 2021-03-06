/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {

    @Query("Select st From ShowTime st Where st.film.id = ?1")
    List<ShowTime> findByFilmId(long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.Date;
import java.util.List;
import nano.spring.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select f from Film f where f.fromDate <= :currentDate and :currentDate <= f.toDate")
    public List<Film> findCurrentFilms(@Param(value = "currentDate") Date currentDate);
    
    @Query("select f from Film f where f.fromDate > :currentDate")
    public List<Film> findToBeOutFilms(@Param(value = "currentDate") Date currentDate);
    
    @Query("select f from Film f where f.name like %:name%")
    public List<Film> findFilmsByName(@Param(value = "name") String name);
}

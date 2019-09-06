/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.OrderFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HaAnh
 */
public interface OrderFilmRepository extends JpaRepository<OrderFilm, Long> {
    @Query("select o from OrderFilm o where o.account.id = ?1")
    public List<OrderFilm> findByAccountId(Long accountId);
}

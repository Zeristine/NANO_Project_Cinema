/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.util.List;
import nano.spring.cinema.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HaAnh
 */
public interface PointRepository extends JpaRepository<Point, Long> {
    
    @Query("select sum(p.numberOfPoint) from Point p where p.account.id = :accountId")
    public Integer getTotalPointByAccountId(@Param("accountId") long accountId);
    
    @Query("select p from Point p where p.account.id = :accountId "
            + "and (p.ticket.order.status = 1 "
            + "or p.ticket.order.status = 0 "
            + "or p.ticket.order.status is null)")
    public List<Point> findPointsEarnedByAccountId(@Param("accountId") long accountId);    
}

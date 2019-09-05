/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.repositories;

import java.io.Serializable;
import nano.spring.cinema.entities.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author admin
 */
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    
}

package com.example.daymate.repository;


import com.example.daymate.domain.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query(value = " SELECT * " +
                   " FROM EVENTS " +
                   " WHERE DELETED_AT IS NULL " +
                   "   AND EVENT_AT = :eventAt " +
                   " ORDER BY CREATED_AT DESC ",
           nativeQuery = true)
    List<Events> selectListsOrderByCreatedAt(String eventAt);

    @Modifying
    @Query(value = " UPDATE EVENTS " +
                   " SET DELETED_AT = TO_CHAR(SYSDATE(), 'yyyymmddhh24miss') " +
                   " WHERE EVENT_ID = :eventId ",
           nativeQuery = true)
    void updateEventDeletedAt(Integer eventId);

}
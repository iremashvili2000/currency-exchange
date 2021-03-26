package com.example.demo.repository;

import com.example.demo.model.response.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {

        @Query("select e from Exchange as e where e.cur_code=:cur_code")
        Optional<Exchange> getCurrencyCode(@Param("cur_code") String cur_code);
}

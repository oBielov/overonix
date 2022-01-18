package com.test.overonix.repository;

import com.test.overonix.model.CurrencyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyHistory, Long> {
    List<CurrencyHistory> findAllByIdIn(Set<Long> list);
}

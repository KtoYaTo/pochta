package ru.com.first.pochta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.com.first.pochta.model.Parsels;

@Repository
public interface CouriersRepository extends JpaRepository<Parsels, Long>{

}
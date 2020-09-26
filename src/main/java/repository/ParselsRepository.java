package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Parsels;

@Repository
public interface ParselsRepository extends JpaRepository<Parsels, Long>{

}
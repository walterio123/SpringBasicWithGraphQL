package com.walterio12345.springbasicwithgraphql.repository;

import com.walterio12345.springbasicwithgraphql.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface FilmRepository extends JpaRepository<Film,Integer> {

}

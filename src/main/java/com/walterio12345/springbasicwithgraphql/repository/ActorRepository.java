package com.walterio12345.springbasicwithgraphql.repository;

import com.walterio12345.springbasicwithgraphql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    public Actor findActorByFirstNameLike(String name);
}

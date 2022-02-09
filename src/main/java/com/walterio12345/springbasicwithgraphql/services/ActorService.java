package com.walterio12345.springbasicwithgraphql.services;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.walterio12345.springbasicwithgraphql.entity.Actor;
import com.walterio12345.springbasicwithgraphql.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements GraphQLQueryResolver {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor>   getAllActors(){

        return actorRepository.findAll();
    }
    private Actor getActorById(Integer id){
        if(actorRepository.findById(id).isPresent()){
            return  actorRepository.findById(id).get();
        }else{
            return null;
        }

    }
    public Actor getActorByNameLike(String name){
        return actorRepository.findActorByFirstNameLike(name);
    }
    public Integer actorCount(){
        return actorRepository.findAll().size();
    }

}

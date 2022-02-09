package com.walterio12345.springbasicwithgraphql.services;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.walterio12345.springbasicwithgraphql.entity.Actor;
import com.walterio12345.springbasicwithgraphql.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver {
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

    @Transactional
    public Actor updateAddress( Integer id,String address){
        Actor actor=actorRepository.findById(id).get();
        actor.setAddress(address);
        return actor;
    }
}

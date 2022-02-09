package com.walterio12345.springbasicwithgraphql.services;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.walterio12345.springbasicwithgraphql.entity.Actor;
import com.walterio12345.springbasicwithgraphql.entity.Film;
import com.walterio12345.springbasicwithgraphql.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FilmResolver implements GraphQLResolver<Actor> {
    @Autowired
    private FilmRepository filmRepository;

    @Transactional
    public Film getFilm(Actor actor){
        return filmRepository.findById(actor.getFilmId()).get();
    }
}

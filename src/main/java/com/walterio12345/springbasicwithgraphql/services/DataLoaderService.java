package com.walterio12345.springbasicwithgraphql.services;

import com.walterio12345.springbasicwithgraphql.entity.Actor;
import com.walterio12345.springbasicwithgraphql.entity.Film;
import com.walterio12345.springbasicwithgraphql.repository.ActorRepository;
import com.walterio12345.springbasicwithgraphql.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DataLoaderService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ActorRepository actorRepository;

    @PostConstruct
    public void loadData(){
        String [] actors = {"Leonardo DiCaprio","Morgan Freeman","Clint Eastwood","Hilary Swank"};
        Map<String,String> films = new HashMap<String, String>(){
            {
                put("Leonardo DiCaprio","Kuch Kuch Hota Hai");
                put("Morgan Freeman","Dabang");
                put("Clint Eastwood","Dangal");
                put("Hilary Swank","Sholey");
            }
        };
        for (String actorName :actors){
            String [] names = actorName.split(" ");

            Date dateOfBirth = DataLoaderService.between(new Date(10,01,01),new Date(1980,01,01));
            Date dateOfLaunch = DataLoaderService.between(new Date(1990,01,01),new Date(2000,01,01));
            Film film = new Film(films.get(actorName),dateOfLaunch);
            filmRepository.save(film);
            Actor actor = new Actor(names[0],names[1],dateOfBirth,"Hollywood",film.getFilmId());
            actorRepository.save(actor);

        }


    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}

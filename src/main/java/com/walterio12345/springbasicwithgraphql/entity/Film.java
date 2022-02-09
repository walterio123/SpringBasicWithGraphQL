package com.walterio12345.springbasicwithgraphql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private Integer filmId;

    private String name;

    private Date lauchYear;

    public Film(String name, Date lauchYear) {
        this.name = name;
        this.lauchYear = lauchYear;
    }

    public Film() {
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLauchYear() {
        return lauchYear;
    }

    public void setLauchYear(Date lauchYear) {
        this.lauchYear = lauchYear;
    }
}

package com.tritonik.telebot.repository;


import com.tritonik.telebot.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Long> {
    List<Joke> findTop5ByOrderByCountCallDesc();

    @Query("SELECT j FROM joke1 j ORDER BY RANDOM() LIMIT 1")
    Joke findRandomJoke();

}

package com.tritonik.telebot.service;

import com.tritonik.telebot.model.Joke;

import java.util.List;
import java.util.Optional;

public interface JokeService {
    void addJoke(Joke joke);
    List<Joke> getAllJokes();
    Optional<Joke> getJokeById(Long id);
    Optional<Joke> putJokeById(Long id, Joke updatedJoke);
    void deleteJokeById(Long id);
    List<Joke> getTopFiveJokes();
    Joke getRandomJoke();


}

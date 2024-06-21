package com.tritonik.telebot.service;


import com.tritonik.telebot.model.Joke;
import com.tritonik.telebot.repository.JokeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class JokeServiceImpl implements JokeService{
    @Autowired
    private final JokeRepository jokeRepository;

    @Override
    public void addJoke(Joke joke) {
        jokeRepository.save(joke);

    }

    @Override
    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }

    @Override
    public Optional<Joke> getJokeById(Long id) {
        return jokeRepository.findById(id);
    }

    @Override
    public Optional<Joke> putJokeById(Long id, Joke updatedJoke) {
        Optional<Joke> existingJoke = jokeRepository.findById(id);
        if (existingJoke.isPresent()) {
            Joke jokeToUpdate = existingJoke.get();
            jokeToUpdate.setTextJoke(updatedJoke.getTextJoke());
            jokeRepository.save(jokeToUpdate);
        }
        return existingJoke;
    }
    @Override
    public void deleteJokeById(Long id) {
        jokeRepository.deleteById(id);
    }

    @Override
    public Joke getRandomJoke() {
        return jokeRepository.findRandomJoke();
    }

    @Override
    public List<Joke> getTopFiveJokes() {
        return jokeRepository.findTop5ByOrderByCountCallDesc();
    }
}

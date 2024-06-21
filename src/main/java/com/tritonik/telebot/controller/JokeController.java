package com.tritonik.telebot.controller;


import com.tritonik.telebot.model.Joke;
import com.tritonik.telebot.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joke")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @PostMapping
    ResponseEntity<Void> addJoke(@RequestBody Joke jokeModel){
        jokeService.addJoke(jokeModel);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Joke>> getAllJoke(){
        return ResponseEntity.ok(jokeService.getAllJokes());

    }


    @GetMapping("/{id}")
    ResponseEntity<Joke> getJokeById(@PathVariable Long id){
        Optional<Joke> jokeOptional = jokeService.getJokeById(id);
        return jokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Joke> updateJokeById(@PathVariable Long id, @RequestBody Joke updatedJoke) {
        Optional<Joke> updatedJokeOptional = jokeService.putJokeById(id, updatedJoke);
        return updatedJokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id){
        jokeService.deleteJokeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top5")
    ResponseEntity<List<Joke>> getTopFiveJokes() {
        return ResponseEntity.ok(jokeService.getTopFiveJokes());
    }
}
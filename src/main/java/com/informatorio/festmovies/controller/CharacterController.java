package com.informatorio.festmovies.controller;


import com.informatorio.festmovies.dto.CharacterDTO;
import com.informatorio.festmovies.exception.ExistException;
import com.informatorio.festmovies.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<?> addCharacter(@Valid @RequestBody CharacterDTO characterDTO)
            throws ExistException {
        return new ResponseEntity<>(characterService.addCharacter(characterDTO), HttpStatus.CREATED);
    }
}

package com.devsuperior.demo.controller;


import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.service.CityService;
import com.devsuperior.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private EventRepository repository;


    @PutMapping("/{id}" )
    public ResponseEntity<EventDTO> update(@RequestBody  EventDTO dto, @PathVariable Long id ) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        EventDTO eventDTO = service.update(dto, id);
        return ResponseEntity.ok(eventDTO);

    }


}

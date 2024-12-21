package com.devsuperior.demo.service;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

     @Autowired
    private EventRepository eventRepository;


     public EventDTO update(EventDTO eventDTO, Long id) {
         Event event = eventRepository.getReferenceById(id);
         event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
        event.setCity(new City(eventDTO.getCityId(),null));
        eventRepository.save(event);
        return new EventDTO(event);

     }



}

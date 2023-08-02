package de.ait.hw.controllers;

import de.ait.hw.controllers.api.EventsApi;
import de.ait.hw.dto.eventsDtos.EventDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.eventsDtos.NewEventDto;
import de.ait.hw.dto.eventsDtos.UpdateEventDto;
import de.ait.hw.models.Event;
import de.ait.hw.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;



    public EventDto addEvent( NewEventDto newEvent){


        return eventsService.addEvent(newEvent);

    }

    public EventsDto showAllEvents(){
        return eventsService.showAllEvents();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        return eventsService.deleteEvent(eventId);
    }


    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return eventsService.updateEvent(eventId, updateEvent);
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return eventsService.getEvent(eventId);
    }


}

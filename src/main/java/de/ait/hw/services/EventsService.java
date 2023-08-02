package de.ait.hw.services;

import de.ait.hw.dto.eventsDtos.EventDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.eventsDtos.NewEventDto;
import de.ait.hw.dto.eventsDtos.UpdateEventDto;
import de.ait.hw.models.Event;

import java.util.List;

public interface EventsService {

     EventDto addEvent(NewEventDto event);

     EventsDto showAllEvents();

     EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);

    EventDto getEvent(Long eventId);
}

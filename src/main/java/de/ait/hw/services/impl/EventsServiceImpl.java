package de.ait.hw.services.impl;

import de.ait.hw.dto.eventsDtos.EventDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.eventsDtos.NewEventDto;
import de.ait.hw.dto.eventsDtos.UpdateEventDto;
import de.ait.hw.dto.usersDtos.UserDto;
import de.ait.hw.dto.usersDtos.UsersDto;
import de.ait.hw.exceptions.NotFoundException;
import de.ait.hw.models.Event;
import de.ait.hw.models.User;
import de.ait.hw.repositories.EventsRepository;
import de.ait.hw.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.hw.dto.eventsDtos.EventDto.from;


@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .description(newEvent.getDescription())
                .date(newEvent.getDate())
                .build();

        eventsRepository.save(event);
        return from(event);
    }

    @Override
    public EventsDto showAllEvents() {
        List<Event> events = eventsRepository.findAll();

        return EventsDto.builder()
                .events(EventDto.from(events))
                .count(events.size())
                .build();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        Event event = eventsRepository.findById(eventId).orElseThrow(() ->
        new NotFoundException("Event with id<" + eventId + ">not found"));

        eventsRepository.delete(event);
        return from(event);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        Event event = getEventORThrow(eventId);

        event.setDescription(updateEvent.getNewDescription());
        event.setDate(updateEvent.getNewDate());
        eventsRepository.save(event);
        return from(event);
    }

    public EventDto getEvent(Long eventId) {
        return from(getEventORThrow(eventId));
    }

    private Event getEventORThrow(Long eventId) {
        Event event = eventsRepository.findById(eventId).orElseThrow(() ->
                    new NotFoundException("Event with id <" + eventId +"> not found"));
        return event;
    }
}

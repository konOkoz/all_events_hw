package de.ait.hw.repositories.impl;

import de.ait.hw.models.Event;
import de.ait.hw.repositories.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EventsRepositoryListImpl implements EventsRepository {


    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event){

        if(event.getId() == null) {
            event.setId((long) events.size() + 1);
            events.add(event);
        } else {

        }
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        for(Event event: events){
            if(event.getId().equals(id))
                return Optional.of(event);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Event event) {
        events.remove(event);
    }

    @Override
    public void clear(){
        events.clear();
    }


}




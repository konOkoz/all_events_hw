package de.ait.hw.controllers.api;

import de.ait.hw.dto.eventsDtos.EventDto;
import de.ait.hw.dto.eventsDtos.EventsDto;
import de.ait.hw.dto.eventsDtos.NewEventDto;
import de.ait.hw.dto.eventsDtos.UpdateEventDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Events")
})
@RequestMapping("/api/events")
public interface EventsApi {

    @Operation(summary = "Creating event", description = "Allowed only for ADMIN")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventDto addEvent(@RequestBody NewEventDto newEvent);

    @Operation(summary = "Showing all events", description = "Allowed for everyone")
    @GetMapping()
    EventsDto showAllEvents();

    @Operation(summary = "Delete event", description = "Allow only for ADMIN")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "404", description = "Event not Found",
            content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "Deleted event",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
            })
    })

    @DeleteMapping("/{event-id}")
    EventDto deleteEvent(@Parameter(required = true, description = "Events ID", example = "2")@PathVariable("event-id") Long eventId);


    @Operation(summary = "Обновление события", description = "Доступно администратору")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Событие не найдено",
        content = {
                @Content()
        }),
        @ApiResponse(responseCode = "200", description = "Обновленное событие",
        content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
        })
    })
    @PutMapping("/{event-id}")
    EventDto updateEvent(@Parameter(required = true, description = "Идентификатор события",example = "1")
                        @PathVariable("event-id") Long eventId,
                         @RequestBody UpdateEventDto updateEvent);


    @Operation(summary = "Получение события", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Событие не найдено",
            content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "Обновленное событие",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
            })
    })
    @GetMapping("/{event-id}")
    EventDto getEvent(@Parameter(required = true, description = "Идентификатор события", example = "1")
                      @PathVariable("event-id") Long eventId);



}


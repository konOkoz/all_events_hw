package de.ait.hw.dto.eventsDtos;

import de.ait.hw.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Event")
public class EventDto {

    @Schema(description = "Event ID", example = "1")
    private Long id;

    @Schema(description = "Description of event", example = "Wedding")
    private String description;

    @Schema(description = "Date of event", example = "2023.10.29")
    private String date;




    public static EventDto from(Event event){
        return EventDto.builder()
                .id(event.getId())
                .description(event.getDescription())
                .date(event.getDate())
                .build();
    }
    public static List<EventDto> from(List<Event> events){
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }
}

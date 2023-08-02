package de.ait.hw.dto.eventsDtos;

import de.ait.hw.dto.articlesDto.UserInArticleDto;
import de.ait.hw.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Events list")
public class EventsDto{
    @Schema(description = "All events")
    public List<EventDto> events;

    @Schema(description = "Total count of all events", example = "1")
    private Integer count;

}

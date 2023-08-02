package de.ait.hw.dto.eventsDtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Information to adding an event")
public class NewEventDto {
    @Schema(description = "Description of event", example = "Wedding")
    private String description;

    @Schema(description = "Date of event", example = "2023.10.24")
    private String date;
}

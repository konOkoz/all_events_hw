package de.ait.hw.dto.eventsDtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;



@Data
@Schema(description = "Данные для обновления")
public class UpdateEventDto {

    @Schema(description = "Описание события")
    private String newDescription;
    @Schema(description = "Дата события")
    private String newDate;
}

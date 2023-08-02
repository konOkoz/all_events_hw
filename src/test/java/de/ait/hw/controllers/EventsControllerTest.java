package de.ait.hw.controllers;

import de.ait.hw.models.Event;
import de.ait.hw.repositories.EventsRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("EventsController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
public class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventsRepository eventsRepository;

    @BeforeEach
    public void setUp(){
        eventsRepository.clear();
    }


    @Nested
    @DisplayName("POST /api/events is works:")
    class AddEventTests {
        @Test
        void add_Event() throws Exception {
            mockMvc.perform(post("/api/events")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"description\": \"Пойти на свадьбу\",\n" +
                                    "  \"date\": \"2023.07.30\"\n" +
                                    "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.description", is("Пойти на свадьбу")))
                    .andExpect(jsonPath("$.date", is("2023.07.30")));
        }
    }

    @Nested
    @DisplayName("GET /api/events is works: ")
    class GetAllEventsTests {
        @Test
        void show_All_Events() throws Exception {
            eventsRepository.save(Event.builder().description("Wedding").date("2023.10.24").build());
            eventsRepository.save(Event.builder().description("StandUP show").date("2023.08.11").build());

            mockMvc.perform(get("/api/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));


        }
    }

    @Nested
    @DisplayName("DELETE /api/events/eventId is works: ")
    class DeleteEventTests {
        @Test
        void delete_Event() throws Exception {
            eventsRepository.save(Event.builder().description("StandUP show").date("2023.08.11").build());

            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isOk());
        }


        @Test
        void delete_Not_Exist_Event() throws Exception {

            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("PUT /api/events/eventId is works: ")
    class UpdateEventsTests {
        @Test
        void update_exist_event()throws Exception{
            eventsRepository.save(Event.builder().description("Wedding").date("2023.10.24").build());

            mockMvc.perform(put("/api/events/1")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newDescription\": \"Fishing\",\n" +
                                    "  \"newDate\": \"2023.12.12\"\n" +
                                    "}"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.description", is("Fishing")))
                    .andExpect(jsonPath("$.date", is("2023.12.12")));
        }

        @Test
        void update_not_exist_event()throws Exception{
            mockMvc.perform(put("/api/events/1")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newDescription\": \"Fishing\",\n" +
                                    "  \"newDate\": \"2023.12.12\"\n" +
                                    "}"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("GET /api/events/eventId is works:")
    class GetEventTests{
        @Test
        void get_exist_event()throws Exception{
            eventsRepository.save(Event.builder().description("Wedding").date("2023.10.24").build());
            mockMvc.perform(get("/api/events/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.description", is("Wedding")))
                    .andExpect(jsonPath("$.date", is("2023.10.24")));
        }

        @Test
        void get_not_exist_event()throws Exception{

            mockMvc.perform(get("/api/events/1"))
                    .andExpect(status().isNotFound());
        }
    }

}

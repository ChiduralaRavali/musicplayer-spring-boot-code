package com.example.song;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SongControllerTests {

        @Autowired
        private MockMvc mockMvc;

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer();

        @Test
        @Order(1)
        public void testgetSongs() throws Exception {
                mockMvc.perform(get("/songs"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", Matchers.hasSize(5)))

                                .andExpect(jsonPath("$[0].songId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[0].songName", Matchers.equalToIgnoringCase("Butta Bomma")))
                                .andExpect(jsonPath("$[0].lyricist",
                                                Matchers.equalToIgnoringCase("Ramajogayya Sastry")))
                                .andExpect(jsonPath("$[0].singer", Matchers.equalToIgnoringCase("Armaan Malik")))
                                .andExpect(jsonPath("$[0].musicDirector", Matchers.equalToIgnoringCase("Thaman S")))

                                .andExpect(jsonPath("$[1].songId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[1].songName",
                                                Matchers.equalToIgnoringCase("Kathari Poovazhagi")))
                                .andExpect(jsonPath("$[1].lyricist", Matchers.equalToIgnoringCase("Vijay")))
                                .andExpect(jsonPath("$[1].singer",
                                                Matchers.equalToIgnoringCase("Benny Dayal, Swetha Mohan")))
                                .andExpect(jsonPath("$[1].musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")))

                                .andExpect(jsonPath("$[2].songId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[2].songName", Matchers.equalToIgnoringCase("Tum Hi Ho")))
                                .andExpect(jsonPath("$[2].lyricist", Matchers.equalToIgnoringCase("Mithoon")))
                                .andExpect(jsonPath("$[2].singer", Matchers.equalToIgnoringCase("Arijit Singh")))
                                .andExpect(jsonPath("$[2].musicDirector", Matchers.equalToIgnoringCase("Mithoon")))

                                .andExpect(jsonPath("$[3].songId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$[3].songName", Matchers.equalToIgnoringCase("Vizhiyil")))
                                .andExpect(jsonPath("$[3].lyricist", Matchers.equalToIgnoringCase("Vairamuthu")))
                                .andExpect(jsonPath("$[3].singer", Matchers.equalToIgnoringCase("Unni Menon")))
                                .andExpect(jsonPath("$[3].musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")))

                                .andExpect(jsonPath("$[4].songId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[4].songName", Matchers.equalToIgnoringCase("Nenjame")))
                                .andExpect(jsonPath("$[4].lyricist",
                                                Matchers.equalToIgnoringCase("Panchu Arunachalam")))
                                .andExpect(jsonPath("$[4].singer",
                                                Matchers.equalToIgnoringCase("S.P.Balasubrahmanyam")))
                                .andExpect(jsonPath("$[4].musicDirector", Matchers.equalToIgnoringCase("Ilaiyaraaja")));
        }

        @Test
        @Order(2)
        public void testGetNotFound() throws Exception {

                mockMvc.perform(get("/songs/99"))
                                .andExpect(status().isNotFound());

        }

        @Test
        @Order(3)
        public void testGetSongById() throws Exception {
                mockMvc.perform(get("/songs/1"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$.songName", Matchers.equalToIgnoringCase("Butta Bomma")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalToIgnoringCase("Ramajogayya Sastry")))
                                .andExpect(jsonPath("$.singer", Matchers.equalToIgnoringCase("Armaan Malik")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalToIgnoringCase("Thaman S")));

                mockMvc.perform(get("/songs/2"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$.songName", Matchers.equalToIgnoringCase("Kathari Poovazhagi")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalToIgnoringCase("Vijay")))
                                .andExpect(jsonPath("$.singer",
                                                Matchers.equalToIgnoringCase("Benny Dayal, Swetha Mohan")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")));

                mockMvc.perform(get("/songs/3"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.songName", Matchers.equalToIgnoringCase("Tum Hi Ho")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalToIgnoringCase("Mithoon")))
                                .andExpect(jsonPath("$.singer", Matchers.equalToIgnoringCase("Arijit Singh")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalToIgnoringCase("Mithoon")));

                mockMvc.perform(get("/songs/4"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$.songName", Matchers.equalToIgnoringCase("Vizhiyil")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalToIgnoringCase("Vairamuthu")))
                                .andExpect(jsonPath("$.singer", Matchers.equalToIgnoringCase("Unni Menon")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")));

                mockMvc.perform(get("/songs/5"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$.songName", Matchers.equalToIgnoringCase("Nenjame")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalToIgnoringCase("Panchu Arunachalam")))
                                .andExpect(jsonPath("$.singer", Matchers.equalToIgnoringCase("S.P.Balasubrahmanyam")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalToIgnoringCase("Ilaiyaraaja")));
        }

        @Test
        @Order(4)
        public void testPostSong() throws Exception {
                Song song = new Song(6, "Bala", "Siddharth-Garima", "Sachin-Jigar", "Sachin-Jigar");
                String content = objectWriter.writeValueAsString(song);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/songs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest)
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(6)))
                                .andExpect(jsonPath("$.songName", Matchers.equalTo("Bala")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalTo("Siddharth-Garima")))
                                .andExpect(jsonPath("$.singer", Matchers.equalTo("Sachin-Jigar")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalTo("Sachin-Jigar")));
        }

        @Test
        @Order(5)
        public void testAfterPost() throws Exception {
                mockMvc.perform(get("/songs/6"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(6)))
                                .andExpect(jsonPath("$.songName", Matchers.equalTo("Bala")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalTo("Siddharth-Garima")))
                                .andExpect(jsonPath("$.singer", Matchers.equalTo("Sachin-Jigar")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalTo("Sachin-Jigar")));
        }

        @Test
        @Order(6)
        public void testPutNotFound() throws Exception {
                Song song = new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon");
                String content = objectWriter.writeValueAsString(song);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/songs/66")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest).andExpect(status().isNotFound());

        }

        @Test
        @Order(7)
        public void testPutSong() throws Exception {
                Song song = new Song(3, "Tum Hi Ho", "Mithoon", "Atif Aslam", "Mithoon");
                String content = objectWriter.writeValueAsString(song);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/songs/3")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest)
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.songName", Matchers.equalTo("Tum Hi Ho")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalTo("Mithoon")))
                                .andExpect(jsonPath("$.singer", Matchers.equalTo("Atif Aslam")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalTo("Mithoon")));
        }

        @Test
        @Order(8)
        public void testAfterPut() throws Exception {
                mockMvc.perform(get("/songs/3"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.songId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.songName", Matchers.equalTo("Tum Hi Ho")))
                                .andExpect(jsonPath("$.lyricist", Matchers.equalTo("Mithoon")))
                                .andExpect(jsonPath("$.singer", Matchers.equalTo("Atif Aslam")))
                                .andExpect(jsonPath("$.musicDirector", Matchers.equalTo("Mithoon")));
        }

        @Test
        @Order(9)
        public void testDeleteNotFound() throws Exception {
                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/songs/69")
                                .contentType(MediaType.APPLICATION_JSON);

                mockMvc.perform(mockRequest)
                                .andExpect(status().isNotFound());

        }

        @Test
        @Order(10)
        public void testDeleteSong() throws Exception {
                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/songs/6")
                                .contentType(MediaType.APPLICATION_JSON);

                mockMvc.perform(mockRequest)
                                .andExpect(status().isNoContent());
        }

        @Test
        @Order(11)
        public void testAfterDelete() throws Exception {
                mockMvc.perform(get("/songs"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", Matchers.hasSize(5)))

                                .andExpect(jsonPath("$[0].songId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[0].songName", Matchers.equalToIgnoringCase("Butta Bomma")))
                                .andExpect(jsonPath("$[0].lyricist",
                                                Matchers.equalToIgnoringCase("Ramajogayya Sastry")))
                                .andExpect(jsonPath("$[0].singer", Matchers.equalToIgnoringCase("Armaan Malik")))
                                .andExpect(jsonPath("$[0].musicDirector", Matchers.equalToIgnoringCase("Thaman S")))

                                .andExpect(jsonPath("$[1].songId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[1].songName",
                                                Matchers.equalToIgnoringCase("Kathari Poovazhagi")))
                                .andExpect(jsonPath("$[1].lyricist", Matchers.equalToIgnoringCase("Vijay")))
                                .andExpect(jsonPath("$[1].singer",
                                                Matchers.equalToIgnoringCase("Benny Dayal, Swetha Mohan")))
                                .andExpect(jsonPath("$[1].musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")))

                                .andExpect(jsonPath("$[2].songId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[2].songName", Matchers.equalTo("Tum Hi Ho")))
                                .andExpect(jsonPath("$[2].lyricist", Matchers.equalTo("Mithoon")))
                                .andExpect(jsonPath("$[2].singer", Matchers.equalTo("Atif Aslam")))
                                .andExpect(jsonPath("$[2].musicDirector", Matchers.equalTo("Mithoon")))

                                .andExpect(jsonPath("$[3].songId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$[3].songName", Matchers.equalToIgnoringCase("Vizhiyil")))
                                .andExpect(jsonPath("$[3].lyricist", Matchers.equalToIgnoringCase("Vairamuthu")))
                                .andExpect(jsonPath("$[3].singer", Matchers.equalToIgnoringCase("Unni Menon")))
                                .andExpect(jsonPath("$[3].musicDirector", Matchers.equalToIgnoringCase("A.R. Rahman")))

                                .andExpect(jsonPath("$[4].songId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[4].songName", Matchers.equalToIgnoringCase("Nenjame")))
                                .andExpect(jsonPath("$[4].lyricist",
                                                Matchers.equalToIgnoringCase("Panchu Arunachalam")))
                                .andExpect(jsonPath("$[4].singer",
                                                Matchers.equalToIgnoringCase("S.P.Balasubrahmanyam")))
                                .andExpect(jsonPath("$[4].musicDirector", Matchers.equalToIgnoringCase("Ilaiyaraaja")));
        }
}

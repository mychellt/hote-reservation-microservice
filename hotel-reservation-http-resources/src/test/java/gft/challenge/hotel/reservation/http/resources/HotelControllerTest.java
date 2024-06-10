package gft.challenge.hotel.reservation.http.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import gft.challenge.hotel.reservation.core.business.CreateHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.DeleteHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.FetchHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.ListHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.http.resources.dto.CreateHotelDTO;
import gft.challenge.hotel.reservation.http.resources.mappers.ResourcesModelMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = HotelController.class)
@ContextConfiguration(classes = {HotelController.class})
class HotelControllerTest {
  @MockBean
  private CreateHotelProcessorPort createHotelProcessorPort;

  @MockBean
  private FetchHotelProcessorPort fetchHotelProcessorPort;

  @MockBean
  private ListHotelProcessorPort listHotelProcessorPort;

  @MockBean
  private DeleteHotelProcessorPort deleteHotelProcessorPort;

  @MockBean
  private ResourcesModelMapper mapper;


  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private HotelController hotelController;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void create_test() throws Exception {
    CreateHotelDTO requestBody = new CreateHotelDTO();
    requestBody.setName("Test Hotel");
    requestBody.setEmail("test@example.com");
    requestBody.setPhone("123456789");
    requestBody.setNumberOfRooms(10);

    when(createHotelProcessorPort.process(any(Context.class))).thenReturn(null);

    mockMvc.perform(post("/api/hotel")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestBody)))
        .andExpect(status().isOk());

    verify(createHotelProcessorPort).process(any());
  }

  @Test
  void getAll_test() throws Exception {
    List<Hotel> hotels = List.of(Hotel.builder()
            .id(UUID.randomUUID())
            .name("Fake Name")
            .numberOfRooms(1)
            .phone("Fake Phone")
            .availableRooms(1)
            .email("email@dev.com")
        .build(),
        Hotel.builder()
            .name("Fake Name")
            .id(UUID.randomUUID())
            .numberOfRooms(1)
            .phone("Fake Phone")
            .availableRooms(1)
            .email("email@dev.com")
            .build()
    );

    when(listHotelProcessorPort.process(any())).thenReturn(hotels);

    mockMvc.perform(get("/api/hotel/all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));

    verify(listHotelProcessorPort).process(any());
  }

  @DisplayName(value = "Should be able to return a hotel by id")
  @Test
  void get_test() throws Exception {
    UUID hotelId = UUID.randomUUID();
    Hotel hotel = Hotel.builder()
        .name("Fake Name")
        .id(UUID.randomUUID())
        .numberOfRooms(1)
        .phone("Fake Phone")
        .availableRooms(1)
        .email("email@dev.com")
        .build();

    when(fetchHotelProcessorPort.process(any())).thenReturn(Optional.of(hotel));

    mockMvc.perform(get("/api/hotel/{id}", hotelId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("Fake Name")));

    verify(fetchHotelProcessorPort).process(any());
  }


}

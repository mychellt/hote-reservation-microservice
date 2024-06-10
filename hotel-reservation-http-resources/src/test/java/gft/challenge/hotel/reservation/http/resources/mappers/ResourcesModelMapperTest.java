package gft.challenge.hotel.reservation.http.resources.mappers;

import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.http.resources.dto.FetchHotelDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResourcesModelMapperTest {
  @Test
  @DisplayName(value = "Verify mapping from domain model to DTO")
  void from_test() {
    ResourcesModelMapper mapper = Mappers.getMapper(ResourcesModelMapper.class);
    FetchHotelDTO dto = mapper.from(Hotel.builder()
        .name("Fake Name")
        .id(UUID.randomUUID())
        .email("fake@dev.com")
        .phone("Fake Phone")
        .availableRooms(1)
        .numberOfRooms(1)
        .build());

    assertNotNull(dto);
    assertNotNull(dto.getNumberOfRooms());
    assertNotNull(dto.getAvailableRooms());
    assertThat(dto.getPhone(), not(emptyOrNullString()));
    assertThat(dto.getName(), not(emptyOrNullString()));
    assertThat(dto.getEmail(), not(emptyOrNullString()));

  }
}

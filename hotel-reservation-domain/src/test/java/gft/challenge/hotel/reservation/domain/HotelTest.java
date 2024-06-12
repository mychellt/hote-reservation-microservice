package gft.challenge.hotel.reservation.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HotelTest {
  private Hotel hotel;

  @BeforeEach
  void setUp() {
    hotel = Hotel.builder()
        .name("Hotel California")
        .email("contact@hotelcalifornia.com")
        .phone("123-456-7890")
        .numberOfRooms(100)
        .availableRooms(20)
        .build();
  }


  @Test
  void testHotelCreation() {
    assertNotNull(hotel);
    assertEquals("Hotel California", hotel.getName());
    assertEquals("contact@hotelcalifornia.com", hotel.getEmail());
    assertEquals("123-456-7890", hotel.getPhone());
    assertEquals(100, hotel.getNumberOfRooms());
    assertEquals(20, hotel.getAvailableRooms());
  }

  @Test
  void testSettersAndGetters() {
    hotel.setName("New Hotel Name");
    hotel.setEmail("newemail@hotel.com");
    hotel.setPhone("098-765-4321");
    hotel.setNumberOfRooms(200);
    hotel.setAvailableRooms(50);

    assertEquals("New Hotel Name", hotel.getName());
    assertEquals("newemail@hotel.com", hotel.getEmail());
    assertEquals("098-765-4321", hotel.getPhone());
    assertEquals(200, hotel.getNumberOfRooms());
    assertEquals(50, hotel.getAvailableRooms());
  }

  @Test
  void testBusinessLogicExample() {
    hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
    assertEquals(19, hotel.getAvailableRooms());
  }
}

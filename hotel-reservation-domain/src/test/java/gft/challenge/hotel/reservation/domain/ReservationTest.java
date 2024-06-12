package gft.challenge.hotel.reservation.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

  private Reservation reservation;
  private UUID hotelId;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private UUID travelReservationId;

  @BeforeEach
  void setUp() {
    hotelId = UUID.randomUUID();
    checkInDate = LocalDateTime.of(2023, 6, 1, 14, 0);
    checkOutDate = LocalDateTime.of(2023, 6, 10, 12, 0);
    travelReservationId = UUID.randomUUID();

    reservation = Reservation.builder()
        .hotelId(hotelId)
        .checkInDate(checkInDate)
        .checkOutDate(checkOutDate)
        .numberOfRooms(2)
        .status(Status.PENDING)
        .travelReservationId(travelReservationId)
        .build();
  }

  @Test
  void testReservationCreation() {
    assertNotNull(reservation);
    assertEquals(hotelId, reservation.getHotelId());
    assertEquals(checkInDate, reservation.getCheckInDate());
    assertEquals(checkOutDate, reservation.getCheckOutDate());
    assertEquals(2, reservation.getNumberOfRooms());
    assertEquals(Status.PENDING, reservation.getStatus());
    assertEquals(travelReservationId, reservation.getTravelReservationId());
  }

  @Test
  void testIsCheckOutAllowed() {
    assertTrue(reservation.isCheckOutAllowed());

    reservation.setCheckInDate(null);
    assertFalse(reservation.isCheckOutAllowed());

    reservation.setCheckInDate(checkOutDate.plusDays(1));
    assertFalse(reservation.isCheckOutAllowed());
  }

  @Test
  void testCancel() {
    reservation.cancel();
    assertEquals(Status.CANCELLED, reservation.getStatus());
  }

  @Test
  void testConfirm() {
    reservation.confirm();
    assertEquals(Status.CONFIRMED, reservation.getStatus());
  }

  @Test
  void testIsCheckInAllowed() {
    reservation.setStatus(Status.CONFIRMED);
    reservation.setCheckInDate(LocalDateTime.now().minusDays(1));
    reservation.setCheckOutDate(LocalDateTime.now().plusDays(1));
    assertTrue(reservation.isCheckInAllowed());

    reservation.setCheckInDate(LocalDateTime.now().plusDays(1));
    assertFalse(reservation.isCheckInAllowed());

    reservation.setCheckInDate(LocalDateTime.now().minusDays(1));
    reservation.setCheckOutDate(LocalDateTime.now().minusDays(1));
    assertFalse(reservation.isCheckInAllowed());

    reservation.setStatus(Status.PENDING);
    assertFalse(reservation.isCheckInAllowed());
  }

  @Test
  void testUpdateNumberOfRooms() {
    reservation.updateNumberOfRooms(5);
    assertEquals(5, reservation.getNumberOfRooms());

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      reservation.updateNumberOfRooms(0);
    });
    assertEquals("Number of rooms must be greater than zero.", exception.getMessage());
  }
}

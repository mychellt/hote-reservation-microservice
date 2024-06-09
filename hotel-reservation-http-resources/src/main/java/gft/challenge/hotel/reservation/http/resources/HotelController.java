package gft.challenge.hotel.reservation.http.resources;

import gft.challenge.hotel.reservation.core.business.CreateHotelPort;
import gft.challenge.hotel.reservation.http.resources.mappers.ResourcesModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {
  private final CreateHotelPort createHotelPort;
  private final ResourcesModelMapper mapper;

  @Autowired
  public HotelController(final CreateHotelPort createHotelPort,
                         final ResourcesModelMapper mapper) {
    this.createHotelPort = createHotelPort;
    this.mapper = mapper;
  }

  @PostMapping()
  public ResponseEntity<Void> create() {
    return null;
  }

  @GetMapping(value = "/all")
  public ResponseEntity<Void> getAll() {
    return null;
  }

  @GetMapping
  public ResponseEntity<Void> get() {
    return null;
  }

  @DeleteMapping
  public ResponseEntity<Void> delete() {
    return null;
  }

  @PutMapping
  public ResponseEntity<Void> update() {
    return null;
  }
}

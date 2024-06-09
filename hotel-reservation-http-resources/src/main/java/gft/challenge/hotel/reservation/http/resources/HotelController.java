package gft.challenge.hotel.reservation.http.resources;

import gft.challenge.hotel.reservation.core.business.CreateHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.DeleteHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.FetchHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.http.resources.dto.CreateHotelDTO;
import gft.challenge.hotel.reservation.http.resources.mappers.ResourcesModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {
  private final CreateHotelProcessorPort createHotelProcessorPort;
  private final FetchHotelProcessorPort fetchHotelProcessorPort;
  private final DeleteHotelProcessorPort deleteHotelProcessorPort;
  private final ResourcesModelMapper mapper;

  @Autowired
  public HotelController(final CreateHotelProcessorPort createHotelProcessorPort,
                         final FetchHotelProcessorPort fetchHotelProcessorPort,
                         final DeleteHotelProcessorPort deleteHotelProcessorPort,
                         final ResourcesModelMapper mapper) {
    this.createHotelProcessorPort = createHotelProcessorPort;
    this.fetchHotelProcessorPort = fetchHotelProcessorPort;
    this.deleteHotelProcessorPort = deleteHotelProcessorPort;
    this.mapper = mapper;
  }

  @PostMapping()
  public ResponseEntity<Void> create(@RequestBody final CreateHotelDTO body) {
    final Context context = new Context();

    context.setData(Hotel.builder()
        .phone(body.getPhone())
        .email(body.getEmail())
        .name(body.getName())
        .numberOfRooms(body.getNumberOfRooms())
        .build());

    createHotelProcessorPort.process(context);

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

package gft.challenge.hotel.reservation.http.resources;

import gft.challenge.hotel.reservation.core.business.CreateHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.DeleteHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.FetchHotelProcessorPort;
import gft.challenge.hotel.reservation.core.business.ListHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.http.resources.dto.CreateHotelDTO;
import gft.challenge.hotel.reservation.http.resources.dto.FetchHotelDTO;
import gft.challenge.hotel.reservation.http.resources.mappers.ResourcesModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {
  private final CreateHotelProcessorPort createHotelProcessorPort;
  private final FetchHotelProcessorPort fetchHotelProcessorPort;

  private final ListHotelProcessorPort listHotelProcessorPort;
  private final DeleteHotelProcessorPort deleteHotelProcessorPort;
  private final ResourcesModelMapper mapper;

  @Autowired
  public HotelController(final CreateHotelProcessorPort createHotelProcessorPort,
                         final FetchHotelProcessorPort fetchHotelProcessorPort,
                         final ListHotelProcessorPort listHotelProcessorPort,
                         final DeleteHotelProcessorPort deleteHotelProcessorPort,
                         final ResourcesModelMapper mapper) {
    this.createHotelProcessorPort = createHotelProcessorPort;
    this.fetchHotelProcessorPort = fetchHotelProcessorPort;
    this.listHotelProcessorPort = listHotelProcessorPort;
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
  public ResponseEntity<List<FetchHotelDTO>> getAll() {
    return ResponseEntity.ok()
        .body(listHotelProcessorPort.process(new Context())
        .stream()
        .map(mapper::from)
        .toList());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<FetchHotelDTO> get(@PathVariable(value = "id") final UUID id) {
    final Context context = new Context();
    context.setData(id);
    return ResponseEntity.ok()
        .body(fetchHotelProcessorPort.process(context).map(obj -> FetchHotelDTO.builder()
                .phone(obj.getPhone())
                .name(obj.getName())
                .availableRooms(obj.getAvailableRooms())
                .numberOfRooms(obj.getNumberOfRooms())
                .email(obj.getEmail())
                .build())
            .orElse(null));
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

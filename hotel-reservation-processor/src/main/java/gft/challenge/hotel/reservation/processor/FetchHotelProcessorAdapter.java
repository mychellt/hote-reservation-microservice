package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.business.FetchHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import gft.challenge.hotel.reservation.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FetchHotelProcessorAdapter implements FetchHotelProcessorPort {
  private final HotelRepositoryPort repositoryPort;

  @Autowired
  public FetchHotelProcessorAdapter(HotelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Optional<Hotel> process(Context context) {
    final UUID id = context.getData(UUID.class);
    return repositoryPort.get(id);
  }
}

package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.business.CreateHotelProcessorPort;
import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import gft.challenge.hotel.reservation.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateHotelProcessorAdapter implements CreateHotelProcessorPort {
  private final HotelRepositoryPort repositoryPort;

  @Autowired
  public CreateHotelProcessorAdapter(HotelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Hotel process(Context context) {
    final Hotel data = context.getData(Hotel.class);
    data.setAvailableRooms(data.getNumberOfRooms());
    return repositoryPort.save(data);
  }
}

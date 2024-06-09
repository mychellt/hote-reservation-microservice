package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.business.ListHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import gft.challenge.hotel.reservation.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListHotelProcessorAdapter implements ListHotelProcessorPort {
  private final HotelRepositoryPort repositoryPort;

  @Autowired
  public ListHotelProcessorAdapter(HotelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public List<Hotel> process(Context context) {
    return repositoryPort.getAll();
  }
}

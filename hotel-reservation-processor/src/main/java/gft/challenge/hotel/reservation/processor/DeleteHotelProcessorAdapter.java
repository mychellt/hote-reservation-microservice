package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.business.DeleteHotelProcessorPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteHotelProcessorAdapter implements DeleteHotelProcessorPort {
  private final HotelRepositoryPort repositoryPort;

  @Autowired
  public DeleteHotelProcessorAdapter(HotelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Void process(Context context) {
    final UUID id = context.getData(UUID.class);
    repositoryPort.delete(id);
    return null;
  }
}

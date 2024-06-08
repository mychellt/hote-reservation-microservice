package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.command.CreateHotelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateHotelAdapter implements CreateHotelPort {

  @Override
  public Void process(Context context) {
    return null;
  }
}

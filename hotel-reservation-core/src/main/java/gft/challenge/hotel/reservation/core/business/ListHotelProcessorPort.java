package gft.challenge.hotel.reservation.core.business;

import gft.challenge.hotel.reservation.core.command.Command;
import gft.challenge.hotel.reservation.domain.Hotel;

import java.util.List;
import java.util.Optional;

public interface ListHotelProcessorPort extends Command<List<Hotel>> {

}

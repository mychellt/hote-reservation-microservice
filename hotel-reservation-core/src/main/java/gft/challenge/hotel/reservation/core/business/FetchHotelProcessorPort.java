package gft.challenge.hotel.reservation.core.business;

import gft.challenge.hotel.reservation.core.command.Command;
import gft.challenge.hotel.reservation.domain.Hotel;

import java.util.Optional;

public interface FetchHotelProcessorPort extends Command<Optional<Hotel>> {

}

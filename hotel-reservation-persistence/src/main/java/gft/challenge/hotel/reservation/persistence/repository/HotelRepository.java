package gft.challenge.hotel.reservation.persistence.repository;

import gft.challenge.hotel.reservation.persistence.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

}

package gft.challenge.hotel.reservation.persistence.repository;

import gft.challenge.hotel.reservation.persistence.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

}

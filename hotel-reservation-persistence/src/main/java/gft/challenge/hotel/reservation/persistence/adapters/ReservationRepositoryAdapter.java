package gft.challenge.hotel.reservation.persistence.adapters;

import gft.challenge.hotel.reservation.core.persistence.ReservationRepositoryPort;
import gft.challenge.hotel.reservation.domain.Reservation;
import gft.challenge.hotel.reservation.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.hotel.reservation.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryAdapter implements ReservationRepositoryPort {
  private final ReservationRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public ReservationRepositoryAdapter(final ReservationRepository repository,
                                      final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Reservation save(Reservation reservation) {
    return mapper.from(repository.save(mapper.from(reservation)));
  }
}

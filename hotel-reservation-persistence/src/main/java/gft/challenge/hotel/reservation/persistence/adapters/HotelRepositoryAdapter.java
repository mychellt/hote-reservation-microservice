package gft.challenge.hotel.reservation.persistence.adapters;

import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.hotel.reservation.persistence.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class HotelRepositoryAdapter implements HotelRepositoryPort {
  private final HotelRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public HotelRepositoryAdapter(final HotelRepository repository, final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<Hotel> getAll() {
    return repository.findAll()
        .stream()
        .map(mapper::from)
        .toList();
  }

  @Override
  public Optional<Hotel> get(UUID id) {
    return repository.findById(id).map(mapper::from);
  }

  @Override
  public Hotel save(Hotel obj) {
    return mapper.from(repository.save(mapper.from(obj)));
  }

  @Override
  public void delete(final UUID id) {
    repository.deleteById(id);
  }
}

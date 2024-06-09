package gft.challenge.hotel.reservation.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"gft.challenge.hotel.reservation.persistence"})
@EntityScan(basePackages = {"gft.challenge.hotel.reservation.persistence.model"})
@EnableJpaRepositories(basePackages = {"gft.challenge.hotel.reservation.persistence"})
@EnableTransactionManagement
public class PersistenceConfiguration {

}

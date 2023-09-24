package it.geonurv.geoapi.repository;

import it.geonurv.geoapi.model.Comuni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuniRepository extends JpaRepository<Comuni, Long> {
    Comuni findByproComT(String proComT);
    Comuni findByComune(String nameComune);
}
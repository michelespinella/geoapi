package it.geonurv.geoapi.controller;

import it.geonurv.geoapi.model.Comuni;
import it.geonurv.geoapi.model.GeojsonFeature;
import it.geonurv.geoapi.repository.ComuniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static it.geonurv.geoapi.services.ComuniService.writeGeoJSON;

@RestController
@RequestMapping("/geoapi")
public class ComuniController {

    @Autowired
    private ComuniRepository comuniRepository;

    @GetMapping("/comune")
    @PreAuthorize("@securityHandler.isIstatUser()")
    public ResponseEntity<GeojsonFeature> getAllTutorials(@RequestParam(required = false) String proComT) {
        try {
            Optional<Comuni> comune = Optional.ofNullable(comuniRepository.findByComune(proComT));
            if (comune.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            var geometryString = writeGeoJSON(comune.get().getGeom(),comune.get());
            return new ResponseEntity<>(geometryString, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

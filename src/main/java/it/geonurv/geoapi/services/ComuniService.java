package it.geonurv.geoapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.geonurv.geoapi.model.Comuni;
import it.geonurv.geoapi.model.GeojsonGeometry;
import it.geonurv.geoapi.model.GeojsonFeature;
import it.geonurv.geoapi.model.Properties__1;
import org.geotools.api.referencing.FactoryException;
import org.geotools.api.referencing.crs.CRSAuthorityFactory;
import org.geotools.api.referencing.crs.CoordinateReferenceSystem;
import org.geotools.api.referencing.operation.MathTransform;
import org.geotools.api.referencing.operation.TransformException;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.geotools.util.factory.Hints;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.stereotype.Service;


@Service
public class ComuniService {

    public static GeojsonFeature writeGeoJSON(Geometry g, Comuni comuni)
    {
        try {
            var wgs84Geom = convertCoordinates(g);
            String geojsonComune = new GeoJsonWriter().write(wgs84Geom);
            ObjectMapper mapper = new ObjectMapper();
            GeojsonGeometry comuneGeomObj = mapper.readValue(geojsonComune, GeojsonGeometry.class);
            Properties__1 propComune= new Properties__1();
            propComune.setComune(comuni.getComune());
            propComune.setProComT(comuni.getProComT());
            propComune.setProCom(comuni.getProCom());
            GeojsonFeature featureJson = new GeojsonFeature();
            featureJson.setGeometry(comuneGeomObj);
            featureJson.setProperties(propComune);
            featureJson.setType("Feature");
            return featureJson;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Geometry convertCoordinates(Geometry geom){
        try {
            Hints hints = new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);
            CRSAuthorityFactory factory = ReferencingFactoryFinder.getCRSAuthorityFactory("EPSG", hints);
            CoordinateReferenceSystem targetCRS = factory.createCoordinateReferenceSystem("EPSG:4326");
            var sourceCRS = CRS.decode("EPSG:32632");
            MathTransform transform = CRS.findMathTransform(sourceCRS, targetCRS);
            Geometry targetGeometry = JTS.transform( geom, transform);
            return targetGeometry;
        } catch (FactoryException e) {
            e.printStackTrace();
        } catch (TransformException e) {
            throw new RuntimeException(e);
        }
        return geom;
    }
}


package it.geonurv.geoapi.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "coordinates",
    "crs",
    "properties"
})
public class GeojsonGeometry {

    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private List<List<List<List<Double>>>> coordinates;
    @JsonProperty("crs")
    private Crs crs;
    @JsonProperty("properties")
    private Properties__1 properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("coordinates")
    public List<List<List<List<Double>>>> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<List<List<List<Double>>>> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("crs")
    public Crs getCrs() {
        return crs;
    }

    @JsonProperty("crs")
    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    @JsonProperty("properties")
    public Properties__1 getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties__1 properties) {
        this.properties = properties;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

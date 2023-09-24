package it.geonurv.geoapi.model;

import java.util.LinkedHashMap;
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
        "geometry",
        "properties"
})
public class GeojsonFeature {

    @JsonProperty("type")
    private String type;
    @JsonProperty("geometry")
    private GeojsonGeometry geometry;
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

    @JsonProperty("geometry")
    public GeojsonGeometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(GeojsonGeometry geometry) {
        this.geometry = geometry;
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

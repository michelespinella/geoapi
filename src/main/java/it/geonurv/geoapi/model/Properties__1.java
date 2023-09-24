
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
    "comune",
    "pro_com_t",
    "pro_com"
})
public class Properties__1 {

    @JsonProperty("comune")
    private String comune;
    @JsonProperty("pro_com_t")
    private String proComT;
    @JsonProperty("pro_com")
    private Long proCom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("comune")
    public String getComune() {
        return comune;
    }

    @JsonProperty("comune")
    public void setComune(String comune) {
        this.comune = comune;
    }

    @JsonProperty("pro_com_t")
    public String getProComT() {
        return proComT;
    }

    @JsonProperty("pro_com_t")
    public void setProComT(String proComT) {
        this.proComT = proComT;
    }

    @JsonProperty("pro_com")
    public Long getProCom() {
        return proCom;
    }

    @JsonProperty("pro_com")
    public void setProCom(Long proCom) {
        this.proCom = proCom;
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

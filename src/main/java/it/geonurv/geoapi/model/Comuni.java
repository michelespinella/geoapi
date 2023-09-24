package it.geonurv.geoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;

import javax.persistence.*;

@Entity
@Table(name = "COMUNI")
public class Comuni {
    @JsonIgnore
    @Column(name = "GEOM")
    private Geometry geom;

    @Column(name = "COD_RIP")
    private Long codRip;

    @Column(name = "COD_REG")
    private Long codReg;

    @Column(name = "COD_PROV")
    private Long codProv;

    @Column(name = "COD_CM")
    private Long codCm;

    @Column(name = "COD_UTS")
    private Long codUts;

    @Id
    @Column(name = "PRO_COM")
    private Long proCom;

    @Column(name = "PRO_COM_T")
    private String proComT;

    @Column(name = "COMUNE")
    private String comune;

    @Column(name = "COMUNE_A")
    private String comuneA;

    @Column(name = "CC_UTS")
    private Long ccUts;

    @Column(name = "SHAPE_LENG")
    private Long shapeLeng;

    @Column(name = "SHAPE_LE_1")
    private Long shapeLe1;

    public Geometry getGeom() {
        return this.geom;
    }

    public Comuni() {

    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public Long getCodRip() {
        return this.codRip;
    }

    public void setCodRip(Long codRip) {
        this.codRip = codRip;
    }

    public Long getCodReg() {
        return this.codReg;
    }

    public void setCodReg(Long codReg) {
        this.codReg = codReg;
    }

    public Long getCodProv() {
        return this.codProv;
    }

    public void setCodProv(Long codProv) {
        this.codProv = codProv;
    }

    public Long getCodCm() {
        return this.codCm;
    }

    public void setCodCm(Long codCm) {
        this.codCm = codCm;
    }

    public Long getCodUts() {
        return this.codUts;
    }

    public void setCodUts(Long codUts) {
        this.codUts = codUts;
    }

    public Long getProCom() {
        return this.proCom;
    }

    public void setProCom(Long proCom) {
        this.proCom = proCom;
    }

    public String getProComT() {
        return this.proComT;
    }

    public void setProComT(String proComT) {
        this.proComT = proComT;
    }

    public String getComune() {
        return this.comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getComuneA() {
        return this.comuneA;
    }

    public void setComuneA(String comuneA) {
        this.comuneA = comuneA;
    }

    public Long getCcUts() {
        return this.ccUts;
    }

    public void setCcUts(Long ccUts) {
        this.ccUts = ccUts;
    }

    public Long getShapeLeng() {
        return this.shapeLeng;
    }

    public void setShapeLeng(Long shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public Long getShapeLe1() {
        return this.shapeLe1;
    }

    public void setShapeLe1(Long shapeLe1) {
        this.shapeLe1 = shapeLe1;
    }
}

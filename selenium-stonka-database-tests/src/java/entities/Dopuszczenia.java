/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "DOPUSZCZENIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dopuszczenia.findAll", query = "SELECT d FROM Dopuszczenia d")
    , @NamedQuery(name = "Dopuszczenia.findByIddopuszczenia", query = "SELECT d FROM Dopuszczenia d WHERE d.iddopuszczenia = :iddopuszczenia")
    , @NamedQuery(name = "Dopuszczenia.findByDatadopuszczenia", query = "SELECT d FROM Dopuszczenia d WHERE d.datadopuszczenia = :datadopuszczenia")
    , @NamedQuery(name = "Dopuszczenia.findByDatawycofania", query = "SELECT d FROM Dopuszczenia d WHERE d.datawycofania = :datawycofania")})
public class Dopuszczenia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDOPUSZCZENIA")
    private Integer iddopuszczenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DATADOPUSZCZENIA")
    private String datadopuszczenia;
    @Size(max = 45)
    @Column(name = "DATAWYCOFANIA")
    private String datawycofania;
    @JoinColumn(name = "ANKIETY_IDANKIETA", referencedColumnName = "IDANKIETA")
    @ManyToOne(optional = false)
    private Ankiety ankietyIdankieta;
    @JoinColumn(name = "SKLEPY_IDSKLEPY", referencedColumnName = "IDSKLEPY")
    @ManyToOne(optional = false)
    private Sklepy sklepyIdsklepy;

    public Dopuszczenia() {
    }

    public Dopuszczenia(Integer iddopuszczenia) {
        this.iddopuszczenia = iddopuszczenia;
    }

    public Dopuszczenia(Integer iddopuszczenia, String datadopuszczenia) {
        this.iddopuszczenia = iddopuszczenia;
        this.datadopuszczenia = datadopuszczenia;
    }

    public Integer getIddopuszczenia() {
        return iddopuszczenia;
    }

    public void setIddopuszczenia(Integer iddopuszczenia) {
        this.iddopuszczenia = iddopuszczenia;
    }

    public String getDatadopuszczenia() {
        return datadopuszczenia;
    }

    public void setDatadopuszczenia(String datadopuszczenia) {
        this.datadopuszczenia = datadopuszczenia;
    }

    public String getDatawycofania() {
        return datawycofania;
    }

    public void setDatawycofania(String datawycofania) {
        this.datawycofania = datawycofania;
    }

    public Ankiety getAnkietyIdankieta() {
        return ankietyIdankieta;
    }

    public void setAnkietyIdankieta(Ankiety ankietyIdankieta) {
        this.ankietyIdankieta = ankietyIdankieta;
    }

    public Sklepy getSklepyIdsklepy() {
        return sklepyIdsklepy;
    }

    public void setSklepyIdsklepy(Sklepy sklepyIdsklepy) {
        this.sklepyIdsklepy = sklepyIdsklepy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddopuszczenia != null ? iddopuszczenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dopuszczenia)) {
            return false;
        }
        Dopuszczenia other = (Dopuszczenia) object;
        if ((this.iddopuszczenia == null && other.iddopuszczenia != null) || (this.iddopuszczenia != null && !this.iddopuszczenia.equals(other.iddopuszczenia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dopuszczenia[ iddopuszczenia=" + iddopuszczenia + " ]";
    }
    
}

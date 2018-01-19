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
@Table(name = "WYPELNIENIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wypelnienia.findAll", query = "SELECT w FROM Wypelnienia w")
    , @NamedQuery(name = "Wypelnienia.findByIdwypelnienia", query = "SELECT w FROM Wypelnienia w WHERE w.idwypelnienia = :idwypelnienia")
    , @NamedQuery(name = "Wypelnienia.findByData", query = "SELECT w FROM Wypelnienia w WHERE w.data = :data")
    , @NamedQuery(name = "Wypelnienia.findByGodzina", query = "SELECT w FROM Wypelnienia w WHERE w.godzina = :godzina")})
public class Wypelnienia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDWYPELNIENIA")
    private Integer idwypelnienia;
    @Size(max = 45)
    @Column(name = "DATA")
    private String data;
    @Size(max = 45)
    @Column(name = "GODZINA")
    private String godzina;
    @JoinColumn(name = "ODPOWIEDZI_IDODPOWIEDZI", referencedColumnName = "IDODPOWIEDZI")
    @ManyToOne(optional = false)
    private Odpowiedzi odpowiedziIdodpowiedzi;
    @JoinColumn(name = "POZYCJE_IDPOZYCJE", referencedColumnName = "IDPOZYCJE")
    @ManyToOne(optional = false)
    private Pozycje pozycjeIdpozycje;
    @JoinColumn(name = "SKLEPY_IDSKLEPY", referencedColumnName = "IDSKLEPY")
    @ManyToOne(optional = false)
    private Sklepy sklepyIdsklepy;

    public Wypelnienia() {
    }

    public Wypelnienia(Integer idwypelnienia) {
        this.idwypelnienia = idwypelnienia;
    }

    public Integer getIdwypelnienia() {
        return idwypelnienia;
    }

    public void setIdwypelnienia(Integer idwypelnienia) {
        this.idwypelnienia = idwypelnienia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public Odpowiedzi getOdpowiedziIdodpowiedzi() {
        return odpowiedziIdodpowiedzi;
    }

    public void setOdpowiedziIdodpowiedzi(Odpowiedzi odpowiedziIdodpowiedzi) {
        this.odpowiedziIdodpowiedzi = odpowiedziIdodpowiedzi;
    }

    public Pozycje getPozycjeIdpozycje() {
        return pozycjeIdpozycje;
    }

    public void setPozycjeIdpozycje(Pozycje pozycjeIdpozycje) {
        this.pozycjeIdpozycje = pozycjeIdpozycje;
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
        hash += (idwypelnienia != null ? idwypelnienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wypelnienia)) {
            return false;
        }
        Wypelnienia other = (Wypelnienia) object;
        if ((this.idwypelnienia == null && other.idwypelnienia != null) || (this.idwypelnienia != null && !this.idwypelnienia.equals(other.idwypelnienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wypelnienia[ idwypelnienia=" + idwypelnienia + " ]";
    }
    
}

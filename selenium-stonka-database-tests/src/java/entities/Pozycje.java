/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "POZYCJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pozycje.findAll", query = "SELECT p FROM Pozycje p")
    , @NamedQuery(name = "Pozycje.findByIdpozycje", query = "SELECT p FROM Pozycje p WHERE p.idpozycje = :idpozycje")
    , @NamedQuery(name = "Pozycje.findByNrporzadkowypozycji", query = "SELECT p FROM Pozycje p WHERE p.nrporzadkowypozycji = :nrporzadkowypozycji")})
public class Pozycje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOZYCJE")
    private Integer idpozycje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRPORZADKOWYPOZYCJI")
    private int nrporzadkowypozycji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pozycjeIdpozycje")
    private Collection<Wypelnienia> wypelnieniaCollection;
    @JoinColumn(name = "ANKIETY_IDANKIETA", referencedColumnName = "IDANKIETA")
    @ManyToOne(optional = false)
    private Ankiety ankietyIdankieta;
    @JoinColumn(name = "PYTANIA_IDPYTANIA", referencedColumnName = "IDPYTANIA")
    @ManyToOne(optional = false)
    private Pytania pytaniaIdpytania;

    public Pozycje() {
    }

    public Pozycje(Integer idpozycje) {
        this.idpozycje = idpozycje;
    }

    public Pozycje(Integer idpozycje, int nrporzadkowypozycji) {
        this.idpozycje = idpozycje;
        this.nrporzadkowypozycji = nrporzadkowypozycji;
    }

    public Integer getIdpozycje() {
        return idpozycje;
    }

    public void setIdpozycje(Integer idpozycje) {
        this.idpozycje = idpozycje;
    }

    public int getNrporzadkowypozycji() {
        return nrporzadkowypozycji;
    }

    public void setNrporzadkowypozycji(int nrporzadkowypozycji) {
        this.nrporzadkowypozycji = nrporzadkowypozycji;
    }

    @XmlTransient
    public Collection<Wypelnienia> getWypelnieniaCollection() {
        return wypelnieniaCollection;
    }

    public void setWypelnieniaCollection(Collection<Wypelnienia> wypelnieniaCollection) {
        this.wypelnieniaCollection = wypelnieniaCollection;
    }

    public Ankiety getAnkietyIdankieta() {
        return ankietyIdankieta;
    }

    public void setAnkietyIdankieta(Ankiety ankietyIdankieta) {
        this.ankietyIdankieta = ankietyIdankieta;
    }

    public Pytania getPytaniaIdpytania() {
        return pytaniaIdpytania;
    }

    public void setPytaniaIdpytania(Pytania pytaniaIdpytania) {
        this.pytaniaIdpytania = pytaniaIdpytania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpozycje != null ? idpozycje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozycje)) {
            return false;
        }
        Pozycje other = (Pozycje) object;
        if ((this.idpozycje == null && other.idpozycje != null) || (this.idpozycje != null && !this.idpozycje.equals(other.idpozycje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pozycje[ idpozycje=" + idpozycje + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "PYTANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pytania.findAll", query = "SELECT p FROM Pytania p")
    , @NamedQuery(name = "Pytania.findByIdpytania", query = "SELECT p FROM Pytania p WHERE p.idpytania = :idpytania")
    , @NamedQuery(name = "Pytania.findByTresc", query = "SELECT p FROM Pytania p WHERE p.tresc = :tresc")})
public class Pytania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPYTANIA")
    private Integer idpytania;
    @Size(max = 45)
    @Column(name = "TRESC")
    private String tresc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pytaniaIdpytania")
    private Collection<Odpowiedzi> odpowiedziCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pytaniaIdpytania")
    private Collection<Pozycje> pozycjeCollection;

    public Pytania() {
    }

    public Pytania(Integer idpytania) {
        this.idpytania = idpytania;
    }

    public Integer getIdpytania() {
        return idpytania;
    }

    public void setIdpytania(Integer idpytania) {
        this.idpytania = idpytania;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @XmlTransient
    public Collection<Odpowiedzi> getOdpowiedziCollection() {
        return odpowiedziCollection;
    }

    public void setOdpowiedziCollection(Collection<Odpowiedzi> odpowiedziCollection) {
        this.odpowiedziCollection = odpowiedziCollection;
    }

    @XmlTransient
    public Collection<Pozycje> getPozycjeCollection() {
        return pozycjeCollection;
    }

    public void setPozycjeCollection(Collection<Pozycje> pozycjeCollection) {
        this.pozycjeCollection = pozycjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpytania != null ? idpytania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pytania)) {
            return false;
        }
        Pytania other = (Pytania) object;
        if ((this.idpytania == null && other.idpytania != null) || (this.idpytania != null && !this.idpytania.equals(other.idpytania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pytania[ idpytania=" + idpytania + " ]";
    }
    
}

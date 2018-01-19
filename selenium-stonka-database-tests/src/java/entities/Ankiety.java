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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luke
 */
@Entity
@Table(name = "ANKIETY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ankiety.findAll", query = "SELECT a FROM Ankiety a")
    , @NamedQuery(name = "Ankiety.findByIdankieta", query = "SELECT a FROM Ankiety a WHERE a.idankieta = :idankieta")
    , @NamedQuery(name = "Ankiety.findByTytul", query = "SELECT a FROM Ankiety a WHERE a.tytul = :tytul")
    , @NamedQuery(name = "Ankiety.findByOpis", query = "SELECT a FROM Ankiety a WHERE a.opis = :opis")})
public class Ankiety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDANKIETA")
    private Integer idankieta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TYTUL")
    private String tytul;
    @Size(max = 90)
    @Column(name = "OPIS")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ankietyIdankieta")
    private Collection<Dopuszczenia> dopuszczeniaCollection;
    @JoinColumn(name = "ANALITYCY_IDANALITYK", referencedColumnName = "IDANALITYCY")
    @ManyToOne(optional = false)
    private Analitycy analitycyIdanalityk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ankietyIdankieta")
    private Collection<Pozycje> pozycjeCollection;

    public Ankiety() {
    }

    public Ankiety(Integer idankieta) {
        this.idankieta = idankieta;
    }

    public Ankiety(Integer idankieta, String tytul) {
        this.idankieta = idankieta;
        this.tytul = tytul;
    }

    public Integer getIdankieta() {
        return idankieta;
    }

    public void setIdankieta(Integer idankieta) {
        this.idankieta = idankieta;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public Collection<Dopuszczenia> getDopuszczeniaCollection() {
        return dopuszczeniaCollection;
    }

    public void setDopuszczeniaCollection(Collection<Dopuszczenia> dopuszczeniaCollection) {
        this.dopuszczeniaCollection = dopuszczeniaCollection;
    }

    public Analitycy getAnalitycyIdanalityk() {
        return analitycyIdanalityk;
    }

    public void setAnalitycyIdanalityk(Analitycy analitycyIdanalityk) {
        this.analitycyIdanalityk = analitycyIdanalityk;
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
        hash += (idankieta != null ? idankieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ankiety)) {
            return false;
        }
        Ankiety other = (Ankiety) object;
        if ((this.idankieta == null && other.idankieta != null) || (this.idankieta != null && !this.idankieta.equals(other.idankieta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ankiety[ idankieta=" + idankieta + " ]";
    }
    
}

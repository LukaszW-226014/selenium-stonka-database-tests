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
@Table(name = "SKLEPY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sklepy.findAll", query = "SELECT s FROM Sklepy s")
    , @NamedQuery(name = "Sklepy.findByIdsklepy", query = "SELECT s FROM Sklepy s WHERE s.idsklepy = :idsklepy")
    , @NamedQuery(name = "Sklepy.findByMiejscowosc", query = "SELECT s FROM Sklepy s WHERE s.miejscowosc = :miejscowosc")
    , @NamedQuery(name = "Sklepy.findByUlica", query = "SELECT s FROM Sklepy s WHERE s.ulica = :ulica")
    , @NamedQuery(name = "Sklepy.findByNrbudynku", query = "SELECT s FROM Sklepy s WHERE s.nrbudynku = :nrbudynku")
    , @NamedQuery(name = "Sklepy.findByKodpocztowy", query = "SELECT s FROM Sklepy s WHERE s.kodpocztowy = :kodpocztowy")})
public class Sklepy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSKLEPY")
    private Integer idsklepy;
    @Size(max = 45)
    @Column(name = "MIEJSCOWOSC")
    private String miejscowosc;
    @Size(max = 45)
    @Column(name = "ULICA")
    private String ulica;
    @Column(name = "NRBUDYNKU")
    private Integer nrbudynku;
    @Size(max = 10)
    @Column(name = "KODPOCZTOWY")
    private String kodpocztowy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sklepyIdsklepy")
    private Collection<Dopuszczenia> dopuszczeniaCollection;
    @JoinColumn(name = "ADMINISTRATORZY_IDADMINISTRATOR", referencedColumnName = "IDADMINISTRATORZY")
    @ManyToOne(optional = false)
    private Administratorzy administratorzyIdadministrator;
    @JoinColumn(name = "KIEROWNICY_IDKIEROWNICY", referencedColumnName = "IDKIEROWNICY")
    @ManyToOne(optional = false)
    private Kierownicy kierownicyIdkierownicy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sklepyIdsklepy")
    private Collection<Wypelnienia> wypelnieniaCollection;

    public Sklepy() {
    }

    public Sklepy(Integer idsklepy) {
        this.idsklepy = idsklepy;
    }

    public Integer getIdsklepy() {
        return idsklepy;
    }

    public void setIdsklepy(Integer idsklepy) {
        this.idsklepy = idsklepy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getNrbudynku() {
        return nrbudynku;
    }

    public void setNrbudynku(Integer nrbudynku) {
        this.nrbudynku = nrbudynku;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    @XmlTransient
    public Collection<Dopuszczenia> getDopuszczeniaCollection() {
        return dopuszczeniaCollection;
    }

    public void setDopuszczeniaCollection(Collection<Dopuszczenia> dopuszczeniaCollection) {
        this.dopuszczeniaCollection = dopuszczeniaCollection;
    }

    public Administratorzy getAdministratorzyIdadministrator() {
        return administratorzyIdadministrator;
    }

    public void setAdministratorzyIdadministrator(Administratorzy administratorzyIdadministrator) {
        this.administratorzyIdadministrator = administratorzyIdadministrator;
    }

    public Kierownicy getKierownicyIdkierownicy() {
        return kierownicyIdkierownicy;
    }

    public void setKierownicyIdkierownicy(Kierownicy kierownicyIdkierownicy) {
        this.kierownicyIdkierownicy = kierownicyIdkierownicy;
    }

    @XmlTransient
    public Collection<Wypelnienia> getWypelnieniaCollection() {
        return wypelnieniaCollection;
    }

    public void setWypelnieniaCollection(Collection<Wypelnienia> wypelnieniaCollection) {
        this.wypelnieniaCollection = wypelnieniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsklepy != null ? idsklepy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sklepy)) {
            return false;
        }
        Sklepy other = (Sklepy) object;
        if ((this.idsklepy == null && other.idsklepy != null) || (this.idsklepy != null && !this.idsklepy.equals(other.idsklepy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sklepy[ idsklepy=" + idsklepy + " ]";
    }
    
}

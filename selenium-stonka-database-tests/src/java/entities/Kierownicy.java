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
@Table(name = "KIEROWNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kierownicy.findAll", query = "SELECT k FROM Kierownicy k")
    , @NamedQuery(name = "Kierownicy.findByIdkierownicy", query = "SELECT k FROM Kierownicy k WHERE k.idkierownicy = :idkierownicy")
    , @NamedQuery(name = "Kierownicy.findByImie", query = "SELECT k FROM Kierownicy k WHERE k.imie = :imie")
    , @NamedQuery(name = "Kierownicy.findByNazwisko", query = "SELECT k FROM Kierownicy k WHERE k.nazwisko = :nazwisko")
    , @NamedQuery(name = "Kierownicy.findByPesel", query = "SELECT k FROM Kierownicy k WHERE k.pesel = :pesel")
    , @NamedQuery(name = "Kierownicy.findByEmail", query = "SELECT k FROM Kierownicy k WHERE k.email = :email")
    , @NamedQuery(name = "Kierownicy.findByHaslo", query = "SELECT k FROM Kierownicy k WHERE k.haslo = :haslo")})
public class Kierownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKIEROWNICY")
    private Integer idkierownicy;
    @Size(max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 45)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PESEL")
    private String pesel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "HASLO")
    private String haslo;
    @JoinColumn(name = "ADMINISTRATORZY_IDADMINISTRATOR", referencedColumnName = "IDADMINISTRATORZY")
    @ManyToOne(optional = false)
    private Administratorzy administratorzyIdadministrator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kierownicyIdkierownicy")
    private Collection<Sklepy> sklepyCollection;

    public Kierownicy() {
    }

    public Kierownicy(Integer idkierownicy) {
        this.idkierownicy = idkierownicy;
    }

    public Kierownicy(Integer idkierownicy, String pesel, String email, String haslo) {
        this.idkierownicy = idkierownicy;
        this.pesel = pesel;
        this.email = email;
        this.haslo = haslo;
    }

    public Integer getIdkierownicy() {
        return idkierownicy;
    }

    public void setIdkierownicy(Integer idkierownicy) {
        this.idkierownicy = idkierownicy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Administratorzy getAdministratorzyIdadministrator() {
        return administratorzyIdadministrator;
    }

    public void setAdministratorzyIdadministrator(Administratorzy administratorzyIdadministrator) {
        this.administratorzyIdadministrator = administratorzyIdadministrator;
    }

    @XmlTransient
    public Collection<Sklepy> getSklepyCollection() {
        return sklepyCollection;
    }

    public void setSklepyCollection(Collection<Sklepy> sklepyCollection) {
        this.sklepyCollection = sklepyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkierownicy != null ? idkierownicy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kierownicy)) {
            return false;
        }
        Kierownicy other = (Kierownicy) object;
        if ((this.idkierownicy == null && other.idkierownicy != null) || (this.idkierownicy != null && !this.idkierownicy.equals(other.idkierownicy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Kierownicy[ idkierownicy=" + idkierownicy + " ]";
    }
    
}

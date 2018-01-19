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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ADMINISTRATORZY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administratorzy.findAll", query = "SELECT a FROM Administratorzy a")
    , @NamedQuery(name = "Administratorzy.findByIdadministratorzy", query = "SELECT a FROM Administratorzy a WHERE a.idadministratorzy = :idadministratorzy")
    , @NamedQuery(name = "Administratorzy.findByImie", query = "SELECT a FROM Administratorzy a WHERE a.imie = :imie")
    , @NamedQuery(name = "Administratorzy.findByNazwisko", query = "SELECT a FROM Administratorzy a WHERE a.nazwisko = :nazwisko")
    , @NamedQuery(name = "Administratorzy.findByEmail", query = "SELECT a FROM Administratorzy a WHERE a.email = :email")
    , @NamedQuery(name = "Administratorzy.findByPesel", query = "SELECT a FROM Administratorzy a WHERE a.pesel = :pesel")
    , @NamedQuery(name = "Administratorzy.findByHaslo", query = "SELECT a FROM Administratorzy a WHERE a.haslo = :haslo")})
public class Administratorzy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADMINISTRATORZY")
    private Integer idadministratorzy;
    @Size(max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 45)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PESEL")
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "HASLO")
    private String haslo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administratorzyIdadministrator")
    private Collection<Analitycy> analitycyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administratorzyIdadministrator")
    private Collection<Kierownicy> kierownicyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administratorzyIdadministrator")
    private Collection<Sklepy> sklepyCollection;

    public Administratorzy() {
    }

    public Administratorzy(Integer idadministratorzy) {
        this.idadministratorzy = idadministratorzy;
    }

    public Administratorzy(Integer idadministratorzy, String email, String pesel, String haslo) {
        this.idadministratorzy = idadministratorzy;
        this.email = email;
        this.pesel = pesel;
        this.haslo = haslo;
    }

    public Integer getIdadministratorzy() {
        return idadministratorzy;
    }

    public void setIdadministratorzy(Integer idadministratorzy) {
        this.idadministratorzy = idadministratorzy;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @XmlTransient
    public Collection<Analitycy> getAnalitycyCollection() {
        return analitycyCollection;
    }

    public void setAnalitycyCollection(Collection<Analitycy> analitycyCollection) {
        this.analitycyCollection = analitycyCollection;
    }

    @XmlTransient
    public Collection<Kierownicy> getKierownicyCollection() {
        return kierownicyCollection;
    }

    public void setKierownicyCollection(Collection<Kierownicy> kierownicyCollection) {
        this.kierownicyCollection = kierownicyCollection;
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
        hash += (idadministratorzy != null ? idadministratorzy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administratorzy)) {
            return false;
        }
        Administratorzy other = (Administratorzy) object;
        if ((this.idadministratorzy == null && other.idadministratorzy != null) || (this.idadministratorzy != null && !this.idadministratorzy.equals(other.idadministratorzy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Administratorzy[ idadministratorzy=" + idadministratorzy + " ]";
    }
    
}

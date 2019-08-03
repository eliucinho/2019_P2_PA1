/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcil3.aplicacion.entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author uth
 */
@Entity
@Table(name = "HUMANOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Humanos.findAll", query = "SELECT h FROM Humanos h")
    , @NamedQuery(name = "Humanos.findById", query = "SELECT h FROM Humanos h WHERE h.id = :id")
    , @NamedQuery(name = "Humanos.findByNombre", query = "SELECT h FROM Humanos h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Humanos.findByApellido", query = "SELECT h FROM Humanos h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "Humanos.findByPeso", query = "SELECT h FROM Humanos h WHERE h.peso = :peso")
    , @NamedQuery(name = "Humanos.findBySexo", query = "SELECT h FROM Humanos h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Humanos.findByDepartamento", query = "SELECT h FROM Humanos h WHERE h.departamento = :departamento")
    , @NamedQuery(name = "Humanos.findByMunicipio", query = "SELECT h FROM Humanos h WHERE h.municipio = :municipio")})

public class Humanos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "MUNICIPIO")
    private String municipio;

    public Humanos() {
    }

    public Humanos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humanos)) {
            return false;
        }
        Humanos other = (Humanos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hn.uth.pa1.parcil3.aplicacion.entidades.Humanos[ id=" + id + " ]";
    }
    
}

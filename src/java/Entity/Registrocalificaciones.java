/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "registrocalificaciones", catalog = "testiri", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrocalificaciones.findAll", query = "SELECT r FROM Registrocalificaciones r")
    , @NamedQuery(name = "Registrocalificaciones.findById", query = "SELECT r FROM Registrocalificaciones r WHERE r.id = :id")
    , @NamedQuery(name = "Registrocalificaciones.findByIdAlumno", query = "SELECT r FROM Registrocalificaciones r WHERE r.idAlumno = :idAlumno")
    , @NamedQuery(name = "Registrocalificaciones.findByNombreAlumno", query = "SELECT r FROM Registrocalificaciones r WHERE r.nombreAlumno = :nombreAlumno")
    , @NamedQuery(name = "Registrocalificaciones.findByNombreMateria", query = "SELECT r FROM Registrocalificaciones r WHERE r.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Registrocalificaciones.findByNombreMaestro", query = "SELECT r FROM Registrocalificaciones r WHERE r.nombreMaestro = :nombreMaestro")
    , @NamedQuery(name = "Registrocalificaciones.findByNumParcial", query = "SELECT r FROM Registrocalificaciones r WHERE r.numParcial = :numParcial")
    , @NamedQuery(name = "Registrocalificaciones.findByCalificacionParcial", query = "SELECT r FROM Registrocalificaciones r WHERE r.calificacionParcial = :calificacionParcial")})
public class Registrocalificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "idAlumno")
    private Integer idAlumno;
    //@Size(max = 45)
    @Column(name = "nombreAlumno", length = 45)
    private String nombreAlumno;
    //@Size(max = 45)
    @Column(name = "nombreMateria", length = 45)
    private String nombreMateria;
    //@Size(max = 45)
    @Column(name = "nombreMaestro", length = 45)
    private String nombreMaestro;
    @Column(name = "numParcial")
    private Integer numParcial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacionParcial", precision = 12, scale = 0)
    private Float calificacionParcial;

    public Registrocalificaciones() {
    }

    public Registrocalificaciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    public Integer getNumParcial() {
        return numParcial;
    }

    public void setNumParcial(Integer numParcial) {
        this.numParcial = numParcial;
    }

    public Float getCalificacionParcial() {
        return calificacionParcial;
    }

    public void setCalificacionParcial(Float calificacionParcial) {
        this.calificacionParcial = calificacionParcial;
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
        if (!(object instanceof Registrocalificaciones)) {
            return false;
        }
        Registrocalificaciones other = (Registrocalificaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Registrocalificaciones[ id=" + id + " ]";
    }
    
}

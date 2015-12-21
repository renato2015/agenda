/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fox W8
 */
@Entity
@Table(name = "contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanContato.findAll", query = "SELECT b FROM BeanContato b"),
    @NamedQuery(name = "BeanContato.findByIdContato", query = "SELECT b FROM BeanContato b WHERE b.idContato = :idContato"),
    @NamedQuery(name = "BeanContato.findByNome", query = "SELECT b FROM BeanContato b WHERE b.nome = :nome"),
    @NamedQuery(name = "BeanContato.findByTelefone", query = "SELECT b FROM BeanContato b WHERE b.telefone = :telefone")})
public class BeanContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contato")
    private Integer idContato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")    
    private String telefone;

    public BeanContato() {
    }

    public BeanContato(Integer idContato) {
        this.idContato = idContato;
    }

    public BeanContato(Integer idContato, String nome) {
        this.idContato = idContato;
        this.nome = nome;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanContato)) {
            return false;
        }
        BeanContato other = (BeanContato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.BeanContato[ idContato=" + idContato + " ]";
    }
    
}

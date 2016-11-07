package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "teste")
public class Teste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "teste_nome")
    private String testeNome;
    
    @Column(name = "teste_endereco")
    private String testeEndereco;
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teste_id")
    private Integer testeId;

    public Teste(Integer testeId, String testeNome, String testeEndereco) {
        this.testeNome = new String();
        this.testeEndereco = new String();
        this.testeId = testeId;
        this.testeNome = testeNome;
        this.testeEndereco = testeEndereco;
    }

    public Teste() {
       
    }

    
    public String getTesteNome() {
        return testeNome;
    }

    public void setTesteNome(String testeNome) {
        this.testeNome = testeNome;
    }

    
    public String getTesteEndereco() {
        return testeEndereco;
    }

    public void setTesteEndereco(String testeEndereco) {
        this.testeEndereco = testeEndereco;
    }

   
    public Integer getTesteId() {
        return testeId;
    }

    public void setTesteId(Integer testeId) {
        this.testeId = testeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testeId != null ? testeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teste)) {
            return false;
        }
        Teste other = (Teste) object;
        if ((this.testeId == null && other.testeId != null) || (this.testeId != null && !this.testeId.equals(other.testeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Teste[ testeId=" + testeId + " ]";
    }

}

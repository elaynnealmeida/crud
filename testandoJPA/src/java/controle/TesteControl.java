
package controle;

import dao.TesteDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Teste;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class TesteControl implements Serializable{

    private Teste teste;
    private TesteDAO testeDao;
    private List<Teste> testes;
    private DataTable dtable;
    private Teste selecionado;

    @PostConstruct
    public void init() {       
        this.teste = new Teste();
        this.testeDao = new TesteDAO();
        this.selecionado = new Teste();
        dtable = new DataTable();
        testes = listar();
    }

    public TesteControl() {
        //this.teste = new Teste();
        //this.testeDao = new TesteDAO();
    }

    public void limpar() {
        this.teste = new Teste();
        listar();
    }

    public void salvar() {
       // System.out.println("Entrou no control: " + teste.getTesteNome());
        testeDao.salvar(teste);
        limpar();
    }

    public void atualizar() {
        testeDao.atualizar(teste);
        limpar();
    }

    public void deletar() {
        testeDao.deletar(teste);
        limpar();
    }

    public List<Teste> listar() {
       // System.out.println("entrou no control listar-----------");
        this.testes = testeDao.listarTodos();
        return this.testes;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public List<Teste> getTestes() {
        return testes;
    }

    public void setTestes(List<Teste> testes) {
        this.testes = testes;
    }

    public DataTable getDtable() {
        return dtable;
    }

    public void setDtable(DataTable dtable) {
        this.dtable = dtable;
    }

    public void onRowSelect(SelectEvent event) {
        this.teste = ((Teste) event.getObject());
        FacesMessage msg = new FacesMessage("Car Selected", ((Teste) event.getObject()).getTesteNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        this.teste = ((Teste) event.getObject());
        FacesMessage msg = new FacesMessage("Car Unselected", ((Teste) event.getObject()).getTesteNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Teste getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Teste selecionado) {
        this.selecionado = selecionado;
    }

}

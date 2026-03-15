package controller;

import java.util.List;
import model.Banco;
import model.Veiculo;

public class VeiculoDAO {

    public void gravar(Object obj) throws Exception {
        Banco bb;
        try {
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            bb.sessao.persist(obj);
            bb.sessao.getTransaction().commit();
            Banco.conexao.close();
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar: " + ex.getMessage());
        }
    }

    public void alterar(Object obj) throws Exception {
        Banco bb;
        try {
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            bb.sessao.merge(obj);
            bb.sessao.getTransaction().commit();
            Banco.conexao.close();
       } catch (Exception ex) {
            throw new Exception("Erro ao alterar: " + ex.getMessage());
        } 
    }

    public void remover(Class tipo, int id) throws Exception {
        Banco bb;
        Object obj;
        try {
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            obj = bb.sessao.find(tipo, id);
            if (obj != null) {
                bb.sessao.remove(obj);
            }
            bb.sessao.getTransaction().commit();
            Banco.conexao.close();
        } catch (Exception ex) {
            throw new Exception("Erro ao remover: " + ex.getMessage());
        } 
    }

    public Object getById(Class tipo, final int id) throws Exception {
        Banco bb;
        Object obj;
        try {
            bb = new Banco();
            obj = bb.sessao.find(tipo, id);
            Banco.conexao.close();
            return obj;
        } catch (Exception ex) {
            throw new Exception("Erro ao getById: " + ex.getMessage());
        } finally {

        }

    }

    public List<Veiculo> listar() throws Exception {
        Banco bb;
        List<Veiculo> lista;
        try {
            bb = new Banco();
            lista = bb.sessao.createNamedQuery("Veiculo.findAll", Veiculo.class).getResultList();
            Banco.conexao.close();
            return lista;
        } catch (Exception ex) {
            throw new Exception("Erro ao listarTodos: " + ex.getMessage());
        }
    }
}

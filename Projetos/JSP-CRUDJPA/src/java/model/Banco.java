package model;

import javax.persistence.*;

/**
 *
 * @author prampero
 */
public class Banco {

    public static EntityManagerFactory conexao = null;
    public EntityManager sessao;
    
    private final String nomeArqPersistence = "JSPCRUDJPAPU";

    public Banco() throws Exception {
        try {
            if ((conexao == null) || (!conexao.isOpen())) {
                conexao = Persistence.createEntityManagerFactory(nomeArqPersistence);
            }
            sessao = conexao.createEntityManager();
    
        } catch (Exception ex) {
            throw new Exception("Erro de conexão: " + ex.getMessage());
        }
    }

}

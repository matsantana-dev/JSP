/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;//IMPORTANTE INCLUIR
import java.sql.Statement;//IMPORTANTE INCLUIR
import model.Banco;
import model.Veiculo;
//.next() --> percorre a tabela
//TYPE_SCROLL_INSENSITIVE --> deixa o cursor navegável

public class VeiculoDAO {

    public int gravar(Veiculo veiculo) throws Exception {
        Banco banco;
        int qtde=0;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("Insert into veiculo(descr, ano,preco) values(?,?,?)");
            banco.comando.setString(1, veiculo.getDescr());
            banco.comando.setInt(2, veiculo.getAno());
            banco.comando.setDouble(3, veiculo.getPreco());
            qtde=banco.comando.executeUpdate();
            
            Banco.conexao.close();
            return(qtde);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar() veículo: " + ex.getMessage());
        }
    }

    public void gravarR(Veiculo veiculo) throws Exception {
        Banco banco;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("Insert into veiculo(descr, ano,preco) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            banco.comando.setString(1, veiculo.getDescr());
            banco.comando.setInt(2, veiculo.getAno());
            banco.comando.setDouble(3, veiculo.getPreco());
            banco.comando.execute();
            banco.tabela = banco.comando.getGeneratedKeys();
            if (banco.tabela.next()) {
                veiculo.setCodigo(banco.tabela.getInt(1));
                banco.tabela.close();
            } else {
                throw new Exception(" Erro ao capturar Veículo cadastrado.");
            }
            Banco.conexao.close();
        } catch (Exception ex) {
            throw new Exception(" Erro ao gravarR() veículo: " + ex.getMessage());
        }
    }

    public void gravarR2(Veiculo veiculo) {
        Banco banco;

        try {
banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("Insert into veiculo(codigo,descr, ano,preco) values(DEFAULT,?,?,?) RETURNING codigo");
             banco.comando.setString(1, veiculo.getDescr());
            banco.comando.setInt(2, veiculo.getAno());
            banco.comando.setDouble(3, veiculo.getPreco());
            banco.tabela = banco.comando.executeQuery();
            Banco.conexao.close();
            banco.tabela.next();
            //Pega o código gerado pelo banco e o coloca no cliente
            veiculo.setCodigo(banco.tabela.getInt("codigo"));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao gravarR2: " + ex.getMessage());
        }
    }
    public int alterar(Veiculo veiculo) throws Exception {
        Banco banco;
        int qtde=0;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("Update veiculo set descr=?, ano=?, preco=? where codigo =?");
            banco.comando.setString(1, veiculo.getDescr());
            banco.comando.setInt(2, veiculo.getCodigo());
            banco.comando.setInt(3, veiculo.getAno());
            banco.comando.setDouble(4, veiculo.getPreco());
            qtde= banco.comando.executeUpdate();
            Banco.conexao.close();
            return(qtde);
        } catch (Exception ex) {
            throw new Exception("Erro ao alterar veículo: " + ex.getMessage());
        }
    }
    
    public int remover(int  codigo) throws Exception {
        Banco banco;
        int qtde=0;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("Delete from veiculo where codigo =?");
            banco.comando.setInt(1, codigo);
            qtde= banco.comando.executeUpdate();
            Banco.conexao.close();
            return(qtde);
        } catch (Exception ex) {
            throw new Exception("Erro ao remover veículo: " + ex.getMessage());
        }
    }
    

    public Veiculo preencher(int codigo) throws Exception {
        Banco banco;
            Veiculo veiculo = null;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement(
                    "Select codigo,descr,ano,preco from veiculo where codigo=?");
            banco.comando.setInt(1, codigo);
            banco.tabela = banco.comando.executeQuery();
            if ((banco.tabela != null) && (banco.tabela.next())) {
                veiculo = new Veiculo();
                veiculo.setCodigo( banco.tabela.getInt(1));
                veiculo.setDescr(banco.tabela.getString(2));
                veiculo.setAno(banco.tabela.getInt(3));
                veiculo.setPreco(banco.tabela.getDouble(4));
            } 
            Banco.conexao.close();
            return(veiculo);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar: " + ex.getMessage());
        }
    }

    public ResultSet listar() throws Exception {
        Banco banco;
        try {
            banco = new Banco();
            // cria um resultset navegável
            banco.comando = Banco.conexao.prepareStatement("Select codigo,descr,ano, preco from veiculo", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            banco.tabela = banco.comando.executeQuery();
            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro de consultar " + ex.getMessage());
        }
    }

    public String geraSql(int codigo, String nome, int idade) {
        String aux = "";
        try {
            if (codigo > 0) {
                aux += " codigo = " + codigo;
            }
            if ((nome != null) && (nome.length() > 0)) {
                if (aux.length() > 0) {
                    aux = aux + " and ";
                }
                aux += " nome like " + "'%" + nome + "%'";
            }
            if (idade > 0) {
                if (aux.length() > 0) {
                    aux = aux + " and ";
                }
                aux += " idade >= " + idade;
            }
            if (aux.length() > 0) {
                aux = " where " + aux;
            }
            if (aux.length() > 0) {
                aux = "Select codigo, nome, idade from cliente " + aux;
            } else {
                aux = "Select codigo, nome, idade from cliente ";
            }
            return (aux);
        } catch (Exception ex) {
            return ("Erro: " + ex.getMessage());
        }

    }

    public ResultSet consultarVariosCamposSimples(int codigo, String nome, int idade) throws Exception {
        Banco banco;
        String aux = "";
   
        try {
            banco = new Banco();
            if (codigo > 0) {
                aux += " codigo = " + codigo;
            }
            if ((nome != null) && (nome.length() > 0)) {
                if (aux.length() > 0) {
                    aux = aux + " and ";
                }
                aux += " nome like " + "'%" + nome + "%'";
            }
            if (idade > 0) {
                if (aux.length() > 0) {
                    aux = aux + " and ";
                }
                aux += " idade >= " + idade;
            }
            if (aux.length() > 0) {
                aux = " where " + aux;
            }
            if (aux.length() > 0) {
                aux = "Select codigo, nome, idade from cliente " + aux;
            } else {
                aux = "Select codigo, nome, idade from cliente ";
            }
         
            banco.comando = Banco.conexao.prepareStatement(aux);
            banco.tabela = banco.comando.executeQuery();
            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro de consultaVariosCamposSimples " + ex.getMessage());
        }
    }

    public ResultSet consultarVariosCampos(int codigo, String nome, int idade) throws Exception {
        Banco banco;
        String aux = "";
        int cont = 0, i = 0;
        try {
            banco = new Banco();
            //no passo 0 monta o sql, no passo 1 coloca os parâmetros 
            while (i < 2) {
                if (codigo > 0) {
                    if (i == 0) {
                        aux += " codigo = ?";
                    } else {
                        cont++;
                        banco.comando.setInt(cont, codigo);
                    }
                }
                if ((nome != null) && (nome.length() > 0)) {

                    if (i == 0) {
                        if (aux.length() > 0) {
                            aux = aux + " and ";
                        }
                        aux += " nome like ? ";
                    } else {
                        cont++;
                        banco.comando.setString(cont, "%" + nome + "%");
                    }
                }
                if (idade > 0) {

                    if (i == 0) {
                        if (aux.length() > 0) {
                            aux = aux + " and ";
                        }
                        aux += " idade >= ? ";
                    } else {
                        cont++;
                        banco.comando.setInt(cont, idade);
                    }
                }

                if (i == 0) {
                    if (aux.length() > 0) {
                        aux = " where " + aux;
                    }
                    if (aux.length() > 0) {
                        aux = "Select codigo, nome, idade from cliente " + aux;
                    } else {
                        aux = "Select codigo, nome, idade from cliente ";
                    }
                    banco.comando = Banco.conexao.prepareStatement(aux);
                }
                i++;
            }
         
            banco.tabela = banco.comando.executeQuery();

            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro de consultaVariosCampos " + ex.getMessage());
        }
    }

    public String gerarTabela(ResultSet tabela) {
        String s = "";
        int i;
        try {
            s = "<table  align='center' border='1' cellspacing='1' cellpadding='5'><thead><tr>";
            for (i = 1; i <= tabela.getMetaData().getColumnCount(); i++) {
                s += "<th>" + tabela.getMetaData().getColumnName(i).toUpperCase() + "</th>";
            }
            s += "</tr></thead><tbody>";
            //tabela.beforeFirst();// posiciona precisa de ResultSet navegável
            while (tabela.next()) {
                s += "<tr>";
                for (i = 1; i <= tabela.getMetaData().getColumnCount(); i++) {
                    switch (tabela.getMetaData().getColumnType(i)) {
                        case java.sql.Types.INTEGER:
                            s += "<td>" + tabela.getInt(i) + "</td>";
                            break;
                        case java.sql.Types.DOUBLE:
                            s += "<td>" + tabela.getDouble(i) + "</td>";
                            break;
                        case java.sql.Types.DATE:
                            s += "<td>" + tabela.getDate(i) + "</td>";
                            break;
                        default:
                            s += "<td>" + tabela.getString(i) + "</td>";
                            break;
                    }
                }
                s += "</tr>";
            }
            s += "</tbody></table>";
        } catch (Exception ex) {
            s = "<h1>Erro ao gerarTabela :" + ex.getMessage() + "</h1>";
        }
        return (s);
    }

}

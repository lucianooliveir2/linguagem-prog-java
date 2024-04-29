

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Luciano Oliveira
 */

public class BancoDeDados {
  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultset = null;


  public void conectar() {
    String servidor = "jdbc:mysql://localhost:3306/agenda";
    String usuario = "root";
    String senha = "Coxinha123@";
    String driver = "com.mysql.cj.jdbc.Driver";

    try{
      Class.forName(driver);
      this.connection = DriverManager.getConnection(servidor, usuario, senha);
      this.statement = this.connection.createStatement();
      System.out.println("Conectado...");
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public void desconectar(){
    try{
      this.connection.close();
      System.out.println("Desconectado com sucesso.....");
    } catch (Exception e){
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public void inserir(String nome, String email, String telefone) {
    try {
      String query = "INSERT INTO agenda.cadastro (nome, email, telefone) VALUES ('" + nome + "','" + email + "','" + telefone + "')";
      this.statement.execute(query);
      System.out.println("Dados inseridos com sucesso");
    } catch (Exception e){
      System.out.println("Erro: " + e.getMessage());           
    }
  }

  public void listarTudo(){
    try {
      String query = "SELECT * FROM agenda.cadastro ORDER BY id ASC";
      this.resultset = this.statement.executeQuery(query);
      while(this.resultset.next()){
        System.out.println("ID: " + this.resultset.getString("id") + "\nNome: " + this.resultset.getString("nome") + "\nEmail: " + this.resultset.getString("email") + "\nTelefone: " + this.resultset.getString("telefone"));
      }

    } catch (Exception e){
      System.out.println("Erro: " + e.getMessage());           
    }
  }

  public void pesquisar(String id){
    try {
      String query = "SELECT * FROM agenda.cadastro WHERE id = " + id + " ORDER BY id ASC;";
      this.resultset = this.statement.executeQuery(query);
      while(this.resultset.next()){
        System.out.println("ID: " + this.resultset.getString("id") + "\nNome: " + this.resultset.getString("nome") + "\nEmail: " + this.resultset.getString("email") + "\nTelefone: " + this.resultset.getString("telefone"));
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e.toString());
    }
  }

  public void alterar(String id, String nome, String email, String telefone) {
    try {
      String query = String.format("UPDATE agenda.cadastro SET nome='%s', email='%s', telefone = '%s' WHERE id = %s;", nome, email, telefone, id);
      // String query = "UPDATE agenda.cadastro SET nome=juvenal, email=juvenal@juvenal.com WHERE id=2";
      System.out.println(query);
      this.statement.executeUpdate(query);
      

      System.out.println("Dados inseridos com sucesso");
    } catch (Exception e){
      System.out.println("Erro: " + e.getMessage());           
    }
  }

  public void excluir(String id) {
    try {
      String query = "DELETE FROM agenda.cadastro WHERE id = " + id + ";";
      this.statement.execute(query);
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}

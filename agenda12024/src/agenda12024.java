/**
 * programa para
 * @author Kaio Henrique
 * criado em 08/04/2024
 */
public class agenda12024 {
    public static void main(String[]args) {
        BancoDeDados bancodedados = new BancoDeDados();
        bancodedados.conectar();
        // bancodedados.inserir("teste", "teste@teste.com", "1112341234");
        // bancodedados.excluir("1");
        bancodedados.pesquisar("3");
        bancodedados.alterar("2", "teste", "test@test.co", "12312312");
        bancodedados.desconectar();

        
    }
}

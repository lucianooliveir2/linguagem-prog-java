/**
 * programa para
 * @author Luciano Augusto de Oliveira
 * criado em 08/04/2024
 */
public class agenda12024 {
    public static void main(String[]args) {
        BancoDeDados bancodedados = new BancoDeDados();
        bancodedados.luciano_conectar();
        bancodedados.luciano_inserir("teste", "teste@teste.com", "1112341234");
        bancodedados.luciano_excluir("7");
        bancodedados.luciano_listarTudo();
        bancodedados.luciano_pesquisar("3");
        bancodedados.luciano_alterar("2", "teste", "test@test.co", "12312312");
        bancodedados.luciano_desconectar();

        
    }
}

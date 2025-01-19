// Importação principal que eu uso para pesquisar os lugares no google maps!
import javax.swing.JOptionPane;

/**
 * Classe principal para rodar o código!
 * @author João Rafael 
 */
public class Main {
    
    /** 
     * Classe main:
     * @param args
     * @throws Exception Preciso lançar uma exceção para caso o usuário digite um valor inválido ao pesquisar o nome do lugar
     */
    public static void main(String[] args) throws Exception {
        Lugar lugar = new Lugar();
        
        lugar.setName(tela("Informe o nome do local!"));  
        while (true) {
            try {                   
                String avaliacao = tela("Adicione sua avaliação, quando quiser continuar apenas clique em cancelar");
                lugar.addAvaliation(Integer.parseInt(avaliacao));
            }
            // Faço uma exceção expecífica para caso o usuário digite a avaliação errada do lugar
            catch (NumberFormatException e) {
                // Aqui, eu não exibo a menssagem de erro, e vou direto para o resto do código
                break;
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null , e);
                break;
            }
        } 
        JOptionPane.showMessageDialog(null , lugar);
        lugar.mostrarLugarNoMapa(lugar.getName());

    }

    /**
     * Função que exibe um input de texto para o usuário digitar
     * @param texto Nome de um lugar qualquer
     * @return Retorna este nome para o código
     */
    public static String tela (String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    /**
     * Função que exibe uma mensagem para o usuário
     * @param texto Texto exibido
     */
    public static void telaMenssagem (String texto) {
        JOptionPane.showMessageDialog(null , texto);
    }
    

}
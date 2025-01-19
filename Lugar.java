
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;

public class Lugar {

    private String name;
    private ArrayList<Integer> avaliation ;

    /**
     * Pegando o nome real do lugar, sem as modificações para expor pro usuário
     *
     * @return Retorna o nome do lugar, sem as modificações
     */
    private String getRealName() {
        return name.replace("+", " ");
    }

    /**
     * Recebendo o nome do lugar
     *
     * @return Retorna o nome do lugar
     */
    public String getName() {
        return name;
    }

    /**
     * Definindo o nome do lugar e modificando o valor para pesquisar
     *
     * @param name Nome do lugar sem as mudanças
     */
    public void setName(String name) {
        // O + é a mesma coisa que o espaço " ", mas eu poderia substituir por "%20" que é o mesmo que o espaço em url!
        String newName = name.replace(" ", "+");
        this.name = newName;
    }

    /**
     * Adicionando uma avaliação ao lugar
     *
     * @param avaliation Este é o valor deve ser um número inteiro digitado pelo
     * usuário
     */
    public void addAvaliation(Integer avaliation) {
        if (avaliation < 0 || avaliation > 5) {
            // caso a avaliação seja maior, eu já crio uma exceção para que lá no meu código main, ela pare o código do try
            // como é algo simples de resolver, não tem o por que eu usar a declaração de que o código pode ser perigoso "throws Exception", então eu uso o RuntimeException que não precisa de declaração!
            throw new RuntimeException("Avaliação deve ser entre 0 a 5 estrelas!");
        } else {
            this.avaliation.add(avaliation);
        }
    }

    /**
     * Recebendo o número total de avaliações
     *
     * @return Retorna este número
     */
    public Integer getAmountAvaliation() {
        return this.avaliation.size();
    }

    /**
     * Somando o valor total de avaliações
     *
     * @return Retorna esse valor
     */
    private Double getTotalAvaliation() {
        Double todasAvaliacoes = 0d;
        for (Integer avaliacao : this.avaliation) {
            todasAvaliacoes += avaliacao;
        }
        return todasAvaliacoes;
    }

    /**
     * Fazendo a média das avaliações
     *
     * @return Retorna a média
     */
    public Double getAvaliation() {
        return getTotalAvaliation() / getAmountAvaliation();
    }

    /**
     * Definindo o status do lugar baseado nas avaliações
     *
     * @return Retorna o status em forma de texto
     */
    public String getAvaliationStatus() {
        if (getAvaliation() < 3) {
            return "Ruim!";
        } else if (getAvaliation() >= 3 || getAvaliation() <= 4) {
            return "Razoavel!";
        } else if (getAvaliation() > 4) {
            return "Bom! :)";
        } else {
            return "Sem avaliações disponíveis!";
        }
    }

    /**
     * Mostrando o lugar no google maps
     *
     * @param lugar Nome do lugar que será pesquisado
     * @throws Exception Caso o lugar não exista, ou o google maps não consiga
     * abrir a página
     */
    public void mostrarLugarNoMapa(String lugar) throws Exception {
        // Essa função faz a busca do nome pelo google maps.
        // Escolhi coloca-la dentro desta função para facilitar na hora de ler o código, já que a sintaxe é meio confusa!
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/" + getName()));
    }

    @Override
    /**
     * Transformo meu objeto em string para mostrar pro usuário no display
     * retorna o nome do lugar, a quantidade de avaliações, a média de
     * avaliações e o status do lugar!
     */
    public String toString() {
        return "Nome :" + getRealName() + "\nTotal de Avaliações: " + getAmountAvaliation() + "\nMédia de Avaliações :" + getAvaliation() + "\nStatus: " + getAvaliationStatus();
    }

}

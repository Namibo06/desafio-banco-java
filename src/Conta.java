import lombok.Getter;
import lombok.ToString;

@ToString
public abstract class Conta implements IConta{
    //static = tenha relação com a contaCorrente e não com a instância
    //que é controlado pela propria classe

    @ToString.Exclude
    private static final int AGENCIA_PADRAO = 0001;
    @ToString.Exclude
    private static int SEQUENCIAL = 1;
    @Getter
    @ToString.Exclude
    protected int agencia;
    @Getter
    protected int conta;
    @Getter
    @ToString.Exclude
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente=cliente;
    }

    @Override
    public void sacar(double valor) {
        if (saldo > 0){
            if(valor <= saldo){
                this.saldo = saldo - valor;
                System.out.println("Saque no valor de R$"+valor+" realizado com  sucesso!");
            }else{
                System.out.println("Não foi possível efetuar o saque,valor acima do que está no saldo");
            }
        }else{
            System.out.println("Conta zerada,não pode efetuar o saque");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo = saldo + valor;
        System.out.println("Déposito no valor de R$"+valor+" realizado com  sucesso!");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo > 0){
            if(valor <= saldo ){
                this.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso para conta "+contaDestino+",que tem como titular "+cliente.getNome()+" ,no valor de R$"+valor);
            }else{
                System.out.println("Não foi possível efetuar a transferência,valor acima do que está no saldo");
            }
        }else{
            System.out.println("Conta zerada,não pode efetuar a transferência");
        }
    }

    protected void imprimirInformacoesComum() {
        System.out.println(String.format("Titular: %s",cliente.getNome()));
        System.out.println(String.format("Agencia: %d",agencia));
        System.out.println(String.format("Conta: %d",conta));
        System.out.println(String.format("Saldo: %.2f",saldo));
    }

    @Override
    public String toString() {
        return ""+conta+"";
    }
}

public class Main {
    public static void main(String[] args) {
        /*
        * Polimorfismo é utilizar a hierárquia ao seu favor,
        * poderia usar em vez de Conta,poderia utilizar IConta
        * e não daria error porque ContaCorrente extende Conta
        * que ao mesmo tempo implementa IConta,então poderia passar
        * IConta nos argumentos e colocar aqui tranquilo
        * */
        Cliente joca=new Cliente();
        joca.setNome("Joca");
        Cliente lili=new Cliente();
        lili.setNome("Lili");

        Conta cc = new ContaCorrente(joca);
       // cc.imprimirExtrato();

        Conta cp = new ContaPoupanca(joca);
        Conta cp2 = new ContaPoupanca(lili);
        cp.imprimirExtrato();
        cp.depositar(20);
        cp.transferir(20,cp2);

        cc.imprimirExtrato();
        cp2.imprimirExtrato();
    }
}

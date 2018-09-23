package br.com.tap.roteiro;
import br.com.tap.roteiro.Motorista;
import br.com.tap.roteiro.Objeto;
import br.com.tap.roteiro.Roteiro;
import br.com.tap.roteiro.Veiculo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Controle controle = new Controle();
        boolean doIt = true;
        Scanner entrada = new Scanner(System.in);
        
        
        while (doIt) {
            System.out.println("Digite a opÃ§Ã£o desejada:"
                    + "\n1 - Cadastrar objeto para entrega"
                    + "\n2 - Cadastrar novo motorista"
                    + "\n3 - Cadastrar novo veiculo"
                    + "\n4 - Gerar roteiro para entrega"
                    + "\n5 - Dar baixa em roteiro de entrega"
                    + "\n6 - vincular motorista e veiculo"
                    + "\n7 - desvincular motorista e veiculo"
                    + "\n8 - Buscar por roteiros antigos (por data e/ou motorista)");
            int perg = entrada.nextInt();
            
            switch (perg) {
                case 1:
                    controle.setListaObjetos(controle.deserializarObjetos());
                    Objeto obj = new Objeto();
                    controle.cadastrarObj(obj, controle.getListaObjetos()); //TUDO ESTÃ� SENDO CADASTRADO CERTINHO
                    controle.serializadorObjetos(controle.getListaObjetos());
                    break;
                case 2:
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    Motorista motorista = new Motorista();
                    controle.cadastrarMotorista(motorista, controle.getListaMotoristas());  //FEITO
                    controle.serializadorMotorista(controle.getListaMotoristas());
                    break;

                case 3:
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    Veiculo veiculo = new Veiculo();
                    controle.cadastrarVeiculo(veiculo, controle.getListaVeiculos());    //FEITO
                    controle.serializadorVeiculos(controle.getListaVeiculos());
                    break;

                case 4:
                    controle.setListaRoteiros(controle.deserializarRoteiro());
                    controle.setListaObjetos(controle.deserializarObjetos());
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    
                    controle.gerarRoteiro(controle.getListaRoteiros(), controle.getListaObjetos(), controle.getListaMotoristas());
                    
                    controle.serializadorObjetos(controle.getListaObjetos());
                    controle.serializadorMotorista(controle.getListaMotoristas());
                    controle.serializadorVeiculos(controle.getListaVeiculos());
                    controle.serializarRoteiro(controle.getListaRoteiros());
                    break;

                case 5:
                    controle.setListaRoteiros(controle.deserializarRoteiro());
                    controle.setListaObjetos(controle.deserializarObjetos());
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    controle.setListaRoteirosAnteriores(controle.deserializarRoteiroAntigo());
                    
                    controle.darBaixaRoteirosDoDia(controle.getListaRoteiros(), controle.getListaRoteirosAnteriores(),controle.getListaObjetos());
                    
                    controle.serializadorObjetos(controle.getListaObjetos());
                    controle.serializadorMotorista(controle.getListaMotoristas());
                    controle.serializadorVeiculos(controle.getListaVeiculos());
                    controle.serializarRoteiro(controle.getListaRoteiros());
                    controle.serializarRoteiroAntigo(controle.getListaRoteirosAnteriores());
                    break;

                case 6:
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    
                    controle.gerenciarVinculo(controle.getListaMotoristas(), controle.getListaVeiculos());  //FEITO
                    
                    controle.serializadorMotorista(controle.getListaMotoristas());
                    controle.serializadorVeiculos(controle.getListaVeiculos());
                    break;

                case 7:
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    
                    controle.desvinculacao(controle.getListaMotoristas());  //FEITO
                    
                    controle.serializadorMotorista(controle.getListaMotoristas());
                    controle.serializadorVeiculos(controle.getListaVeiculos());
                    break;
                    
                case 8:
                    controle.setListaRoteiros(controle.deserializarRoteiro());
                    controle.setListaObjetos(controle.deserializarObjetos());
                    controle.setListaMotoristas(controle.deserializarMotorista());
                    controle.setListaVeiculos(controle.deserializarVeiculos());
                    controle.setListaRoteirosAnteriores(controle.deserializarRoteiroAntigo());
                    
                    controle.mostrarRoteirosAnteriores(controle.getListaRoteirosAnteriores());
                    
                    controle.serializarRoteiroAntigo(controle.getListaRoteirosAnteriores());
                    break;
            }
        }
    }
}

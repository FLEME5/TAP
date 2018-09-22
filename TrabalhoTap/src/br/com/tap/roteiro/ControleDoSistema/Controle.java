package br.com.tap.roteiro.ControleDoSistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.tap.roteiro.Endereco;
import br.com.tap.roteiro.Motorista;
import br.com.tap.roteiro.Objeto;
import br.com.tap.roteiro.Roteiro;
import br.com.tap.roteiro.Veiculo;

public class Controle implements Serializable {

    private static final long serialVersionUID = 123123L;
    private ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
    private ArrayList<Motorista> listaMotoristas = new ArrayList<Motorista>();
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    private ArrayList<Roteiro> listaRoteiros = new ArrayList<Roteiro>();
    private ArrayList<Roteiro> listaRoteirosAnteriores = new ArrayList<Roteiro>();

    public ArrayList<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public ArrayList<Motorista> getListaMotoristas() {
        return listaMotoristas;
    }

    public void setListaMotoristas(ArrayList<Motorista> listaMotoristas) {
        this.listaMotoristas = listaMotoristas;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public ArrayList<Roteiro> getListaRoteiros() {
        return listaRoteiros;
    }

    public void setListaRoteiros(ArrayList<Roteiro> listaRoteiros) {
        this.listaRoteiros = listaRoteiros;
    }

    public ArrayList<Roteiro> getListaRoteirosAnteriores() {
        return listaRoteirosAnteriores;
    }

    public void setListaRoteirosAnteriores(ArrayList<Roteiro> listaRoteirosAnteriores) {
        this.listaRoteirosAnteriores = listaRoteirosAnteriores;
    }

    //CADASTRO DE ENDEREÃ‡O NORMAL
    public static Endereco registrarEndereco(Endereco endereco) {
        Scanner entrada = new Scanner(System.in);
        endereco = new Endereco();
        System.out.println("Digite o estado: ");
        String aux = entrada.nextLine();
        endereco.setEstado(aux);
        System.out.println("Digite a cidade:");
        aux = entrada.nextLine();
        endereco.setCidade(aux);
        System.out.println("Digite o bairro:");
        aux = entrada.nextLine();
        endereco.setBairro(aux);
        System.out.println("Digite a rua:");
        aux = entrada.nextLine();
        endereco.setRua(aux);
        System.out.println("Digite o CEP:");
        aux = entrada.nextLine();
        endereco.setCep(aux);
        return endereco;
    }

    //AQUI ESTÃ� TODA A PARTE DE CADASTRAMENTO DOS OBJETOS
    public static void cadastrarObj(Objeto obj, List<Objeto> listaObjetos) {   //1.3 CADASTRO GERAL
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do REMETENTE:");
        String aux = entrada.nextLine();
        obj.setNomeRemetente(aux);
        System.out.println("a seguir, digite o endereÃ§o do REMETENTE.");
        obj.setEnderecoRemetente(registrarEndereco(obj.getEnderecoRemetente()));
        System.out.println("Digite o nome do DESTINATÃ�RIO:");
        aux = entrada.nextLine();
        obj.setNomeDestinatario(aux);
        System.out.println("a seguir, digite o endereÃ§o do DESTINATÃ�RIO");
        obj.setEnderecoDestinatario(registrarEndereco(obj.getEnderecoDestinatario()));
        System.out.println("Digite o peso do objeto");
        aux = entrada.nextLine();
        obj.setPeso(aux);
        System.out.println("Digite o dia:");
        aux = entrada.nextLine();
        String auxDia = aux;
        System.out.println("Digite o mÃªs:");
        aux = entrada.nextLine();
        String auxMes = aux;
        System.out.println("Digite o ano:");
        aux = entrada.nextLine();
        String auxAno = aux;
        String data = auxDia + "/" + auxMes + "/" + auxAno;
        obj.setDataDeposito(data);
        System.out.println("Digite o cÃ³digo localizador (caso nada seja digitado, o sistema gerarÃ¡ um automaticamente):");
        int aux2 = 0;
        String aux3;
        aux3 = entrada.nextLine();
        aux2 = randomico(aux2, aux3);
        if(aux3==null){
            obj.setCodigoLocal(Integer.toString(aux2));
        }else{
            obj.setCodigoLocal(aux3);
        }
        listaObjetos.add(obj);
    }

    public static int randomico(int aux2, String aux3) {
        if (aux3.isEmpty()) {
            int rand = new Random().nextInt((999999 - 100000) + 1) + 100000;
            Integer.toString(rand);
            aux2 = rand;
            System.out.println("cÃ³digo localizador gerado: " + aux2);
        }
        return aux2;
    }
    //AQUI TERMINA A PARTE DE CADASTRAMENTO DOS ITENS PARA ENTREGA

    private static void criarPastaObjeto() { //SE O DIRETÃ“RIO EXISTIR ELE NÃƒO FAZ NADA
        File raiz = new File("Gravuras/");
        boolean existeRaiz = raiz.exists();
        if (existeRaiz == false) {
            raiz.mkdir();
        }
        File nutela = new File("Gravuras/Objetos");
        boolean existeNutela = nutela.exists();
        if (existeNutela == false) {
            nutela.mkdir();
        }
    }

    public static void serializadorObjetos(List<Objeto> listaObjetos) {
        criarPastaObjeto();
        File arq = new File("Gravuras/Objetos/objetos.bin");
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaObjetos);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Objeto> deserializarObjetos() {
        ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
        try {
            File arq = new File("Gravuras/Objetos/objetos.bin");
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                listaObjetos = (ArrayList<Objeto>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return (listaObjetos);
    }
    //AQUI ENCERRA A PARTE DOS OBJETOS

    //AQUI COMEÃ‡A TODO O CADASTRO DOS MOTORISTAS
    public void cadastrarMotorista(Motorista motorista, ArrayList<Motorista> listaMotoristas) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do motorista");
        String aux = entrada.nextLine();
        motorista.setNome(aux);
        System.out.println("a seguir, digite o endereÃ§o do motorista.");
        motorista.setEndereco(registrarEndereco(motorista.getEndereco()));
        System.out.println("Digite o nÃºmero da CNH");
        aux = entrada.nextLine();
        motorista.setNumCNH(aux);
        System.out.println("Digite o tipo da CNH");
        aux = entrada.nextLine();
        motorista.setTipoCNH(aux);
        String auxDia, auxMes, auxAno;
        System.out.println("Digite o dia da data de nascimento do motorista");
        auxDia = entrada.nextLine();
        System.out.println("Digite o mÃªs da data de nascimento do motorista");
        auxMes = entrada.nextLine();
        System.out.println("Digite o ano da data de nascimento do motorista");
        auxAno = entrada.nextLine();
        aux = auxDia + "/" + auxMes + "/" + auxAno;
        motorista.setDataNascimento(aux);
        listaMotoristas.add(motorista);
    }

    private static void criarPastaMotorista() { //SE O DIRETÃ“RIO EXISTIR ELE NÃƒO FAZ NADA
        File raiz = new File("Gravuras/");
        boolean existeRaiz = raiz.exists();
        if (existeRaiz == false) {
            raiz.mkdir();
        }
        File nutela = new File("Gravuras/Motoristas");
        boolean existeNutela = nutela.exists();
        if (existeNutela == false) {
            nutela.mkdir();
        }
    }

    public static void serializadorMotorista(List<Motorista> listaMotoristas) {
        criarPastaMotorista();
        File arq = new File("Gravuras/Motoristas/motoristas.bin");
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaMotoristas);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Motorista> deserializarMotorista() {
        ArrayList<Motorista> listaMotoristas = new ArrayList<Motorista>();
        try {
            File arq = new File("Gravuras/Motoristas/motoristas.bin");
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                listaMotoristas = (ArrayList<Motorista>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (listaMotoristas);
    }
    //AQUI TERMINA O CADASTRO DE MOTORISTAS

    //AQUI COMEÃ‡A O CADASTRO DOS TODOS OS VEICULOS
    public static void cadastrarVeiculo(Veiculo veiculo, ArrayList<Veiculo> listaVeiculos) {
        int i;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o ano do veiculo");
        String aux = entrada.nextLine();
        veiculo.setAno(aux);
        System.out.println("Digite a marca do veiculo");
        aux = entrada.nextLine();
        veiculo.setMarca(aux);
        System.out.println("Digite o modelo do veiculo");
        aux = entrada.nextLine();
        veiculo.setModelo(aux);
        System.out.println("Digite a placa do veiculo");
        aux = entrada.nextLine();
        veiculo.setPlaca(aux);
        System.out.println("Digite o tipo do veiculo:"
                + "\n1 - Carreta"
                + "\n2 - CaminhÃ£o bau"
                + "\n3 - Van");
        int aux2 = entrada.nextInt();
        veiculo.setTipo(aux2);
        //ADICIONA VEICULOS DE FORMA ORDENADA POR TIPO
        if (listaVeiculos.isEmpty()) {
            listaVeiculos.add(veiculo);
        } else {
            if (veiculo.getTipo() == 1) {
                listaVeiculos.add(0, veiculo);
            }
            Veiculo auxLoiro = new Veiculo();
            if (veiculo.getTipo() == 2) {
                auxLoiro = listaVeiculos.get(listaVeiculos.size() - 1);
                i = 0;
                if (auxLoiro.getTipo() == 1) {
                    listaVeiculos.add(veiculo);
                } else {
                    for (Veiculo veic : listaVeiculos) {
                        if (veic.getTipo() == 2) {
                            listaVeiculos.add(i, veiculo);
                            break;
                        }
                        if (veic.getTipo() == 3) {
                            listaVeiculos.add(i, veiculo);
                            break;
                        }
                        i++;
                    }
                }
            }
            if (veiculo.getTipo() == 3) {
                listaVeiculos.add(veiculo);
            }
        }
    }

    private static void criarPastaVeiculo() { //SE O DIRETÃ“RIO EXISTIR ELE NÃƒO FAZ NADA
        File raiz = new File("Gravuras/");
        boolean existeRaiz = raiz.exists();
        if (existeRaiz == false) {
            raiz.mkdir();
        }
        File nutela = new File("Gravuras/Veiculos");
        boolean existeNutela = nutela.exists();
        if (existeNutela == false) {
            nutela.mkdir();
        }
    }

    public static void serializadorVeiculos(ArrayList<Veiculo> listaVeiculos) {
        criarPastaVeiculo();
        File arq = new File("Gravuras/Veiculos/veiculos.bin");
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaVeiculos);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Veiculo> deserializarVeiculos() {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        try {
            File arq = new File("Gravuras/Veiculos/veiculos.bin");
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                listaVeiculos = (ArrayList<Veiculo>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (listaVeiculos);
    }
    //AQUI TERMINA O CADASTRO DE VEICULOS

    //AQUI COMEÃ‡A A VINCULAÃ‡ÃƒO E DESVINCULAÃ‡ÃƒO DOS MOTORISTAS COM OS VEICULOS
    public static void gerenciarVinculo(ArrayList<Motorista> listaMotoristas, ArrayList<Veiculo> listaVeiculos) {
        boolean continuar = false;
        Scanner entrada = new Scanner(System.in);
        Motorista vincMoto = new Motorista();
        System.out.println("Digite o nÃºmero da CNH do motorista que deseja vincular.");
        String aux = entrada.nextLine();
        if (listaMotoristas != null) {
            for (Motorista motor : listaMotoristas) {
                if (aux.equals(motor.getNumCNH())) {
                    System.out.println("Motorista encontrado: " + motor.getNome());
                    if (motor.getVinculo() == null) {
                        vincMoto = motor;
                        System.out.println("Motorista selecionado com sucesso.");
                        continuar = true;
                    } else {
                        System.out.println("Motorista jÃ¡ estÃ¡ vinculado a um veiculo.");
                    }
                    break;
                }
            }
            if (continuar == true) {
                int auxTipo;
                System.out.println("Digite a placa do veiculo que deseja vincular ao motorista " + vincMoto.getNome());
                aux = entrada.nextLine();
                for (Veiculo veic : listaVeiculos) {
                    if (veic.getPlaca().equals(aux)) {
                        System.out.println("Veiculo encontrado.");
                        auxTipo = veic.getTipo();
                        if (auxTipo < 3 && vincMoto.getTipoCNH().equalsIgnoreCase("C")) {
                            veic.setVinculo(vincMoto);
                            vincMoto.setVinculo(veic);
                            System.out.println("Motorista registrado com sucesso.");
                            break;
                        } else {
                            if (auxTipo == 3 && (vincMoto.getTipoCNH().equalsIgnoreCase("B") || vincMoto.getTipoCNH().equalsIgnoreCase("C"))) {
                                veic.setVinculo(vincMoto);
                                vincMoto.setVinculo(veic);
                                System.out.println("Motorista registrado com sucesso.");
                                break;
                            } else {
                                System.out.println("Tipo da CNH do motorista invÃ¡lida.");
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("LISTA DE MOTORISTAS ESTÃ� VAZIA!");
        }
    }

    public void desvinculacao(ArrayList<Motorista> listaMotoristas) {
        boolean fon = false;
        if (listaMotoristas != null) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Digite o nÃºmero da CNH do motorista que deseja desvincular:");
            String aux = entrada.nextLine();
            Veiculo veiculo;
            for (Motorista motorista : listaMotoristas) {
                if (motorista.getNumCNH().equals(aux)) {
                    fon = true;
                    if (motorista.getVinculo() != null) {
                        veiculo = motorista.getVinculo();
                        veiculo.setVinculo(null);
                        motorista.setVinculo(null);
                        System.out.println("Motorista desvinculado com sucesso.");
                        break;
                    } else {
                        System.out.println("MOTORISTA NÃƒO ESTÃ� VINCULADO A NENHUM VEICULO");
                        break;
                    }
                }
            }
            if (fon == false) {
                System.out.println("NÃšMERO DE CNH INCORRETA!");
            }
        } else {
            System.out.println("LISTA DE MOTORISTAS ESTÃ� NULA!");
        }
    }
    //AQUI TERMINA A PARTE DE VINCULAÃ‡ÃƒO

    // 1 - CARRETA (10)
    // 2 - CAMINHAO BAU (3)
    // 3 - VAN (1)
    public static void gerarRoteiro(ArrayList<Roteiro> listaRoteiros, ArrayList<Objeto> listaObjetos, ArrayList<Motorista> listaMotoristas) {
        boolean fon = false;
        Scanner entrada = new Scanner(System.in);

        if (listaObjetos.isEmpty()) {
            System.out.println("NÃƒO HÃ� OBJETOS PARA ENTREGAR!");
        } else {
            ArrayList<Motorista> vinculados = new ArrayList<Motorista>();
            Veiculo veiculo = new Veiculo();
            for (Motorista vinc : listaMotoristas) {    //PEGA A FROTA DE MOTORISTAS COM VEICULOS
                if (vinc.getVinculo() != null) {
                    vinculados.add(vinc);
                }
            }
            if (vinculados.isEmpty()) {
                System.out.println("NÃƒO HÃ� NENHUM MOTORISTA VINCULADO A UM VEICULO");
                fon = true;
            } else {
                System.out.println("Digite o dia do registro do roteiro");
                String auxDia = entrada.next();
                System.out.println("Digite o mÃªs do registro do roteiro");
                String auxMes = entrada.next();
                System.out.println("Digite o ano do registro do roteiro");
                String auxAno = entrada.next();
                String data = auxDia + "/" + auxMes + "/" + auxAno;

                ArrayList<Objeto> aux2;
                Veiculo auxVeic = new Veiculo();
                for (Motorista motorista : vinculados) {

                    auxVeic = motorista.getVinculo();
                    if (auxVeic.getTipo() == 1) {
                        Roteiro roteiro = new Roteiro();
                        roteiro.setEntregas(new ArrayList<Objeto>());
                        roteiro.setMotorista(motorista);
                        for (int i = 0; i < 10; i++) {
                            if (listaObjetos.isEmpty()) {
                                System.out.println("TODOS OS OBJETOS FORAM ENVIADOS!");
                                break;
                            } else {
                                aux2 = roteiro.getEntregas();
                                aux2.add(listaObjetos.get(0));
                                roteiro.setEntregas(aux2);
                                listaObjetos.remove(0);
                                roteiro.setNomeMotorista(motorista.getNome());
                                roteiro.setData(data);
                                motorista.setRoteiro(roteiro);
                            }
                        }

                        listaRoteiros.add(roteiro);
                    }
                    if (auxVeic.getTipo() == 2) {
                        Roteiro roteiro = new Roteiro();
                        roteiro.setEntregas(new ArrayList<Objeto>());
                        roteiro.setMotorista(motorista);
                        for (int i = 0; i < 3; i++) {
                            if (listaObjetos.isEmpty()) {
                                System.out.println("TODOS OS OBJETOS FORAM ENVIADOS!");
                                break;
                            } else {
                                aux2 = roteiro.getEntregas();
                                aux2.add(listaObjetos.get(0));
                                roteiro.setEntregas(aux2);
                                listaObjetos.remove(0);
                                roteiro.setNomeMotorista(motorista.getNome());
                                roteiro.setData(data);
                                motorista.setRoteiro(roteiro);
                            }
                        }

                        listaRoteiros.add(roteiro);
                    }
                    if (auxVeic.getTipo() == 3) {
                        Roteiro roteiro = new Roteiro();
                        roteiro.setEntregas(new ArrayList<Objeto>());
                        roteiro.setMotorista(motorista);
                        if (listaObjetos.isEmpty()) {
                            System.out.println("TODOS OS OBJETOS FORAM ENVIADOS!");
                            break;
                        } else {
                            roteiro.setEntregas(new ArrayList<Objeto>());
                            aux2 = roteiro.getEntregas();
                            aux2.add(listaObjetos.get(0));
                            roteiro.setEntregas(aux2);
                            listaObjetos.remove(0);
                            roteiro.setNomeMotorista(motorista.getNome());
                            roteiro.setData(data);
                            motorista.setRoteiro(roteiro);
                            listaRoteiros.add(roteiro);
                        }
                    }
                }
            }
            exibirRoteiro(listaRoteiros, listaObjetos, fon);
        }
    }

    private static void exibirRoteiro(List<Roteiro> listaRoteiros, List<Objeto> listaObjetos, boolean fon) {
        Scanner entrada = new Scanner(System.in);
        String loiro;
        int i = 1;
        for (Roteiro roteiro : listaRoteiros) {
            System.out.println("ROTEIRO NÂº" + i + ": ");
            i++;
            System.out.println("Motorista designado para roteiro: " + roteiro.getNomeMotorista());
            ArrayList<Objeto> entregas = roteiro.getEntregas();
            for (Objeto obj : entregas) {
                System.out.println("OBJETO");
                System.out.println("CÃ³digo localizador: " + obj.getCodigoLocal());
                System.out.println("Data de entrada no sistema: " + obj.getDataDeposito());
                System.out.println("Nome do remetente: " + obj.getNomeRemetente());
                System.out.println("Nome do destinatÃ¡rio: " + obj.getNomeDestinatario());
                System.out.println("---------------------------------------");
            }
        }
        if (listaObjetos.isEmpty()) {

        } else {
            if (fon==false) {
                System.out.println("Deseja visualizar os objetos que ficaram de fora do roteiro? S/N");
                loiro = entrada.nextLine();
                if (loiro.equalsIgnoreCase("S")) {
                    for (Objeto obj : listaObjetos) {
                        System.out.println("OBJETO");
                        System.out.println("CÃ³digo localizador: " + obj.getCodigoLocal());
                        System.out.println("Data de entrada no sistema: " + obj.getDataDeposito());
                        System.out.println("Nome do remetente: " + obj.getNomeRemetente());
                        System.out.println("Nome do destinatÃ¡rio: " + obj.getNomeDestinatario());
                        System.out.println("---------------------------------------");
                    }
                }
            }

        }
    }

    private static void criarPastaRoteiro() { //SE O DIRETÃ“RIO EXISTIR ELE NÃƒO FAZ NADA
        File raiz = new File("Gravuras/");
        boolean existeRaiz = raiz.exists();
        if (existeRaiz == false) {
            raiz.mkdir();
        }
        File nutela = new File("Gravuras/Roteiros");
        boolean existeNutela = nutela.exists();
        if (existeNutela == false) {
            nutela.mkdir();
        }
    }

    public static void serializarRoteiro(List<Roteiro> listaRoteiros) {
        criarPastaRoteiro();
        File arq = new File("Gravuras/Roteiros/roteiros.bin");
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaRoteiros);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Roteiro> deserializarRoteiro() {
        ArrayList<Roteiro> listaRoteiros = new ArrayList<Roteiro>();
        try {
            File arq = new File("Gravuras/Roteiros/roteiros.bin");
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                listaRoteiros = (ArrayList<Roteiro>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (listaRoteiros);
    }

    public static void darBaixaRoteirosDoDia(List<Roteiro> listaRoteiroAtual, List<Roteiro> listaRoteiroAnterior, List<Objeto> listaObjetos) {
        if (listaRoteiroAtual.isEmpty()) {
            System.out.println("A LISTA DE ROTEIROS DE HOJE JÃ� FOI DADO BAIXA/NÃƒO FOI GERADA AINDA");
        } else {
            Scanner entrada = new Scanner(System.in);
            String loira;
            Objeto auxObj = new Objeto();
            for (Roteiro roteiro : listaRoteiroAtual) {
                ArrayList<Objeto> listaObj = new ArrayList<Objeto>();
                for (Objeto obj : listaObj) {
                    System.out.println("Objeto remetente: " + obj.getNomeRemetente());
                    System.out.println("CÃ³digo localizador: " + obj.getCodigoLocal());
                    System.out.println("Este objeto foi entregue? S/N");
                    loira = entrada.nextLine();
                    if (loira.equalsIgnoreCase("S")) {
                        obj.setEntregue("Entregue");
                    }
                    if (loira.equalsIgnoreCase("N")) {
                        obj.setEntregue("NÃ£o entregue");
                        listaObjetos.add(0, obj);
                    }
                }
                Motorista desv = roteiro.getMotorista();
                desv.setRoteiro(null);
                listaRoteiroAnterior.add(roteiro);
            }
            listaRoteiroAtual.removeAll(listaRoteiroAtual);
        }

    }

    public static void serializarRoteiroAntigo(List<Roteiro> listaRoteiros) {
        criarPastaRoteiro();
        File arq = new File("Gravuras/Roteiros/roteirosAntigos.bin");
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaRoteiros);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Roteiro> deserializarRoteiroAntigo() {
        ArrayList<Roteiro> listaRoteiros = new ArrayList<Roteiro>();
        try {
            File arq = new File("Gravuras/Roteiros/roteirosAntigos.bin");
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                listaRoteiros = (ArrayList<Roteiro>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (listaRoteiros);
    }

    public static void mostrarRoteirosAnteriores(List<Roteiro> listaRoteirosAntigos) {
        boolean achou = false;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pesquisar roteiro por:"
                + "\n1 - Motorista"
                + "\n2 - Data");
        int loira = entrada.nextInt();
        if (loira == 1) {
            System.out.println("Digite o nÃºmero da CNH do motorista");
            String CNH = entrada.next();
            for (Roteiro rote : listaRoteirosAntigos) {
                ArrayList<Objeto> listaObj = rote.getEntregas();
                Motorista auxMoto = rote.getMotorista();
                if (auxMoto.getNumCNH().equals(CNH)) {
                    achou = true;
                    System.out.println("ROTEIRO DO DIA: " + rote.getData());
                    System.out.println("----------------------------");

                    for (Objeto obj : listaObj) {
                        System.out.println("OBJETO");
                        System.out.println("CÃ³digo localizador: " + obj.getCodigoLocal());
                        System.out.println("Data de entrada no sistema: " + obj.getDataDeposito());
                        System.out.println("Nome do remetente: " + obj.getNomeRemetente());
                        System.out.println("Nome do destinatÃ¡rio: " + obj.getNomeDestinatario());
                        System.out.println("---------------------------------------");
                    }
                    break;
                }
            }
        }
        if (loira == 2) {
            String date;
            System.out.println("Digite a data que deseja buscar o roteiro no sistema");
            System.out.println("Digite o dia:");
            String auxDia, auxMes, auxAno;
            auxDia = entrada.next();
            System.out.println("Digite o mÃªs:");
            auxMes = entrada.next();
            System.out.println("Digite o ano:");
            auxAno = entrada.next();
            date = auxDia + "/" + auxMes + "/" + auxAno;
            for (Roteiro rote : listaRoteirosAntigos) {
                ArrayList<Objeto> listaObj = rote.getEntregas();
                if (rote.getData().equals(date)) {
                    achou = true;
                    System.out.println("ROTEIRO DO DIA: " + rote.getData());
                    System.out.println("----------------------------");
                    for (Objeto obj : listaObj) {
                        System.out.println("OBJETO");
                        System.out.println("CÃ³digo localizador: " + obj.getCodigoLocal());
                        System.out.println("Data de entrada no sistema: " + obj.getDataDeposito());
                        System.out.println("Nome do remetente: " + obj.getNomeRemetente());
                        System.out.println("Nome do destinatÃ¡rio: " + obj.getNomeDestinatario());
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }
        if (achou == false) {
            System.out.println("ROTEIRO NÃƒO ENCONTRADO");
        }
    }

    //AQUI ACABA (FINALMENTE) A PARTE DE GERAR ROTEIROS E ETC...
}

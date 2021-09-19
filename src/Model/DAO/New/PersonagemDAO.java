package Model.DAO.New;

import Model.ConnectPostgre;
import Model.Personagem.Personagem;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PersonagemDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

    public static ArrayList<Personagem> Listar(){
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "select * from Personagem";

        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {

                int codigoAparencia = resultado.getInt("codigoAparencia");

                String sqlAparencia = "select * from Aparencia where codigoAparencia = " + codigoAparencia;

                Statement declaracaoAparencia = con.createStatement();
                ResultSet resultadoAparencia = declaracao.executeQuery(sqlAparencia);

                String nomePersonagem = "";
                float altura = 0;
                float peso = 0;
                String corOlhos = "";
                int idade = 0;
                String corPele = "";
                String corCabelo = "";

                while(resultadoAparencia.next()){
                    nomePersonagem = resultadoAparencia.getString("nomePersonagem");
                    altura = resultadoAparencia.getFloat("altura");
                    peso = resultadoAparencia.getFloat("peso");
                    corOlhos = resultadoAparencia.getString("corOlhos");
                    idade = resultadoAparencia.getInt("idade");
                    corPele = resultadoAparencia.getString("corPele");
                    corCabelo = resultadoAparencia.getString("corCabelo");
                }

                int codigoPersonagem = resultado.getInt("codigoPersonagem");
                String nomeJogador = resultado.getString("nomeJogador");
                String nomeCampanha = resultado.getString("nomeCampanha");
                String personagemSubRaca = resultado.getString("personagemSubRaca");
                String personagemClasse = resultado.getString("personagemClasse");
                int deus = resultado.getInt("deus");
                String arquetipo = resultado.getString("arquetipo");
                String nomeAntecedente = resultado.getString("nomeAntecedente");
                String tendencia = resultado.getString("tendencia");
                int percepcaoPassiva = resultado.getInt("percepcaoPassiva");
                int numeroInspiracao = resultado.getInt("numeroInspiracao");
                int pontosVidaAtual = resultado.getInt("pontosVidaAtual");
                int pontosVidaTotal = resultado.getInt("pontosVidaTotal");
                int pontosExperiencia = resultado.getInt("pontosExperiencia");
                int capacidadeCarga = resultado.getInt("capacidadeCarga");
                int cobre = resultado.getInt("cobre");
                int prata = resultado.getInt("prata");
                int ouro = resultado.getInt("ouro");
                int platina = resultado.getInt("platina");
                int electro = resultado.getInt("electro");
                int classeArmadura = resultado.getInt("classeArmadura");
                float deslocamento = resultado.getFloat("deslocamento");
                String caracteristicaAdicional = resultado.getString("caracteristicaAdicional");
                String vinculo = resultado.getString("vinculo");
                String defeito = resultado.getString("defeito");
                String ideal = resultado.getString("ideal");
                String tracoPersonalidade = resultado.getString("tracoPersonalidade");
                int carisma = listarHabilidade(codigoPersonagem, "Carisma");
                int constituicao = listarHabilidade(codigoPersonagem, "Constituição");
                int forca = listarHabilidade(codigoPersonagem, "Força");
                int destreza = listarHabilidade(codigoPersonagem, "Destreza");
                int sabedoria = listarHabilidade(codigoPersonagem, "Sabedoria");
                int inteligencia = listarHabilidade(codigoPersonagem, "Inteligência");



                Personagem personagem = new Personagem(codigoAparencia, nomePersonagem, altura, peso, corOlhos, idade, corPele,
                        corCabelo, codigoPersonagem, nomeJogador, nomeCampanha, personagemSubRaca, personagemClasse, deus, arquetipo,
                        nomeAntecedente, tendencia, percepcaoPassiva, numeroInspiracao, pontosVidaAtual, pontosVidaTotal, pontosExperiencia,
                        capacidadeCarga, cobre, prata, ouro, platina, electro, classeArmadura, deslocamento, caracteristicaAdicional,
                        vinculo, defeito, ideal, tracoPersonalidade, carisma, constituicao, forca, destreza, sabedoria, inteligencia);
                personagens.add(personagem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return personagens;
    }

    public static void Inserir(Personagem personagem){
        String sql = "insert into Personagem (nomeJogador, nomeCampanha, personagemSubRaca, personagemClasse, codigoDeus, codigoAparencia, arquetipo, nomeAntecedente, " +
                "tendencia, percepcaoPassiva, numeroInspiracao, pontosVidaAtual, pontosVidaTotal, pontosExperiencia, capacidadeCarga, cobre, prata, ouro, platina" +
                ", electro, classeArmadura, deslocamento, caracteristicaAdicional, vinculo, defeito, ideal, tracoPersonalidade)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        InserirAparencia(personagem.getNomePersonagem(), personagem.getAltura(), personagem.getPeso(), personagem.getCorOlhos(), personagem.getIdade(), personagem.getCorPele(), personagem.getCorCabelo());

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, personagem.getNomeJogador());
            ps.setString(2, personagem.getNomeCampanha());
            ps.setString(3, personagem.getPersonagemSubRaca());
            ps.setString(4, personagem.getPersonagemClasse());
            ps.setInt(6, personagem.getDeus());
            ps.setInt(7, GetCodigoAparencia());
            ps.setString(8, personagem.getArquetipo());
            ps.setString(9, personagem.getNomeAntecedente());
            ps.setString(10, personagem.getTendencia());
            ps.setInt(11, personagem.getPercepcaoPassiva());
            ps.setInt(12, personagem.getNumeroInspiracao());
            ps.setInt(13, personagem.getPontosVidaAtual());
            ps.setInt(14, personagem.getPontosVidaTotal());
            ps.setInt(15, personagem.getPontosExperiencia());
            ps.setInt(16, personagem.getCapacidadeCarga());
            ps.setInt(17, personagem.getCobre());
            ps.setInt(18, personagem.getPrata());
            ps.setInt(19, personagem.getOuro());
            ps.setInt(20, personagem.getPlatina());
            ps.setInt(21, personagem.getElectro());
            ps.setInt(22, personagem.getClasseArmadura());
            ps.setFloat(23, personagem.getDeslocamento());
            ps.setString(24, personagem.getCaracteristicaAdicional());
            ps.setString(25, personagem.getVinculo());
            ps.setString(26, personagem.getDefeito());
            ps.setString(27, personagem.getIdeal());
            ps.setString(28, personagem.getTracoPersonalidade());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }

        inserirHabilidade(personagem, "Carisma", personagem.getCarisma());
        inserirHabilidade(personagem, "Constituição", personagem.getConstituicao());
        inserirHabilidade(personagem, "Força", personagem.getForca());
        inserirHabilidade(personagem, "Destreza", personagem.getDestreza());
        inserirHabilidade(personagem, "Sabedoria", personagem.getSabedoria());
        inserirHabilidade(personagem, "Inteligência", personagem.getInteligencia());
    }

    public static void Atualizar(Personagem personagem){
        String sql = "update personagem set nomeJogador = ?, nomeCampanha = ?, personagemSubRaca = ?, personagemClasse = ?, codigoDeus = ?, codigoAparencia = ?, arquetipo = ?, nomeAntecedente = ?, " +
                "tendencia = ?, percepcaoPassiva = ?, numeroInspiracao = ?, pontosVidaAtual = ?, pontosVidaTotal = ?, pontosExperiencia = ?, capacidadeCarga = ?, cobre = ?, prata = ?, ouro = ?, platina = ?, " +
                "electro = ?, classeArmadura = ?, deslocamento = ?, caracteristicaAdicional = ?, vinculo = ?, defeito = ?, ideal = ?, tracoPersonalidade  = ?" +
                " where codigoPersonagem = ?";

        
        AtualizarAparencia(personagem.getNomePersonagem(), personagem.getAltura(), personagem.getPeso(), personagem.getCorOlhos(), personagem.getIdade(), personagem.getCorPele(), personagem.getCorCabelo(), personagem.getCodigoAparencia());
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, personagem.getNomeJogador());
            ps.setString(2, personagem.getNomeCampanha());
            ps.setString(3, personagem.getPersonagemSubRaca());
            ps.setString(4, personagem.getPersonagemClasse());
            ps.setInt(6, personagem.getDeus());
            ps.setInt(7, GetCodigoAparencia());
            ps.setString(8, personagem.getArquetipo());
            ps.setString(9, personagem.getNomeAntecedente());
            ps.setString(10, personagem.getTendencia());
            ps.setInt(11, personagem.getPercepcaoPassiva());
            ps.setInt(12, personagem.getNumeroInspiracao());
            ps.setInt(13, personagem.getPontosVidaAtual());
            ps.setInt(14, personagem.getPontosVidaTotal());
            ps.setInt(15, personagem.getPontosExperiencia());
            ps.setInt(16, personagem.getCapacidadeCarga());
            ps.setInt(17, personagem.getCobre());
            ps.setInt(18, personagem.getPrata());
            ps.setInt(19, personagem.getOuro());
            ps.setInt(20, personagem.getPlatina());
            ps.setInt(21, personagem.getElectro());
            ps.setInt(22, personagem.getClasseArmadura());
            ps.setFloat(23, personagem.getDeslocamento());
            ps.setString(24, personagem.getCaracteristicaAdicional());
            ps.setString(25, personagem.getVinculo());
            ps.setString(26, personagem.getDefeito());
            ps.setString(27, personagem.getIdeal());
            ps.setString(28, personagem.getTracoPersonalidade());
            ps.setInt(29, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }

        AtualizarHabilidade(personagem, "Carisma", personagem.getCarisma());
        AtualizarHabilidade(personagem, "Constituição", personagem.getConstituicao());
        AtualizarHabilidade(personagem, "Força", personagem.getForca());
        AtualizarHabilidade(personagem, "Destreza", personagem.getDestreza());
        AtualizarHabilidade(personagem, "Sabedoria", personagem.getSabedoria());
        AtualizarHabilidade(personagem, "Inteligência", personagem.getInteligencia());
    }

    public static void Remover(Personagem personagem){
        String sql = "delete from personagem where codigoPersonagem = ?";
        RemoverItens(personagem);
        RemoverPericias(personagem);
        RemoverMagias(personagem);
        RemoverTalentos(personagem);
        removerHabilidade(personagem);

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }

        RemoverAparencia(personagem);
    }

    public static void InserirAparencia(String nomePersonagem, float altura, float peso, String corOlhos, int idade,
                                        String corPele, String corCabelo){
        String sql = "insert into Aparencia (nomePersonagem, altura, peso, corOlhos, idade, corPele, corCabelo)" +
                "VALUES" +
                "(?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomePersonagem);
            ps.setFloat(2, altura);
            ps.setFloat(3, peso);
            ps.setString(4, corOlhos);
            ps.setInt(5, idade);
            ps.setString(6, corPele);
            ps.setString(7, corCabelo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }

    }

    public static void AtualizarAparencia(String nomePersonagem, float altura, float peso, String corOlhos, int idade,
                                        String corPele, String corCabelo, int codigoAparencia){
        String sql = "update Aparencia set nomePersonagem = ?, altura = ?, peso = ?, corOlhos = ?, idade = ?, corPele = ?, corCabelo = ? " +
                " where codigoAparencia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomePersonagem);
            ps.setFloat(2, altura);
            ps.setFloat(3, peso);
            ps.setString(4, corOlhos);
            ps.setInt(5, idade);
            ps.setString(6, corPele);
            ps.setString(7, corCabelo);
            ps.setInt(8, codigoAparencia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }

    }

    public static void RemoverAparencia(Personagem personagem) {
        String sql = "delete from personagemAparencia where codigoAparencia = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoAparencia());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static int GetCodigoAparencia(){
        String sql = "select max(codigoAparencia) from Aparencia";
        int codigo = 0;
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while(resultado.next()){
                codigo = resultado.getInt("codigoAparencia");
            }

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }

        return codigo;
    }


    public static void InserirItem(Personagem personagem, String nomeItem, int quant, boolean equip){
        String sql = "insert into PersonagemItem (codigoPersonagem, nomeItem, quantidade, equipado)" +
                " VALUES" +
                "(?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeItem);
            ps.setInt(3, quant);
            ps.setBoolean(4, equip);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void AtualizarItem(Personagem personagem, String nomeItem, int quantidade, boolean equipado){
        String sql = "update PersonagemItem set quantidade = ?, equipado = ?" +
                " where codigoPersonagem = ? and nomeItem = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantidade);
            ps.setBoolean(2, equipado);
            ps.setInt(3, personagem.getCodigoPersonagem());
            ps.setString(4, nomeItem);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverItem(Personagem personagem, String nomeItem){
        String sql = "delete from PersonagemItem where codigoPersonagem = ? and nomeItem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeItem);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverItens(Personagem personagem){
        String sql = "delete from PersonagemItem where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void InserirPericia(Personagem personagem, String nomePericia){
        String sql = "insert into PersonagemPericia (codigoPersonagem, nomePericia)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomePericia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverPericia(Personagem personagem, String nomePericia){
        String sql = "delete from PersonagemPericia where codigoPersonagem = ? and nomePericia = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomePericia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverPericias(Personagem personagem){
        String sql = "delete from PersonagemPericia where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void InserirMagia(Personagem personagem, String nomeMagia){
        String sql = "insert into PersonagemMagia (codigoPersonagem, nomeMagia)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeMagia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverMagia(Personagem personagem, String nomeMagia){
        String sql = "delete from PersonagemMagia where codigoPersonagem = ? and nomeMagia = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeMagia);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverMagias(Personagem personagem){
        String sql = "delete from PersonagemMagia where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void InserirTalento(Personagem personagem, String nomeTalento){
        String sql = "insert into PersonagemTalento (codigoPersonagem, nomeTalento)" +
                " VALUES" +
                "(?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeTalento);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void RemoverTalento(Personagem personagem, String nomeTalento){
        String sql = "delete from PersonagemTalento where codigoPersonagem = ? and nomeTalento = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeTalento);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }

    public static void RemoverTalentos(Personagem personagem){
        String sql = "delete from PersonagemTalento where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }
    }


    public static int listarHabilidade(int personagem, String nomeHabilidade){
        String sql = "select valor from PersonagemHabilidade where codigoPersonagem = " + personagem + "and nomeHabilidade = '" + nomeHabilidade + "';";
        int habilidade = 0;
        try {
            Statement declaracao = con.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                habilidade = resultado.getInt("valor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista!");
            e.printStackTrace();
        }

        return habilidade;
    }

    public static void inserirHabilidade(Personagem personagem, String nomeHabilidade, int valor){
        String sql = "insert into PersonagemHabilidade (codigoPersonagem, nomeHabilidade, valor)" +
                " VALUES" +
                "(?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());
            ps.setString(2, nomeHabilidade);
            ps.setInt(2, valor);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
            e.printStackTrace();
        }
    }

    public static void AtualizarHabilidade(Personagem personagem, String nomeHabilidade, int valor){
        String sql = "update PersonagemHabilidade set valor = ?" +
                " where codigoPersonagem = ? and nomeHabilidade = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, personagem.getCodigoPersonagem());
            ps.setString(3, nomeHabilidade);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            e.printStackTrace();
        }
    }

    public static void removerHabilidade(Personagem personagem){
        String sql = "delete from PersonagemHabilidade where codigoPersonagem = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personagem.getCodigoPersonagem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            e.printStackTrace();
        }

    }
}

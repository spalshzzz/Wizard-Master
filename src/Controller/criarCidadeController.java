package Controller;

import Model.ConnectPostgre;
import Model.criarCidade;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.main;

import java.io.PipedOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;

public class criarCidadeController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<criarCidade> tableView;
    @FXML
    private TableView<String> tableViewLider;
    @FXML
    TableColumn<String, String> columnLider;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty> column1;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column2;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column3;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column4;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column5;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column6;
    @FXML
    TableColumn<criarCidade, SimpleStringProperty>  column7;
    @FXML
    private TextField nomeCidade;
    @FXML
    private TextField comercio;
    @FXML
    private TextField clima;
    @FXML
    private TextField vegetacao;
    @FXML
    private TextField populacao;
    @FXML
    private TextField formaGoverno;
    @FXML
    private TextField descricao;
    @FXML
    private Button adicionar;
    @FXML
    private Button remover;
    @FXML
    private Button atualizar;
    @FXML
    private Button limpar;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button adicionarLider;
    @FXML
    private Button removerLider;
    private criarCidade cidadeAtual;
    private criarCidade cidadeAntiga;
    private HashMap<Integer, criarCidade> valoresTabela;
    private ArrayList<String> arrayLideres;
    private static Connection con = ConnectPostgre.ConnectDatabase();
    int i = 0;
    String lider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valoresTabela = new HashMap<>();
        arrayLideres = new ArrayList<>();
        reloadCidade();
        initTable();
        comboBox.getItems().addAll("Lucas", "Amanda", "Igor", "Leo", "Roberta", "Mahat");

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cidadeAntiga = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    atualizar.setDisable(false);

                    nomeCidade.setText(cidadeAntiga.getNomeCidade());
                    comercio.setText(cidadeAntiga.getComercio());
                    clima.setText(cidadeAntiga.getClima());
                    vegetacao.setText(cidadeAntiga.getVegetacao());
                    populacao.setText(cidadeAntiga.getPopulacao());
                    formaGoverno.setText(cidadeAntiga.getFormaGoverno());
                    descricao.setText(cidadeAntiga.getDescricao());
                }
            }});

        tableViewLider.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lider = tableViewLider.getSelectionModel().getSelectedItem();
            }
        });
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}

    public void initTable(){

        column1.setCellValueFactory(new PropertyValueFactory<>("nomeCidade"));
        column2.setCellValueFactory(new PropertyValueFactory<>("comercio"));
        column3.setCellValueFactory(new PropertyValueFactory<>("clima"));
        column4.setCellValueFactory(new PropertyValueFactory<>("vegetacao"));
        column5.setCellValueFactory(new PropertyValueFactory<>("populacao"));
        column6.setCellValueFactory(new PropertyValueFactory<>("formaGoverno"));
        column7.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        columnLider.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));
        /*
        ObservableList<criarCidade> cidade = FXCollections.observableArrayList("FUNCAO DAO()");
        tableView.setItems(cidade);

        for(int i = 0; i < tableView.getItems().size(); ++i){
            valoresTabela.put(i, tableView.getItems().get(i));
        }

         */

    }

    private void pegarValores(){
        cidadeAtual = new criarCidade(nomeCidade.getText(), comercio.getText(), clima.getText(), vegetacao.getText(), populacao.getText(), formaGoverno.getText(), descricao.getText());
    }

    @FXML
    private void adicionar(ActionEvent event){

        pegarValores();
        //adicionar no banco de dados
        tableView.getItems().add(cidadeAtual);
        valoresTabela.put(i, cidadeAtual);
        ++i;

        for(int i = 0; i < tableViewLider.getItems().size(); ++i){
            arrayLideres.add(tableViewLider.getItems().get(i));
            System.out.println(arrayLideres.get(i));
        }
        clearLabels();

    }

    @FXML
    private void atualizar(ActionEvent event){

        pegarValores();
        //adicionar no banco de dados

        for(int j = 0; j < valoresTabela.size(); ++j){
            if(cidadeAntiga.getNomeCidade().equals(valoresTabela.get(j).getNomeCidade())){
                valoresTabela.put(j, cidadeAtual);
            }
        }
        tableView.getItems().clear();
        for(int i = 0; i < valoresTabela.size(); ++i){
            tableView.getItems().add((valoresTabela.get(i)));
        }
        reloadCidade();
        clearLabels();
    }

    @FXML
    private void remover(ActionEvent event){

        tableView.getItems().remove(cidadeAntiga);
        valoresTabela.remove(cidadeAntiga);

        reloadCidade();
        clearLabels();

    }

    void reloadCidade(){
        remover.setDisable(true);
        atualizar.setDisable(true);
        adicionar.setDisable(false);
    }

    private void clearLabels(){
        nomeCidade.clear();
        comercio.clear();
        clima.clear();
        vegetacao.clear();
        populacao.clear();
        formaGoverno.clear();
        descricao.clear();
    }
    @FXML
    private void limpar(ActionEvent event){

        clearLabels();

        reloadCidade();
    }

    @FXML
    private void adicionarLider(ActionEvent event){
        tableViewLider.getItems().add(comboBox.getValue());
    }

    @FXML
    private void removerLider(ActionEvent event){
        tableViewLider.getItems().remove(lider);
        arrayLideres.remove(lider);
    }
}

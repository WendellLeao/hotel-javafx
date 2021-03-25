package com.dell.lead;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckInHotel extends Application {
	HashMap<String, Object> mapa;
	ArrayList<Object> lista;

	TextField textFieldNome;
	TextField textFieldEndereco;
	TextField textFieldCPF;
	TextField textFieldRG;
	TextField textFieldIdade;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mapa = new HashMap<String, Object>();
		lista = new ArrayList<Object>();

		VBox layoutRaiz = new VBox(10);

		layoutRaiz.setPadding(new Insets(10, 10, 10, 10));

		// Nome
		BorderPane layoutNome = new BorderPane();

		textFieldNome = new TextField();
		Label labelNome = new Label("Nome:");

		layoutNome.setTop(labelNome);
		layoutNome.setBottom(textFieldNome);

		// Endereço
		BorderPane layoutEndereco = new BorderPane();

		textFieldEndereco = new TextField();
		Label labelEndereco = new Label("Endereço:");

		layoutEndereco.setTop(labelEndereco);
		layoutEndereco.setBottom(textFieldEndereco);

		// CPF
		BorderPane layoutCPF = new BorderPane();

		textFieldCPF = new TextField();
		Label labelCPF = new Label("CPF:");

		layoutCPF.setTop(labelCPF);
		layoutCPF.setBottom(textFieldCPF);

		// RG
		BorderPane layoutRG = new BorderPane();

		textFieldRG = new TextField();
		Label labelRG = new Label("RG:");

		layoutRG.setTop(labelRG);
		layoutRG.setBottom(textFieldRG);

		// Idade
		BorderPane layoutIdade = new BorderPane();

		textFieldIdade = new TextField();
		Label labelIdade = new Label("Idade:");

		layoutIdade.setTop(labelIdade);
		layoutIdade.setBottom(textFieldIdade);

		// Sexo
		BorderPane borderPaneSexo = new BorderPane();
		Label labelSexo = new Label("Sexo:");

		HBox layoutSexo = new HBox(20);
		ToggleGroup toggleGroupSexo = new ToggleGroup();

		RadioButton radioButtonMasculino = new RadioButton("M");
		RadioButton radioButtonFeminino = new RadioButton("F");

		borderPaneSexo.setTop(labelSexo);

		// Quartos
		BorderPane layoutQuartos = new BorderPane();
		ComboBox<Integer> comboBoxQuartos = new ComboBox<Integer>();
		comboBoxQuartos.getItems().addAll(124, 186, 137, 102, 136, 115, 148);

		layoutQuartos.setLeft(comboBoxQuartos);

		layoutQuartos.setPadding(new Insets(10, 0, 0, 0));

		// Check In e Check Out
		HBox layoutCheckInCheckOut = new HBox(20);
		BorderPane borderPaneCheckInCheckOut = new BorderPane();

		CheckBox checkIn = new CheckBox("Check In");
		CheckBox checkOut = new CheckBox("Check Out");

		borderPaneCheckInCheckOut.setLeft(checkIn);
		borderPaneCheckInCheckOut.setRight(checkOut);

		layoutCheckInCheckOut.setPadding(new Insets(10, 0, 0, 0));

		// Botões
		HBox layoutBotoes = new HBox(10);

		Button buttonSalvar = new Button("Salvar");
		Button buttonBuscar = new Button("Buscar");
		Button buttonRemover = new Button("Remover");
		Button buttonImprimir = new Button("Imprimir");

		layoutBotoes.setPadding(new Insets(10, 0, 0, 0));

		// Adding
		layoutRaiz.getChildren().addAll(layoutNome, layoutEndereco, layoutCPF, layoutRG, layoutIdade, borderPaneSexo,
				layoutSexo, layoutQuartos, layoutCheckInCheckOut, layoutBotoes);

		layoutBotoes.getChildren().addAll(buttonSalvar, buttonBuscar, buttonRemover, buttonImprimir);

		layoutCheckInCheckOut.getChildren().addAll(checkIn, checkOut);

		layoutSexo.getChildren().addAll(radioButtonMasculino, radioButtonFeminino);
		toggleGroupSexo.getToggles().addAll(radioButtonMasculino, radioButtonFeminino);

		EventHandler<ActionEvent> actionSalvar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				salvarInformacoes();
			}
		};

		EventHandler<ActionEvent> actionImprimir = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				imprimirDados();
			}
		};

		EventHandler<ActionEvent> actionBuscar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buscarDados();
			}
		};
		
		EventHandler<ActionEvent> actionRemover = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				removerDados();
			}
		};

		buttonSalvar.setOnAction(actionSalvar);
		buttonBuscar.setOnAction(actionBuscar);
		buttonRemover.setOnAction(actionRemover);
		buttonImprimir.setOnAction(actionImprimir);

		// Cena
		Scene scene = new Scene(layoutRaiz, 350, 460);
		primaryStage.setTitle("Cadastro de Hotel");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	public void salvarInformacoes() {
		lista.add(0, textFieldNome.getText());
		lista.add(1, textFieldEndereco.getText());
		lista.add(2, textFieldCPF.getText());
		lista.add(3, textFieldRG.getText());
		lista.add(4, textFieldIdade.getText());
	}

	public void buscarDados() {
		textFieldNome.setText(lista.get(0).toString());
		textFieldEndereco.setText(lista.get(1).toString());
		textFieldCPF.setText(lista.get(2).toString());
		textFieldRG.setText(lista.get(3).toString());
		textFieldIdade.setText(lista.get(4).toString());
	}
	
	public void imprimirDados() {
		JOptionPane.showMessageDialog(null, lista);
	}
	
	public void removerDados() {
		lista.removeAll(lista);
		textFieldNome.clear();
		textFieldEndereco.clear();
		textFieldCPF.clear();
		textFieldRG.clear();
		textFieldIdade.clear();
	}
}

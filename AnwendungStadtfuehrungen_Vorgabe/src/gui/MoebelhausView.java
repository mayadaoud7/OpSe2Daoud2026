package gui;

import business.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class MoebelhausView {

	private MoebelhausControl control;
	private MoebelstueckModel model;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblName = new Label("Name:");
	private Label lblWohnraum = new Label("Wohnraum:");
	private Label lblStil = new Label("Stil:");
	private Label lblPreis = new Label("Preis:");
	private Label lblMaterialien = new Label("Materialien:");
	private TextField txtName = new TextField();
	private TextField txtWohnraum = new TextField();
	private TextField txtStil = new TextField();
	private TextField txtPreis = new TextField();
	private TextField txtMaterialien = new TextField();
	private TextArea txtAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public MoebelhausView(MoebelhausControl control, Stage primaryStage, MoebelstueckModel model) {
		this.control = control;
		this.model = model;

		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Möbeln");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblName.setLayoutX(20);
		lblName.setLayoutY(90);
		lblWohnraum.setLayoutX(20);
		lblWohnraum.setLayoutY(130);
		lblStil.setLayoutX(20);
		lblStil.setLayoutY(170);
		lblPreis.setLayoutX(20);
		lblPreis.setLayoutY(210);
		lblMaterialien.setLayoutX(20);
		lblMaterialien.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblWohnraum, lblStil, lblPreis, lblMaterialien);

		// Textfelder
		txtName.setLayoutX(170);
		txtName.setLayoutY(90);
		txtName.setPrefWidth(200);
		txtWohnraum.setLayoutX(170);
		txtWohnraum.setLayoutY(130);
		txtWohnraum.setPrefWidth(200);
		txtStil.setLayoutX(170);
		txtStil.setLayoutY(170);
		txtStil.setPrefWidth(200);
		txtPreis.setLayoutX(170);
		txtPreis.setLayoutY(210);
		txtPreis.setPrefWidth(200);
		txtMaterialien.setLayoutX(170);
		txtMaterialien.setLayoutY(250);
		txtMaterialien.setPrefWidth(200);
		pane.getChildren().addAll(txtName, txtWohnraum, txtStil, txtPreis, txtMaterialien);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		this.mnDatei.getItems().add(mnItmTxtImport);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				control.nehmeMoebelstueckAuf(txtName.getText(), txtWohnraum.getText(), txtStil.getText(),
						txtPreis.getText(), txtMaterialien.getText());
			}
		});

		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeMoebelstueckeAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				control.leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				control.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				control.schreibeMoebelstueckeInCsvDatei();
			}
		});
	}

	public void zeigeMoebelstueckeAn() {
		if (this.model.getMoebelstueck() != null) {
			txtAnzeige.setText(this.model.getMoebelstueck().gibMoebelstueckZurueck(' '));
		} else {
			this.zeigeInformationsfensterAn("Bisher wurde kein Möbelstück aufgenommen!");
		}
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

}

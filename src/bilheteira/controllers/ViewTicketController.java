package bilheteira.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import application.Main;
import bilheteira.models.DAO.EventListDAO;
import bilheteira.models.DAO.RefundTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * Classe que controla a funcao de mostrar o bilhete; Contem uma ObservableList
 * com IDs de bilhetes, data, eventoNome, eventoID, precoTotalBilhete,
 * precoBilhete e zonaID
 * 
 * @author Ricardo Cruz
 *
 */

public class ViewTicketController {

	ObservableList<Integer> codigosBilhetes = FXCollections.observableArrayList();
	String data;
	String eventoNome;
	private int eventoID;
	private double precoTotalBilhete = 0;
	private double precoBilhete = 0;
	private int zonaID;

	@FXML
	private Text nomeEvento;

	@FXML
	private Text dataHora;

	@FXML
	private Text precoFinal;

	@FXML
	private Text zona;

	@FXML
	private Text portao;

	@FXML
	private ComboBox<Integer> codigoBilhete;

	public ViewTicketController(ObservableList<Integer> codigosBilhetes, String eventoNome, Integer eventoID,
			Integer zonaID, String data) {

		precoBilhete = RefundTicketDAO.getPreco(codigosBilhetes.get(0));
		BigDecimal bd = new BigDecimal(precoBilhete).setScale(2, RoundingMode.HALF_UP);
		precoBilhete = bd.doubleValue();
		this.eventoID = eventoID;
		this.zonaID = zonaID;
		this.eventoNome = eventoNome;
		this.data = data;
		this.codigosBilhetes = codigosBilhetes;
	}

	/**
	 * Metodo initialize da classe ViewTicketController Ao inicializar, este metodo
	 * popula as caixas de texto presentes no bilhete Abre também uma janela onde é
	 * mostrado o preço final dos bilhetes comprados ( soma do preço dos bilhetes )
	 */

	@FXML
	public void initialize() {
		nomeEvento.setText(eventoNome);
		dataHora.setText(data);
		precoFinal.setText(String.valueOf(precoBilhete));
		zona.setText(String.valueOf(zonaID));
		portao.setText(String.valueOf(EventListDAO.getPortaoID(zonaID)));
		codigoBilhete.setItems(codigosBilhetes);
		try {
			Main.createNewWindow("view/PreçoTotal.fxml", new PrecoFinalController(codigosBilhetes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

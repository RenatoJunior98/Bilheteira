package bilheteira.controllers;

import bilheteira.models.DAO.RefundTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Classe controller da visualização do preço final da compra dos bilhetes.
 * 
 * @author Ricardo Cruz
 *
 */

public class PrecoFinalController {

	@FXML
	private Text precoTotalText;

	private ObservableList<Integer> codigosBilhetes = FXCollections.observableArrayList();
	private int precoTotalBilhete = 0;

	public PrecoFinalController(ObservableList<Integer> codigosBilhetes) {
		this.codigosBilhetes = codigosBilhetes;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método initialize da classe. Chama o método da classe DAO para fazer a conta
	 * do preço final. Preenche a caixa de texto com o preço total dos bilhetes
	 */

	@FXML
	public void initialize() {
		precoTotalBilhete += RefundTicketDAO.getPreco(codigosBilhetes.get(0)) * codigosBilhetes.size();
		precoTotalText.setText(String.valueOf(precoTotalBilhete));

	}

}

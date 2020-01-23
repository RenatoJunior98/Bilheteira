package bilheteira.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bilheteira.models.DAO.RefundTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Classe controller da visualiza��o do pre�o final da compra dos bilhetes.
 * 
 * @author Ricardo Cruz
 *
 */

public class PrecoFinalController {

	@FXML
	private Text precoTotalText;

	private ObservableList<Integer> codigosBilhetes = FXCollections.observableArrayList();
	private double precoTotalBilhete = 0;
	

	public PrecoFinalController(ObservableList<Integer> codigosBilhetes) {
		this.codigosBilhetes = codigosBilhetes;
	}

	/**
	 * M�todo initialize da classe. Chama o m�todo da classe DAO para fazer a conta
	 * do pre�o final. Preenche a caixa de texto com o pre�o total dos bilhetes
	 */

	@FXML
	public void initialize() {
		precoTotalBilhete += RefundTicketDAO.getPreco(codigosBilhetes.get(0)) * codigosBilhetes.size();
		BigDecimal bd = new BigDecimal(precoTotalBilhete).setScale(2, RoundingMode.HALF_UP);
		precoTotalBilhete = bd.doubleValue();
		precoTotalText.setText(String.valueOf(precoTotalBilhete));

	}

}

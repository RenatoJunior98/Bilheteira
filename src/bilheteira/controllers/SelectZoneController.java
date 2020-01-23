package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.EventListDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 * Classe controller da janela de escolha de zonas bloqueadas
 * (CreateEventoZonas) É possível escolher zonas para bloquear no recém-criado
 * evento ( não sendo obrigatório ).
 * 
 * @author Ricardo Cruz
 *
 */

public class SelectZoneController {

	@FXML
	private CheckBox z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20, z21,
			z22, z23, z24;

	ObservableList<CheckBox> checkBoxes = FXCollections.observableArrayList();

	/**
	 * Método initialize da classe. Apresenta as checkBoxes que representam as
	 * zonas.
	 */

	@FXML
	public void initialize() {
		checkBoxes.addAll(z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20,
				z21, z22, z23, z24);

	}

	/**
	 * Este método é chamado ao clicar no botão "submit". É feita uma mudança na
	 * base de dados : o valor de isIndisponivel é mudado para 1 (aos que foram
	 * selecionados na checkBox). É aberta uma janela a dizer que o evento foi
	 * concluido (Confirmacao) (nao é interativa, apenas informativa)
	 */

	@FXML
	private void submit() {
		ObservableList<Integer> zonasIndisponiveis = FXCollections.observableArrayList();
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (!checkBoxes.get(i).isSelected())
				continue;
			zonasIndisponiveis.add(i + 1);
			System.out.println(i + 1);
		}
		EventListDAO.zonaIndisponivel(zonasIndisponiveis);

		try {
			Main.getCurrentStage().close();
			Main.createNewWindow("view/Confirmacao.fxml", new SelectZoneController());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

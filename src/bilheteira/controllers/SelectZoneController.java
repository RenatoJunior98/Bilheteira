package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.EventListDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

public class SelectZoneController {
	
	@FXML
    private CheckBox z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24;
	
	
	ObservableList<CheckBox> checkBoxes = FXCollections.observableArrayList();
	
	@FXML
	public void initialize () {
		checkBoxes.addAll(z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24);
		
	}
	@FXML
	private void submit () {
		ObservableList <Integer> zonasIndisponiveis = FXCollections.observableArrayList();
		for (int i=0;i<checkBoxes.size();i++) {
			if(!checkBoxes.get(i).isSelected()) continue;
			zonasIndisponiveis.add(i+1);
		System.out.println(i+1);
		}	
		EventListDAO.zonaIndisponivel(zonasIndisponiveis);
	
		try {
			Main.getCurrentStage().close();
			Main.createNewWindow("view/Confirmacao.fxml", new SelectZoneController ());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
	


package br.com.gourmet.game.core;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.gourmet.game.constants.GourmetGameConstants;
import br.com.gourmet.game.model.Plate;
import br.com.gourmet.game.service.MessageService;

public class Game extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private ArrayList<Plate> pastaDishes;
	private ArrayList<Plate> cakeDishes;
	private int resultConfirm;

	private transient MessageService mensagemService;
	
	public void startGame() {
		loadInitialsDishes();
		mensagemService = new MessageService();
		showInitialScreen();
	}

	private void loadInitialsDishes() {
		pastaDishes = new ArrayList<>();
		cakeDishes = new ArrayList<>();
		pastaDishes.add(new Plate("Lasanha", ""));
		cakeDishes.add(new Plate("Bolo de Chocolate", ""));
	}

	private void executeLogicGame() {
		ArrayList<Plate> newPlates;
		resultConfirm = mensagemService.openConfirmForm(GourmetGameConstants.PASTA);
		if (resultConfirm == JOptionPane.YES_OPTION) {
			newPlates = executaLogicaDosPratos(this.pastaDishes);
			this.pastaDishes = newPlates;
		} else {
			newPlates = executaLogicaDosPratos(this.cakeDishes);
			this.cakeDishes = newPlates;
		}
		showInitialScreen();
	}

	private ArrayList<Plate> executaLogicaDosPratos(ArrayList<Plate> plates) {
		@SuppressWarnings("unchecked")
		ArrayList<Plate> clone = (ArrayList<Plate>) plates.clone();

		for (int count = 0; count < plates.size(); count++) {
			Plate plate = plates.get(count);

			resultConfirm = mensagemService.openConfirmForm(plate.getName());
			if (resultConfirm == JOptionPane.YES_OPTION) {
				mensagemService.showSuccessMessage();
				showInitialScreen();
				break;
			}

			if (count == plates.size() -1 && resultConfirm == JOptionPane.NO_OPTION) {
				String dishName = mensagemService.showInputDialog(GourmetGameConstants.INTENDED_PLATE_QUESTION_2, GourmetGameConstants.GIVE_UP);
				String message = String.format(GourmetGameConstants.CHARACTERISTICS_OF_THE_DISH, dishName,
						plate.getName());
				String attribute = mensagemService.showInputDialog(message, GourmetGameConstants.COMPLETE);
				Plate newPlate = new Plate(dishName, attribute);
				clone.add(newPlate);
			}
		}

		plates = clone;
		return plates;
	}

	private void showInitialScreen() {
		int shouldStartGame = mensagemService.showInitialScreen();

		if (shouldStartGame == JOptionPane.OK_OPTION) {
			executeLogicGame();
		}
	}

}

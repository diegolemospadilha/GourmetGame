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
		jogoInicial();
	}

	private void loadInitialsDishes() {
		pastaDishes = new ArrayList<>();
		cakeDishes = new ArrayList<>();
		pastaDishes.add(new Plate("Lasanha", ""));
		cakeDishes.add(new Plate("Bolo de Chocolate", ""));
	}

	private void executeLogicGame() {
		ArrayList<Plate> newPlates;
		resultConfirm = mensagemService.openConfirmForm("massa");
		if (resultConfirm == JOptionPane.YES_OPTION) {
			newPlates = executaLogicaDosPratos(this.pastaDishes);
			this.pastaDishes = newPlates;
		} else {
			newPlates = executaLogicaDosPratos(this.cakeDishes);
			this.cakeDishes = newPlates;
		}
	}

	private ArrayList<Plate> executaLogicaDosPratos(ArrayList<Plate> pratos) {
		@SuppressWarnings("unchecked")
		ArrayList<Plate> clone = (ArrayList<Plate>) pratos.clone();

		for (int count = 0; count < pratos.size(); count++) {
			Plate plate = pratos.get(count);

			resultConfirm = mensagemService.openConfirmForm(plate.getName());
			if (resultConfirm == JOptionPane.YES_OPTION) {
				mensagemService.mostraModalDeAcerto();
				break;
			}

			if (count == pratos.size() - 1 && resultConfirm == JOptionPane.NO_OPTION) {
				String dishName = mensagemService.mostraInputDialog(GourmetGameConstants.INTENDED_PLATE_QUESTION_2, GourmetGameConstants.GIVE_UP);
				String message = String.format(GourmetGameConstants.CHARACTERISTICS_OF_THE_DISH, dishName,
						plate.getName());
				String attribute = mensagemService.mostraInputDialog(message, GourmetGameConstants.COMPLETE);
				Plate newPlate = new Plate(dishName, attribute);
				clone.add(newPlate);
				jogoInicial();
			}
		}

		pratos = clone;
		return pratos;
	}

	private void jogoInicial() {
		int deveIniciarJogo = mensagemService.mostraTelaInicial();

		if (deveIniciarJogo == JOptionPane.OK_OPTION) {
			executeLogicGame();
		}
	}

}

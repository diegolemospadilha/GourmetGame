package br.com.gourmet.game.service;

import javax.swing.JOptionPane;

import br.com.gourmet.game.constants.GourmetGameConstants;

public class MessageService {

	public int showInitialScreen() {
		return JOptionPane.showConfirmDialog(null, GourmetGameConstants.THINK_OF_PLATE, GourmetGameConstants.GAME_TITLE,
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

	}

	public int openConfirmForm(String nomePrato) {
		String message = String.format(GourmetGameConstants.INTENDED_PLATE_QUESTION_1, nomePrato);
		return JOptionPane.showConfirmDialog(null, message, GourmetGameConstants.CONFIRM, JOptionPane.YES_NO_OPTION);
	}

	public void showSuccessMessage() {
		JOptionPane.showMessageDialog(null, GourmetGameConstants.HIT_AGAIN);
	}

	public String showInputDialog(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}

}

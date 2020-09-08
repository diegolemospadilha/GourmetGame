package br.com.gourmet.game.service;

import javax.swing.JOptionPane;

import br.com.gourmet.game.constants.GourmetGameConstants;

public class MessageService {
	
	/**
	 * Method that show initial screen to player
	 * @return value of click button by the player
	 */
	public int showInitialScreen() {
		return JOptionPane.showConfirmDialog(null, GourmetGameConstants.THINK_OF_PLATE, GourmetGameConstants.GAME_TITLE,
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

	}
	
	/**
	 * Method that show question about intended dish by the player
	 * @param dishName
	 * @return answer value of the question answered by the player
	 */
	public int openConfirmForm(String dishName) {
		String message = String.format(GourmetGameConstants.INTENDED_PLATE_QUESTION_1, dishName);
		return JOptionPane.showConfirmDialog(null, message, GourmetGameConstants.CONFIRM, JOptionPane.YES_NO_OPTION);
	}
	
	/**
	 * Method that show success dialog to player
	 */
	public void showSuccessMessage() {
		JOptionPane.showMessageDialog(null, GourmetGameConstants.HIT_AGAIN);
	}
	
	/**
	 * Method that shows a input dialog to the player
	 * @param message : Message of dialog
	 * @param title : Title of dialog
	 * @return aswer value of the question answered by the player 
	 */
	public String showInputDialog(String message, String title) {
		return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
	}

}

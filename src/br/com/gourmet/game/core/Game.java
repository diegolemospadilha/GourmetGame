package br.com.gourmet.game.core;

import javax.swing.JOptionPane;

import br.com.gourmet.game.constants.GourmetGameConstants;
import br.com.gourmet.game.model.Node;
import br.com.gourmet.game.service.MessageService;

public class Game extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private int resultConfirm;
	private Node nodeRoot;
	private transient MessageService mensagemService;
	
	/**
	 * Method that start the game
	 */
	public void startGame() {
		loadInitialsDishes();
		mensagemService = new MessageService();
		showInitialScreen();
	}
	
	/**
	 * Method that load initials dishes
	 */
	private void loadInitialsDishes() {
		nodeRoot = new Node(GourmetGameConstants.PASTA);
		nodeRoot.setLeft(new Node(GourmetGameConstants.LASAGNA));
		nodeRoot.setRight(new Node("Bolo de chocolate"));
		nodeRoot.print(nodeRoot);
	}
	
	/**
	 * Method that show the initial screen
	 */
	private void showInitialScreen() {
		int shouldStartGame = mensagemService.showInitialScreen();
		if (shouldStartGame == JOptionPane.OK_OPTION) {
			executeLogicGame();
		}
	}
	
	/**
	 * Method that executes the logic of the game according to the player's choice
	 */
	private void executeLogicGame() {

		resultConfirm = mensagemService.openConfirmForm(nodeRoot.getValue());
		if (resultConfirm == JOptionPane.YES_OPTION) {
			executeLogicOfDishes(nodeRoot.getLeft());
		} else {
			executeLogicOfDishes(nodeRoot.getRight());
		}
		showInitialScreen();
	}
	
	/**
	 * Method that control logic about dishes tree
	 * @param node = node selected by player
	 */
	private void executeLogicOfDishes(Node node) {

		resultConfirm = mensagemService.openConfirmForm(node.getValue());
		if (resultConfirm == JOptionPane.YES_OPTION && !node.hasLeft() && !node.hasRight()) {
			mensagemService.showSuccessMessage();
			showInitialScreen();
		} else {
			if (resultConfirm == JOptionPane.YES_OPTION && node.hasRight()) {
				executeLogicOfDishes(node.getRight());
			} else if (resultConfirm == JOptionPane.NO_OPTION && node.hasLeft()) {
				executeLogicOfDishes(node.getLeft());
			} else {
				String dishName = mensagemService.showInputDialog(GourmetGameConstants.INTENDED_PLATE_QUESTION_2,
						GourmetGameConstants.GIVE_UP);
				String message = String.format(GourmetGameConstants.CHARACTERISTICS_OF_THE_DISH, dishName,
						node.getValue());
				String attribute = mensagemService.showInputDialog(message, GourmetGameConstants.COMPLETE);
				addNode(node, attribute, dishName);
			}
		}

	}

	/**
	 * Method that adds the new dish in the dishes tree
	 * @param node : currently node
	 * @param attribute : attribute of new dish
	 * @param dishName ; name of new dish
	 */
	private void addNode(Node node, String attribute, String dishName) {
		String oldValue = node.getValue();
		node.setLeft(new Node(oldValue));
		node.setRight(new Node(dishName));
		node.setValue(attribute);
	}

}

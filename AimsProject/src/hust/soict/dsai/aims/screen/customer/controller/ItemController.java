package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
	
	private Media media;
	private Cart cart;
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;


    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	try {
			this.cart.addMedia(this.media);
			JOptionPane.showMessageDialog(null, "The media has been added to the cart");

		} catch (LimitExceededException e) {
			JOptionPane.showMessageDialog(null, "The cart is full");
			e.printStackTrace();
		}
    }
    
    public ItemController(Media media, Cart cart) {
    	this.media = media;
    	this.cart = cart;
    }
    
    @FXML
    void btnPlayClicked(ActionEvent event) {
		try {
			if(media instanceof DigitalVideoDisc) {
				DigitalVideoDisc d = (DigitalVideoDisc) media;
				JOptionPane.showMessageDialog(null, d.play());
			}
			else if(media instanceof CompactDisc) {
				CompactDisc c = (CompactDisc) media;
				JOptionPane.showMessageDialog(null, c.play());
			}

		} catch (PlayerException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
   
    }
    
    public void setData() {
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + "$");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
}

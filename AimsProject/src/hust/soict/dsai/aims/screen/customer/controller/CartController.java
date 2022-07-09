package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	
	private Cart cart;
	
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private TableView<Media> tblMedia;

	private Store store;
    
    public CartController(Store store, Cart cart) {
    	this.cart = cart;
    	this.store = store;
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	this.cart.placeOrder();
    	costLabel.setText(Float.toString(cart.totalCost()));
		JOptionPane.showMessageDialog(null, "An order has been placed");
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalPrice();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("Id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	updateTotalPrice();
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
				
			}
    	
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
				
			}
    		
    	});
    }
    
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    
    void updateTotalPrice() {
    	costLabel.setText(String.format("%.2f", cart.totalCost()));
    }
    
    void showFilteredMedia(String newValue) {
    	
		FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered(), t->true);
    	filteredData.setPredicate(media -> {
    		if (newValue == null || newValue.isEmpty()) {
        		return true;
        	}
    		String lowerCaseFilter = newValue.toLowerCase();
    		if (radioBtnFilterId.isSelected()) {
    			if (media.getId() == Integer.parseInt(lowerCaseFilter)) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    		if (radioBtnFilterTitle.isSelected()) {
    			if (media.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
			return false;
    	});
    	
    	tblMedia.setItems(filteredData);

    }
}

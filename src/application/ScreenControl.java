package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ScreenControl implements Initializable {

	final private ObservableList<String> listaOp = FXCollections.observableArrayList("", "Op1", "Op2");
	
	@FXML private TextField textField;
    @FXML private ComboBox<String> comboBox;
    @FXML private CheckBox check;
    @FXML private DatePicker data;

    @FXML private Text txtError;
    @FXML private Button btt;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(listaOp);
		
		btt.setOnMouseClicked((MouseEvent mouse) -> {
			if(mouse.getClickCount() == 1) {
				validationControls();
			}
		});
	}
	
	private boolean validationControls() {
		if(!validationTextField())
			return false;
		else if(!validationComboBox())
			return false;
		else if(!validationCheckBox())
			return false;
		else if(!validationDatePicker())
			return false;
		else 
			return true;
	}
	
	private boolean validationTextField() {
		ValidationControlFX valid = new ValidationControlFX();
		valid.setControl(textField);
		
		valid.validateControl();
		
		if(valid.getError()) {
			txtError.setVisible(true);
			txtError.setText("Error TextField!");
			return false;
		} else {
			txtError.setVisible(false);
			txtError.setText("");
			return true;
		}
	}
	
	private boolean validationComboBox() {
		ValidationControlFX valid = new ValidationControlFX();
		valid.setControl(comboBox);
		
		valid.validateControl();
		
		if(valid.getError()) {
			txtError.setVisible(true);
			txtError.setText("Error ComboBox!");
			return false;
		} else {
			txtError.setVisible(false);
			txtError.setText("");
			return true;
		}
	}
	
	private boolean validationCheckBox() {
		ValidationControlFX valid = new ValidationControlFX();
		valid.setControl(check);
		
		valid.validateControl();
		
		if(valid.getError()) {
			txtError.setVisible(true);
			txtError.setText("Error CheckBox!");
			return false;
		} else {
			txtError.setVisible(false);
			txtError.setText("");
			return true;
		}
	}
	
	private boolean validationDatePicker() {
		ValidationControlFX valid = new ValidationControlFX();
		valid.setControl(data);
		
		valid.validateControl();
		
		if(valid.getError()) {
			txtError.setVisible(true);
			txtError.setText("Error DatePicker!");
			return false;
		} else {
			txtError.setVisible(false);
			txtError.setText("");
			return true;
		}
	}
}
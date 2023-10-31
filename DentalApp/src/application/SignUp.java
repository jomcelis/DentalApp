package application;

import java.awt.Button;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import java.io.BufferedWriter;

public class SignUp {
	public SignUp(){
		
	}
	@FXML
	private Button signUp_btn;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField contactNumber;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	private int Id =1;
	
    File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\CP2\\DentalApp\\src\\database");
    // initilize object file
    int ln;
	
	public void signUpBtn_Click(ActionEvent event) throws IOException{
		addData(username.getText(),password.getText(), firstName.getText(), lastName.getText(), age.getText(),contactNumber.getText());
	}

	void addData(String usr, String pswrd, String name, String lastName, String Age, String contactNumber) {

	    try {
	        BufferedWriter raf = new BufferedWriter(new FileWriter("C:\\Users\\Lenovo\\eclipse-workspace\\CP2\\DentalApp\\src\\database\\Customers.txt", true));
	        raf.write(Id + ",");
	        raf.write(usr + ",");
	        raf.write(pswrd + ",");
	        raf.write(name + ",");
	        raf.write(lastName + ",");
	        raf.write(Age + ",");
	        raf.write(contactNumber + "\r\n");
	        raf.close();
	        Id++;	
	    } catch (IOException ex) {
	        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}


}



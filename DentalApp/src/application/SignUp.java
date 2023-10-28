package application;

import java.awt.Button;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

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
	
    File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\CP2\\DentalApp\\src\\database");
    // initilize object file
    int ln;
	
	public void signUpBtn_Click(ActionEvent event) throws IOException{
		addData(username.getText(),password.getText(), firstName.getText(), lastName.getText(), age.getText(),contactNumber.getText());
	}

	void addData(String usr, String pswrd, String name, String lastName, String Age, String contactNumber) {
	    try {
	        RandomAccessFile raf = new RandomAccessFile(file + "\\logins.txt", "rw");
	        raf.seek(raf.length()); 
	        raf.writeBytes("\r\n");
	        raf.writeBytes("Username: " + usr + "\r\n");
	        raf.writeBytes("Password: " + pswrd + "\r\n");
	        raf.writeBytes("FirstName: " + name + "\r\n");
	        raf.writeBytes("LastName: " + lastName + "\r\n");
	        raf.writeBytes("Age: " + Age + "\r\n");
	        raf.writeBytes("ContactNumber: " + contactNumber + "\r\n");

	    } catch (FileNotFoundException ex) {
	        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}


}



package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LogIn {
    public LogIn() {
    }

    @FXML
    private Button signIn_btn;
    @FXML
    private Button signUp_btn;

    @FXML
    private TextField login_username;

    @FXML
    private TextField login_password;
    
    int ln;
    public String username = null;
    public String password = null;
    public int count;
    //Action Buttons

    public void userSignInBtn(ActionEvent event) throws IOException {
        checkLogin();
    }
    public void userSignUpBtn(ActionEvent event) throws IOException{
    	Main m = new Main();
        createFolder();
        addData(randomString,randomString,"null","null","null","null");
        readFile();    	m.changeScene("SignUp.fxml"); 	
    }

    int length = 10; 
    String randomString = generateRandomString(length);
    
    //Checks login
    
    private void checkLogin() throws IOException {
        Main m = new Main();
        createFolder();
        addData(randomString,randomString,"null","null","null","null");
        readFile();
        CheckData(login_username.getText(), login_password.getText());
    }
    
    File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\CP2\\DentalApp\\src\\database");
    
    //Create Folder
    void createFolder(){
        if(!file.exists()){
            file.mkdirs();
        }
    }
    
    //Read File
    void readFile(){
        try {
            FileReader fileReader = new FileReader(file+"\\Customers.txt");
            System.err.println("file exits!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fileWriter = new FileWriter(file+"\\Customers.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    //Adds preliminary data in txt file
	void addData(String usr, String pswrd, String name, String lastName, String Age, String contactNumber) {
	    try {
	        RandomAccessFile raf = new RandomAccessFile(file + "\\Customers.txt", "rw");
	        count = 0;
	        raf.writeBytes(count + ",");
	        raf.writeBytes(usr + ",");
	        raf.writeBytes(pswrd + ",");
	        raf.writeBytes(name + ",");
	        raf.writeBytes(lastName + ",");
	        raf.writeBytes(Age + ",");
	        raf.writeBytes(contactNumber + "\r\n");

	    } catch (FileNotFoundException ex) {
	        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	//Check Data
	void CheckData(String usr, String pswrd) {
	    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\CP2\\DentalApp\\src\\database\\Customers.txt"))) {
	        String line;
	        boolean match = false;
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length == 7 && parts[1].equals(usr) && parts[2].equals(pswrd)) {
	                match = true;
	                break;
	            }
	        }
	        if (match) {
	            Main m = new Main();
	            JOptionPane.showMessageDialog(null, "Success");
	            try {
	                // Call the changeScene method from the Main class
	                m.changeScene("Homepage.fxml");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Username or Password is incorrect!");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
 
    

        // Method to generate a random string of a specified length
     public static String generateRandomString(int length) {
         String uuid = UUID.randomUUID().toString().replace("-", "");
         return uuid.substring(0, Math.min(length, uuid.length()));

        }
    }




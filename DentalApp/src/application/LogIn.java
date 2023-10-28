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
            FileReader fileReader = new FileReader(file+"\\logins.txt");
            System.err.println("file exits!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fileWriter = new FileWriter(file+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    //Adds preliminary data in txt file
	void addData(String usr, String pswrd, String name, String lastName, String Age, String contactNumber) {
	    try {
	        RandomAccessFile raf = new RandomAccessFile(file + "\\logins.txt", "rw");
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
	
	//Check Data
	void CheckData(String usr, String pswrd) {
    try (RandomAccessFile raf = new RandomAccessFile(file+"\\logins.txt", "r")) {
        String line;
        boolean match = false;
        while ((line = raf.readLine()) != null) {
            if (line.startsWith("Username: ")) {
                username = line.substring(10);
            } else if (line.startsWith("Password: ")) {
                password = line.substring(10);
                if (username != null && password != null && usr.equals(username) && pswrd.equals(password)) {
                    match = true;
                    break;
                } else {
                    username = null;
                    password = null;
                }
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
    } catch (FileNotFoundException ex) {
        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
    

        // Method to generate a random string of a specified length
     public static String generateRandomString(int length) {
         String uuid = UUID.randomUUID().toString().replace("-", "");
         return uuid.substring(0, Math.min(length, uuid.length()));

        }
    }




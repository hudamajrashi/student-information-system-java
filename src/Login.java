package FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Login {
       private String usernameAccount;  //username to login
     private String password;  //password to login

    public Login() {
  
       this.usernameAccount = "Admin";  // this is the username
          this.password = "abcd"; // this is the password
    }

    
      
      public boolean authentication(String inputUsername, String inputPassword) {  //if enter anotjer usernamed&password return error
        if (inputUsername == null || inputPassword == null) {
            return false;
        }
        return inputUsername.equals(usernameAccount) && inputPassword.equals(password);
    }
}


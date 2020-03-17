package it.polito.tdp.alien;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Map<String,String> map = new HashMap<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtView;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtView.clear();
    


    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String word = txtInsert.getText();
    	
    	if(word.length()==0) {
    		txtView.appendText("Devi inseire una parola o una trduzione.\n");
    		return;
    		}
    	
    	
    	if(word.contains( " "))
    			{
    		  String[] words = word.split(" ");
    		  if(!words[0].matches("[a-zA-Z]*") || !words[1].matches("[a-zA-Z]*"))
  			{
  		txtView.appendText("Formato non valido\n");
  		return;
  			} 
  
    		  this.map.put(words[0], words[1]);
    			}
    	else
    	{	  if(!word.matches("[a-zA-Z]*"))
			{
		txtView.appendText("Formato non valido\n");
		return;
			}
    		if(this.map.containsKey(word))
    		
    		txtView.appendText(this.map.get(word)+"\n");
    		else
    		txtView.appendText("La parola non è presente nel dizionario! Aggiungila!\n");
    	}
    
    	
 
    
    	

    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtView != null : "fx:id=\"txtView\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

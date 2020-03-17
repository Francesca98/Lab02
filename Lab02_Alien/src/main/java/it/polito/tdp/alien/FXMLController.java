package it.polito.tdp.alien;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Map<String,Set<String>> map = new HashMap<>();

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
    	String word = txtInsert.getText().toLowerCase(); //nella mappa tutto il testo è minuscono
    	
    	if(word.length()==0) {
    		txtView.appendText("Devi inseire una parola o una trduzione.\n");
    		return;
    		}
    	//'francesca ' se fai  lo split da err
    	
    	if(word.contains( " "))
    			{
    	 String[] words = word.split(" ");
    		
    		 String parola = words[0];
    		 String translate = words[1];
    		
    		  if(!parola.matches("[a-zA-Z]*") || !translate.matches("[a-zA-Z]*"))
  			{
  		txtView.appendText("Formato non valido\n");
  		return;
  			} 
    		  
    		  
    		  if(this.map.containsKey(parola))
    		  {this.map.get(parola).add(translate);}
    		  else
    		  {Set<String>list = new HashSet<>();
    		  list.add(translate);
    		  this.map.put(parola, list);
    		  }
    		  
    		  
    		  
    		  
  
    		 
    			}
    	else
    	{	  if(!word.matches("[a-zA-Z]*")  )
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

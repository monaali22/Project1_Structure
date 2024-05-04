package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Date;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.util.*;
import javafx.scene.control.TextArea;

public class Main extends Application {
	
	Double_LinkedList doubleList = new Double_LinkedList();
	Martyr_Location location ;
	Martyr martyr ;
	Linked_List singleLinkedList = new Linked_List();
	TextField selectlocation = new TextField();

	
	@Override
	public void start(Stage primaryStage)throws Exception {
		 Scene scene = new Scene(firstScrren(primaryStage) , 800 ,500);
		 primaryStage.setScene(scene);
		 primaryStage.show();

		 
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public BorderPane firstScrren(Stage stage) {
		
		 BorderPane borderpane = new BorderPane(); // create a new Pane 
		 //Image image1 = new Image("C:\\Users\\Lenovo\\Desktop\\Qudes.jpg"); // add image to the scene 
		 //ImageView imageView = new ImageView(image1);
		 Label label1 = new Label (); // create a label
		 Button button1 = new Button ("Read File"); // button to read from file 
		 Button button2 = new Button ("Next"); // this button show the second  screen 
		 HBox hBox = new HBox(30);

		// button2.setVisible(false);
		 
		 hBox.setAlignment(Pos.CENTER);
		 hBox.getChildren().addAll(button1 ,button2 );
		 
		 		 
		 label1.setText(" Palestinian martyrs "); // add text to the label
		 label1.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,30)); // set font to the label
		 
		 
		// imageView.setFitWidth(300);
		// imageView.setFitHeight(300);
		 
		 
		 borderpane.setPadding(new Insets (5 ,5,5,5));
		// borderpane.setCenter(imageView); // add imageView to pane 
		 borderpane.setTop(label1); // add label1 to the pane 
		 borderpane.setBottom(hBox); // add hBox to pane 
		 
		 
		 
		 button1.setOnAction(e->{ // button 1 action 
			
					try {
						readfile(stage); // call read fill method 
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 button2.setVisible(true);

				
			
		 });
		 
		 button2.setOnAction(e->{ // button 2 action 
			secandScreen () ;		 // show second screen
	});
		
		 
		 return borderpane;
		
	}

   public Pane secandScreen () { // second screen with the tab 
		
	    Stage stage = new Stage();
	    
	    TabPane tabPane = new TabPane(); // create a new Tab pane 
	    // create a five Tab
	    Tab tab1 = new Tab("Location Screen"); // tab 1
	    Tab tab2 = new Tab("Martyrs Screen"); // tab 2
	    Tab tab3 = new Tab("Statistics Screen"); // tab 3
	    Tab tab4 = new Tab("Save Screen"); // tab 4 
	    Tab tab5 = new Tab("Report Screen"); // tab 5 

	    GridPane pane = new GridPane(); // create a pane 
	    BorderPane border = new BorderPane();
	    
	    tab1.setContent(firstTab());
	    tab2.setContent(secandTab());
	    tab3.setContent(tabThree());
	    tab4.setContent(fourtab());
	    tab5.setContent(tabFive());
	    
		border.setTop(tabPane);	 // add the Tab pane to the border pane 
		 

		 tabPane.getTabs().addAll( tab1 , tab2, tab3 ,tab4 , tab5); // add all tab to the tab pane 
		 
		 Scene scene = new Scene(border , 800 , 500);  // create a new scene 
		 stage.setScene(scene); // add scene to the stage 
		 stage.show(); // show the stage 
		 
		 return border;

	}
	 
  public Pane firstTab() { // method for the first Tab 
	Stage stage = new Stage(); // crate a new Stage 
	TextField locText = new TextField(); // Create a text to enter a location name 
	Label label = new Label("Location");
	Label labe2 = new Label(" Selected which option you need to do "); // create a label 
	Label labeError = new Label("This Location does not exist try again ");

	labe2.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,25)); // set font to the label
	labeError.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));// set font to the labeError
	labeError.setStyle("-fx-text-fill:red"); // set colour to the label font 
	labe2.setStyle("-fx-text-fill:blue");// set colour to the label font 
	labeError.setVisible(false);
	
	 GridPane pane = new GridPane(); // create a new pane 
	 
	 
	  
    HBox hBox = new HBox(10); // create a HBox
    HBox hBox1 = new HBox(10);
	HBox box = new HBox(10);
    VBox vBox = new VBox(30); // create a VBox

    // Create a for Radio Button 
	RadioButton button1 = new RadioButton("Insert new Location"); //  RadioButton 1 
	RadioButton button2 = new RadioButton("Update a location"); // RadioButton 2
	RadioButton button3 = new RadioButton("Delete a location "); //RadioButton 3
	RadioButton button4 = new RadioButton("Search for a Location"); // RadioButton 4
	
	ToggleGroup group = new ToggleGroup(); // create ToggleGroup and put all button inside it 
	button1.setToggleGroup(group);
	button2.setToggleGroup(group);
	button3.setToggleGroup(group);
	button4.setToggleGroup(group);

	
	
	 hBox.setAlignment(Pos.CENTER); // put a hBox in the centre
	 hBox1.setAlignment(Pos.CENTER);
	 hBox1.getChildren().addAll(label , locText);
     hBox.getChildren().addAll(button1 , button2 , button3 , button4); // add all button to the HBox
    
     vBox.setAlignment(Pos.CENTER); // put the VBox in the centre
     vBox.getChildren().addAll(labe2 ,hBox1 , box, hBox); // add All Box to the VBox
     
        TextField newLocText = new TextField(); // create a new text Field 
		Label newLoclabel = new Label("New Location"); // create a new Label
		box.getChildren().addAll(newLoclabel , newLocText ); // add the label and field to the box
		
		box.setVisible(false);

		pane.setHgap(5);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER); // put the pan in the Centre 
		pane.add(labe2, 0, 1); // add the label to the pane  
		pane.add(hBox, 0, 7); // add the HBox to the pane 
		//pane.add(labeError, 0, 4);
	
		
		
	
		button1.setOnAction(e->{   // The the Action for first radio button  
		
			if (button1.isSelected()) {
				Scene scene1 = new Scene(insertlocation () , 800 ,500);
				stage.setScene(scene1);
				stage.setTitle("Insert a new Location ");
				stage.show();
			}
		});
		
		
		button2.setOnAction(e->{ // The the Action for  radio button  2 
			if (button2.isSelected()) {
				Scene scene2 = new Scene(updatelocation () , 800 ,500);
				stage.setScene(scene2);
				stage.setTitle("Update a Location ");
				stage.show();
			}
		});
		
		button3.setOnAction(e->{ // The the Action for  radio button  3
			if (button3.isSelected()) {
				Scene scene3 = new Scene(deleteLocation () , 800 ,500);
				stage.setScene(scene3);
				stage.setTitle("Delete a Location ");
				stage.show();
			}
		});
		button4.setOnAction(e->{ // The the Action for  radio button  4
     	  if (button4.isSelected()) {
				 //writeFile();	
				Scene scene4 = new Scene(search () , 800 ,500);
				stage.setScene(scene4);
				stage.setTitle("Select a Location ");
				stage.show();

			
			}
			
		});
		
      return pane;

}

         public Pane insertlocation () {  // this method for the insert location in tab one 
 			GridPane gridPane1 = new GridPane();  // create a new Pane 

        	 Label label = new Label("Location"); // create a new label 
        	 Label ErrorMassage = new Label("This Location is already exist in list"); // create a new label 
 			Label lab1 = new Label("Enter a Location name to insert it");// create a new label 
			 
			 TextField locText = new TextField(); // create a new text field to write the Location name 
			 
			 // create a two button 
			 Button back = new Button ("Back");
			 Button insert = new Button ("Insert");
			 
			 // create a two HBox 
        	 HBox hBox1 = new HBox(10);
			 HBox buttonBox = new HBox(20);

        	 
        	 hBox1.setAlignment(Pos.CENTER); // put the HBox in the centre
        	 hBox1.getChildren().addAll(label , locText); // Add the label and text to the HBox 
        	 
			 
			 buttonBox.setAlignment(Pos.CENTER); // put the HBox in the centre
			 buttonBox.getChildren().addAll(back ,insert ); // add the two button to the HBox 
			
			ErrorMassage.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)); // set font to the ErrorMassage
			ErrorMassage.setStyle("-fx-text-fill:red"); // set colour to the ErrorMassage
			lab1.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));// set font to the label
			lab1.setStyle("-fx-text-fill:blue"); // set colour to the label


			
			gridPane1.setAlignment(Pos.CENTER); // set the pane in the centre of the scene 
			gridPane1.setHgap(5);
			gridPane1.setVgap(10);
			gridPane1.add(lab1, 0, 0); // add label to the pane 
			gridPane1.add(hBox1, 0, 2); // add hBox1 to the pane 
			gridPane1.add(buttonBox, 0, 5); // add buttonBox to the pane 
			

			back.setOnAction(e->{ // the Action of the Back method to show first screen
				secandScreen (); // show first screen 
			});
			
			insert.setOnAction(e->{

				if (doubleList.search(new Martyr_Location(locText.getText())) == null) { // this statement to check if the location is exist before 
					//location = new Martyr_Location (locText.getText());
					 doubleList.insertSort(new Martyr_Location (locText.getText())); // add the new location to the double list
				}
				
				else 
					gridPane1.add(ErrorMassage, 0, 6); // if the location is fount show error massage
					
			});
			
			
			return gridPane1 ;
			
			
			
         }
         
         public Pane deleteLocation() { // this method to delete a location if exist 
        	 GridPane gridPane1 = new GridPane(); // create a new GridPane 

        	 Label label = new Label("Location"); // Create a new label 
        	 Label ErrorMassage = new Label("This Location does Not exist in list"); // create a Error massage 
 			Label lab1 = new Label("Enter a Location name to delete it");//create a new Label 
			 
			 TextField locText = new TextField(); // create a text field 
			 
			 Button back = new Button ("Back");
			 Button delete = new Button ("Delet");
			 
        	 HBox hBox1 = new HBox(10);
			 HBox buttonBox = new HBox(20);

        	 
        	 hBox1.setAlignment(Pos.CENTER);
        	 hBox1.getChildren().addAll(label , locText);
        	 
			 
			 buttonBox.setAlignment(Pos.CENTER);
			 buttonBox.getChildren().addAll(back ,delete );
			
			ErrorMassage.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
			ErrorMassage.setStyle("-fx-text-fill:red");
			ErrorMassage.setVisible(false);
			lab1.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
			lab1.setStyle("-fx-text-fill:blue");


			
			gridPane1.setAlignment(Pos.CENTER);
			gridPane1.setHgap(5);
			gridPane1.setVgap(10);
			gridPane1.add(lab1, 0, 0); //
			gridPane1.add(hBox1, 0, 2);
			gridPane1.add(buttonBox, 0, 5);
			gridPane1.add(ErrorMassage, 0, 6);
			
			back.setOnAction(e->{
				secandScreen ();
			});
			
			delete.setOnAction(e->{
				location = new Martyr_Location(locText.getText());
				if (doubleList.search(location) != null) {
					doubleList.delete(location);
					
					
				}
				
				
				else 
					ErrorMassage.setVisible(true);

					
				
					
					
			});
			
			
			return gridPane1 ;
			
        	 
         }
         
         public Pane updatelocation() { // this method update a location name 
        	 
        	 GridPane gridPane1 = new GridPane(); // create a new pane 

        	 Label label = new Label("Location"); // create a new Label 
        	 Label ErrorMassage = new Label("This Location does Not exist in list"); // Error massage 
 			 Label lab1 = new Label("Enter a Location name to Update it");
 			 
 			 Label newlabel = new Label(" New Location");
			 TextField newText = new TextField();
			 HBox hBox3 = new HBox(10);
			 
			 hBox3.setAlignment(Pos.CENTER);
        	 hBox3.getChildren().addAll(newlabel , newText);
			 
			 TextField locText = new TextField();
			 
			 Button back = new Button ("Back");
			 Button update = new Button ("Update");
			 Button check = new Button ("Check");

			 update.setDisable(true);
			 
        	 HBox hBox1 = new HBox(10);
			 HBox buttonBox = new HBox(20);

        	 
        	 hBox1.setAlignment(Pos.CENTER);
        	 hBox1.getChildren().addAll(label , locText);
        	 
			 
			 buttonBox.setAlignment(Pos.CENTER);
			 buttonBox.getChildren().addAll(back ,update );
			
			ErrorMassage.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
			ErrorMassage.setStyle("-fx-text-fill:red");
			ErrorMassage.setVisible(false);
			lab1.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
			lab1.setStyle("-fx-text-fill:blue");

			hBox3.setVisible(false);
			
			gridPane1.setAlignment(Pos.CENTER);
			gridPane1.setHgap(5);
			gridPane1.setVgap(10);
			gridPane1.add(lab1, 0, 0);
			gridPane1.add(hBox1, 0, 2);
			gridPane1.add(check, 1, 2);
			gridPane1.add(buttonBox, 0, 5);
			gridPane1.add(hBox3, 0, 4);
			gridPane1.add(ErrorMassage, 0, 6);

			
			back.setOnAction(e->{
				secandScreen ();
			});
			
			check.setOnAction(e->{ //  check if the location is exist
				if (doubleList.search(new Martyr_Location(locText.getText())) != null) {
					hBox3.setVisible(true);
					 update.setDisable(false);


				}
				
				else {
					hBox3.setVisible(false); // hide hBox3
					 update.setDisable(true); // setDisable update for false 
					ErrorMassage.setVisible(true);

				}
			});
			
			update.setOnAction(e->{
				
					doubleList.update(locText.getText(), newText.getText()); // update a location name 

				
			});
			
			
			return gridPane1 ;
			
        	 
         }
         
         
         
         public Pane search() {  // this method to search by location 
        	 GridPane pane = new GridPane(); // create a new pane 
        	 Label label = new Label("Location");
        	 Label ErrorMassage = new Label("This Location does Not exist in list");

			 TextField locText = new TextField();
			 HBox box = new HBox(10);
			// TextArea textArea = new TextArea();
			 
			 Button back = new Button ("Back");
			 Button Select = new Button ("Select");
			 Button Search = new Button ("Search"); 
			 
			 ErrorMassage.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)); // set font to the ErrorMassage
			 ErrorMassage.setStyle("-fx-text-fill:red"); // set colour to the ErrorMassage
			 ErrorMassage.setVisible(false); //hide  the ErrorMassage 
				
			 box.setAlignment(Pos.CENTER);
			 box.getChildren().addAll(back ,Select , Search ); // add all button to the HBox

        	 			 
			 pane.setAlignment(Pos.CENTER);
			 pane.setHgap(10);
			 pane.setVgap(10);
			 pane.add(label, 0, 0);
			 pane.add(locText, 1, 0);
			 pane.add(box, 1, 3);
			 pane.add(ErrorMassage, 1, 5);
			 
			 back.setOnAction(e->{
				 secandScreen ();
				 
			 });
			 Search.setOnAction(e->{ // this action to search the all in information  in the location 
				
					 selectlocation.setText(locText.getText());
					 doubleList.textArea(new Martyr_Location(selectlocation.getText()));
					 
					 
				 
				 
				 
			 });
			 
			 Select.setOnAction(e->{ // this button to select a location 
				 
				 if (doubleList.search(new Martyr_Location(locText.getText())) != null) { // check if the location is exist
					 selectlocation.setText(locText.getText());
					 
				 }
				 
				 else 
					 ErrorMassage.setVisible(true); // show ErrorMassage
				 
			 });

			 
        	 return pane;
         }

         
         
         
      public Pane secandTab()  { // this tab to show operation for martyr operation 
    	  
    	    GridPane pane = new GridPane(); // create a grid pane 
 			Label lab1 = new Label("Enter a Martyr Information"); // create a label
 			Label Error = new Label("Please fill all TextField "); // create error massage label

 			lab1.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)); // 
			lab1.setStyle("-fx-text-fill:blue");
 			Error.setVisible(false);
 			Error.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
 			Error.setStyle("-fx-text-fill:red");

    	    HBox hBox = new HBox(10); // create a HBox 

    		TextField nameText = new TextField(); // Create a TextField
    		Label nameLabelt = new Label("Name"); // create a label 

    		TextField ageText = new TextField(); 
    		Label ageLabel = new Label("Age");
    		ageText.setVisible(false);
    		ageLabel.setVisible(false);

    		TextField dateOfDethText = new TextField();
    		Label dateOfDethLabel = new Label("Date Of Deth");
    		dateOfDethText.setVisible(false);
    		dateOfDethLabel.setVisible(false);
    		

    		TextField genderText = new TextField();
    		Label genderLabel = new Label("Gender");
    		genderText.setVisible(false);
    		genderLabel.setVisible(false);

    		
    		
    		// create a five button 
    		Button button1 = new Button("Insert");
    		Button button2 = new Button("Update");
    		Button button3 = new Button("Delete");
    		Button button4 = new Button("Search");
    		Button back = new Button("Back");
    		
    		 hBox.setAlignment(Pos.CENTER);
    	     hBox.getChildren().addAll(back , button1 , button2 , button3 , button4); // add all button to the HBox



    		pane.setAlignment(Pos.CENTER);
    		pane.setVgap(20);
    		pane.setHgap(10);
    		
    		pane.add(lab1, 1, 0);
    		pane.add(nameLabelt, 0, 2);
    		pane.add(ageLabel, 0, 3);
    		pane.add(dateOfDethLabel, 0, 4);
    		pane.add(genderLabel, 0, 5);
    		
    		pane.add(nameText, 1, 2); // add nameText to the pane 
    		pane.add(ageText, 1, 3); // add ageText to the pane 
    		pane.add(dateOfDethText, 1, 4); // add dateOfDethText to the pane 
    		pane.add(genderText, 1, 5);// add genderText to the pane
    		pane.add(hBox, 1, 7);// add hBox to the pane
    		pane.add(Error, 1, 8);// add Error to the pane

    		ageText.setVisible(true);
    		ageLabel.setVisible(true);

    		dateOfDethText.setVisible(true);
    		dateOfDethLabel.setVisible(true);
    		
    		genderText.setVisible(true);
    		genderLabel.setVisible(true);
	
    		
    			
    		button1.setOnAction(e->{ // Action for Insert button
    			
     
        		
    				try {
    					SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy"); // to convert string to date
    					if (doubleList.search(new Martyr_Location(selectlocation.getText())) != null) {
    					// insert new Martyr
    					doubleList.search(new Martyr_Location(selectlocation.getText())).singleList.insertSort(new Martyr (nameText.getText() , Integer.parseInt(ageText.getText()) ,format.parse(dateOfDethText.getText()) , genderText.getText().charAt(0)) );
    					}
    				} catch (ParseException e1) {
    					e1.printStackTrace();
    				

        		}
    		});
    		
    		button2.setOnAction(e->{ // Action for update 
    			try {
					SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy"); // to convert string to date
					if (doubleList.search(new Martyr_Location(selectlocation.getText())) != null) {
					// insert new Martyr
					doubleList.search(new Martyr_Location(selectlocation.getText())).singleList.update(new Martyr (nameText.getText() , Integer.parseInt(ageText.getText()) ,format.parse(dateOfDethText.getText()) , genderText.getText().charAt(0)));
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				

    		}
    			
    			
    		});
    		button4.setOnAction(e->{ // Action for Search button 
    			searchByName(nameText.getText());
    			
    		});
    		
    		button3.setOnAction(e->{  // Action of delete button 
    			ageText.setVisible(false);
        		ageLabel.setVisible(false);

        		dateOfDethText.setVisible(false);
        		dateOfDethLabel.setVisible(false);
        		
        		genderText.setVisible(false);
        		genderLabel.setVisible(false);
        		
        	//	if (doubleList.search(new Martyr_Location(selectlocation.getText())) != null) {
			    doubleList.search(new Martyr_Location(selectlocation.getText())).singleList.delete(new Martyr (nameText.getText()));			   
        		
    		});    		
    		
    		back.setOnAction(e->{
    			secandScreen();
    		});
    			
    		return pane;

      }
      
      public Pane tabThree() {  // this tab show All Summary in select location 
  	        HBox hBox = new HBox(15);  // create a new HBox
  	        GridPane pane = new GridPane(); // crate a new Grid pane 
  	  	   TextArea textArea = new TextArea();  // Create a TextArea
  		   StringBuilder stringBuilder = new StringBuilder();  // StringBuilder to save All Martyr  search by Name
      	    Label ErrorMassage = new Label("Select A location please ");
      	
			 ErrorMassage.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)); // set Font to Label
			 ErrorMassage.setStyle("-fx-text-fill:red"); // set colour to label
			 ErrorMassage.setVisible(false); // hide an ErrorMassage
				


  	        // create a three button 
    		Button button1 = new Button("Summary for Loction you Sealect");
    		Button button2 = new Button("Summary for next location ");
    		Button button3 = new Button("Summary for privous location");
    		
    		hBox.setAlignment(Pos.CENTER);
    		hBox.getChildren().addAll( button3 ,button1, button2  ); // add all Button to hbox
    		
    		pane.setAlignment(Pos.CENTER); // set a grid pane in centre
    		pane.setHgap(10);
    		pane.setVgap(10);
    		pane.add(textArea, 0, 0); // add textArea to the pane 
    		pane.add(hBox, 0, 5); // add hBox to the pane 
    		pane.add(ErrorMassage, 0, 7); // add ErrorMassage to the pane 


    		button1.setOnAction(e->{  // the action for button 1
    			if (selectlocation.getText().isEmpty() == false) { // check if the user select a location 

    			stringBuilder.append(Summary(new Martyr_Location(selectlocation.getText()))).append("\n"); // add all information to
    			                                                                                              // stringBuilder
    			textArea.setText(stringBuilder.toString()); // print information in text Area
    			}
    			
    			else 
   				 ErrorMassage.setVisible(true); // hide not  an ErrorMassage

    		});
    		
    		button2.setOnAction(e->{ // this button to print the information for the next location 
    			if (selectlocation.getText().isEmpty() == false) { // check if the user select a location 
    			Double_Node nextNode = doubleList.search(new Martyr_Location(selectlocation.getText())).getNext();// the node of next location you select
    			if (nextNode == null) {
    				button2.setDisable(true);
    			}
    			else {
    				textArea.clear();
    				String nextlocation  = nextNode.getData().getLocation(); // the location  of next location you select
    				stringBuilder.append(Summary(new Martyr_Location(nextlocation))).append("\n");// add all information to
                                                                                                       // stringBuilder 
        			textArea.setText(stringBuilder.toString());// print information in text Area
    			}
    			}
    			
    			else 
    				
    				 ErrorMassage.setVisible(true);// hide not  an ErrorMassage

    		});
    		

    		button3.setOnAction(e->{ // this button to print information for previous location 
    			if (selectlocation.getText().isEmpty() == false) { // check if the user select the location 
    			Double_Node privNode = doubleList.search(new Martyr_Location(selectlocation.getText())).getPrivous();
    			if (privNode == null) {
    				button2.setDisable(true);
    			}
    			else {
    				textArea.clear();
    				String nextlocation  = privNode.getData().getLocation(); // get the name of the previous location 
    				stringBuilder.append(Summary(new Martyr_Location(nextlocation))).append("\n");
        			textArea.setText(stringBuilder.toString()); // print information in teat area
    			}
    			}
    			
    			else 
    				
    				 ErrorMassage.setVisible(true); // show ErrorMassage
    		});
    		return pane;

    		
      }

      
      public Pane fourtab() {  // this tab to save all sorted data in side the file you select 
    	  GridPane  pane = new GridPane (); //create a new Grid pane 
    	  Stage stage = new Stage (); // Create a new Stage 
    	  Label label = new Label ("Save All information to the file "); // Create a new Label
    	  Button save = new Button ("Save"); // create a button to save information 
    	  label.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)); // set a font to the label
    	  label.setStyle("-fx-text-fill:blue"); // set a colour to the label
    	  
    	  pane.setAlignment(Pos.CENTER);
    	  pane.setVgap(15);
    	  pane.add(label, 0, 0); // add label to the pane 
    	  pane.add(save, 0, 4); // add button to the pane
    	  
    	  
    	  save.setOnAction(e->{ // the Action for the save button 
    		  writeFile(stage);
    	  });
    	  
    	  return pane ;

      }
      
      public Pane tabFive() { // this tab show all  Martyr information by his name 
    	  GridPane pane = new GridPane(); // create a new grid Pane 
    	  TextField text = new TextField(); // text field to put the name to search it in all location 
    	  Label lab = new Label("Name");
    	  Button search = new Button("Search");
    	  lab.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,20));
    	  lab.setStyle("-fx-text-fill:red");
    	
    	  pane.setAlignment(Pos.CENTER); // put the gridPane in the centre of scene 
    	  pane.add(lab, 0, 0); // add label to grid pane 
    	  pane.add(text, 1, 0); // add text to grid pane 
    	  pane.add(search, 1, 3); // add button to grid pane 
    	  pane.setVgap(15);
    	  pane.setHgap(15);
    	  
    	  search.setOnAction(e->{ // search button Action 
    		 // writeFile();
    		  searchNameInLocation(text.getText()); // calling 
    	  });
    	  
    	  return pane;
      }
     public void readfile(Stage primaryStage) throws ParseException { // this method read all date from a file you choose and save it
    	  // choose a file to read information from it 
    	 FileChooser fileChooser = new FileChooser();
    	 fileChooser.setTitle("Open Resource File ");
    	 fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*")); // show the file in stage
    	 File file = fileChooser.showOpenDialog(primaryStage);
    	 
    	 if (file != null) { // check if the file has data 
    		 try {
				Scanner scanner = new Scanner (file); // read from file 
				while (scanner.hasNextLine()) {
					String Line = scanner.nextLine(); // take line line from file 
					String [] split = Line.split(","); // split the file by ,

					if (split[1] == "") { // if the line has not age 
						split[1] ="0"; // set age zero
					}
						
					String name = split[0]; // take the first index from line 
					int age = Integer.parseInt(split[1]); // take the  index two from line  and convert it to integer
					Date dateOfDeth = new SimpleDateFormat("MM/dd/yyyy").parse(split[3]); // take the  index three from line  and convert it to date
					char gender = split[4].charAt(0);
					String locationName = split[2];
					
					
					martyr = new Martyr (name , age , dateOfDeth ,gender ); // create Martyr object with the data you read from file 
				    location = new Martyr_Location (locationName); // create a location object with the data you read from file 


				   if (doubleList.search(location) == null) { // if the location he read from file not found 
					   
					     doubleList.insertSort(location);// insert location to double list
					     doubleList.search(location).singleList.insertSort(martyr);	// insert Martyr information to single list			   
					   
				   }
				   else { // if the location he read from file  found 
					   doubleList.search(location).singleList.insertSort(martyr); // insert Martyr information to single list

				   
				   }
					
					}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		 
    	 }
    	
}
     
     public void writeFile(Stage primaryStage) {
    	 // choose the file to write the new Sorted data inside it 
    	 FileChooser fileChooser = new FileChooser();
    	 fileChooser.setTitle("Open Resource File ");
    	 fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*")); // show the file in stage
    	 File file = fileChooser.showOpenDialog(primaryStage);
    	 try {
			PrintWriter writer  = new PrintWriter(file); // create a Print Writer
			
			
			 
			Double_Node curr ;  // double Node
			Single_Node curr2 ;; // single Node

			
		     for (curr = doubleList.getFirst() ; curr != null  ;  curr = curr.getNext()) {// for loop to Spins in double list
		    	  if (curr.singleList.getFirst() == null) {
		    		  writer.write(curr.getData().getLocation()); // write inside the file you select
		    		  //System.out.println(curr.getData().getLocation()) ;

		    	  }
		    	  else {
		    	  for (curr2 = curr.singleList.getFirst() ; curr2 != null ; curr2 = curr2.getNext()) { // for loop to Spins linked list node by node
		    		  writer.write(curr2.getData().getName()+" , "+curr2.getData().getAge()+" , "+curr.getData().getLocation()
		    				  +" , "+curr2.getData().getDateOfDeth()+" , "+curr2.getData().getGender()); 
		    		  //System.out.println(curr.getData().getLocation() + ":" + curr2.getData().toString() +" : "+curr.singleList.listLength ) ;
		    	  }
		    	
					
				}
		     
		     }
		     writer.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
     }
     
     public String Summary(Martyr_Location summaryLocation) { // this method return all summary information about martyr after
    	                                                       // you select a location 
    	 int numberOfM = 0; // counter a count a number of female
    	 int numberOfF = 0 ; // counter a count a number of male
    	 int Sum = 0 ; // count a sum of age 
    	 double count = 0 ; // count a number a martyr
    	 double average; // count the sum of age and devise the total number 
    	 
			Single_Node curr2 = doubleList.search(summaryLocation).singleList.getFirst() ; // first node in single list 
			for ( ; curr2 != null ; curr2 = curr2.getNext()) { // for loop to Spins linked list node by node
				Sum+= curr2.getData().getAge(); // add the new age to sum 
				count++; // Increase the count of martyr by 1 
				if (curr2.getData().getGender() == 'M') { // Check  if the martyr is male
					numberOfM++; // Increase the count of male by 1 
				}
				else if (curr2.getData().getGender() == 'F') { // Check  if the martyr is female
					numberOfF++; // Increase the count of female by 1 
				}
				else {
					// dose not increase a number of male or female
					numberOfM+=0;   
					numberOfF+=0;
				}
			}
    	 
			average = Sum/count;
			double percentage = (count/Length())*100; //  percentage
			 
			// Summary 
			return  "The Number Of Male : " +numberOfM  + "\n The number Of Femal : "+numberOfF+"\n The avarge of age = " +average+
					"\n Percentage of the number of martyrs in an Location"+percentage+" % ";
     }
     
    
     
     public int Length() { // this method calculate the total number of martyr
    	 int Count = 0 ;
    	 Double_Node curr = doubleList.getFirst(); // double node
    	 Single_Node curr2 ; // single node
    	 for (curr = doubleList.getFirst() ; curr != null  ;  curr = curr.getNext()) { // for loop to Spins in double list
			for ( curr2 = curr.singleList.getFirst(); curr2 != null ; curr2 = curr2.getNext()) { // for loop to Spins in single list
				Count++; // Increase the count by 1 
			}
			
 
     }
         return Count; // return total number

     }
     
     // this method to search in single linked list for the name you choose
   public void searchByName(String name ) {
	   Stage stage = new Stage(); // create New stage 
  	   TextArea textArea = new TextArea();  // Create a TextArea

  	   GridPane pane = new GridPane ();
	   Button back = new Button ("Back"); // this Button to Back in before scene
	   StringBuilder stringBuilder = new StringBuilder();  // StringBuilder to save All Martyr  search by Name
		 
		 textArea.setMinWidth(500);
		 textArea.setMaxHeight(500);
		 

      
  	 pane.setAlignment(Pos.CENTER); // set GridPane in centre of scene 
  	 pane.add(textArea, 0, 0);
  	 pane.add(back, 3, 7);
  	 
  	 
	   if (doubleList.search(new Martyr_Location(selectlocation.getText())) != null) { // if the location you select is exist
		   
	   Single_Node curr2 = doubleList.search(new Martyr_Location(selectlocation.getText())).singleList.getFirst() ; // first node in single list of the location you select
	   
	   for ( ; curr2 != null ; curr2 = curr2.getNext()) { // for loop to Spin on the list
		   if (curr2.getData().getName().contains(name)) { // if the node has the same name you search 
			   stringBuilder.append(curr2.getData().toString()).append("\n"); // append string to stringBuilder
			   textArea.setText(stringBuilder.toString()); // print all information to Area List
		   }
	   }
	   }
	   
	   else //If the name you are searching for does not exist
		   textArea.setText("The given Name is Not found");  
		   
	   back.setOnAction(e->{ // back button action
		   secandScreen();
	   });
	   
	   
	   Scene scene = new Scene(pane , 800 , 500);  // Create a scene
	   stage.setTitle("Report stage");
	   stage.setScene(scene);    // Set the scene
	   stage.show();   // Show the stage
   }
   
   
   
   public void searchNameInLocation(String name ) { // this method search in All Location about name you select
  	     Stage stage = new Stage(); // create new Stage 
  	     GridPane pane = new GridPane (); // Create a grid pane 
		 Button back = new Button ("Back"); // this Button to return in first scene

	   StringBuilder stringBuilder = new StringBuilder(); // StringBuilder to save Martyr information 
  	   TextArea textArea = new TextArea(); // create a text Area
  	   
  	 pane.setAlignment(Pos.CENTER); // put the grid pane to the centre of scene
	 pane.add(textArea, 0, 0);
	 pane.add(back, 3, 7);

	    Double_Node curr ; // Double Node 
		Single_Node curr2; // single Node 
		
	/// the you 
		
		for (curr = doubleList.getFirst() ; curr != null ; curr = curr.getNext()) { // for loop to Spins in double list
			for (curr2 = curr.singleList.getFirst() ;curr2 != null ; curr2 = curr2.getNext()) { // for loop to Spins in single list
				if (curr2.getData().getName().contains(name)) { // check if the Name in Node has the same name you search
					 stringBuilder.append(curr.getData().getLocation()+" : "+curr2.getData().toString()).append("\n"); // append string to stringBuilder
				}
				   textArea.setText(stringBuilder.toString()); // print all information to Text Area

			}
		}
		
		 back.setOnAction(e->{ // button Action to return to first scene
			secandScreen (); // show second scene 
		 });
		 
		 Scene scene = new Scene(pane , 800 , 500); // Create a Scene 
		 stage.setScene(scene); // add a scene to the stage 
		 stage.setTitle("Report for Location "); // Add title to the stage 
		 stage.show();  // show the stage 
		 
   }
   
   
   
   

}

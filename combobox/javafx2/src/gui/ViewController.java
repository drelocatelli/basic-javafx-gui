package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {
	
	@FXML
	private ComboBox<Person> comboboxPerson;
	
	private ObservableList<Person> obsList;
	
	@FXML
	private Button submitBtn;
	
	@FXML
	public void onSubmit() {
		onComboBoxPersonAction();
	}
	
	@FXML
	public void onComboBoxPersonAction() {
		// pega o item selecionado no combobox
		Person person = comboboxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person.name);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg01) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(1, "Bob", "bob@gmail.com"));
		list.add(new Person(1, "Alex", "alex@gmail.com"));
		
		obsList = FXCollections.observableArrayList(list);
		comboboxPerson.setItems(obsList);
		
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		
		comboboxPerson.setCellFactory(factory);
		comboboxPerson.setButtonCell(factory.call(null));
	}
	
}

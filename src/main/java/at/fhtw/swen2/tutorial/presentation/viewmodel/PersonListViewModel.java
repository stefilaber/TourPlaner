package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

@Component
public class PersonListViewModel {

    private ObservableList<NewPersonViewModel> personListItems = FXCollections.observableArrayList();

    public ObservableList<NewPersonViewModel> getPersonListItems() {
        return personListItems;
    }

    public void addItem(Person person) {
        personListItems.add(new NewPersonViewModel(person));
    }


}

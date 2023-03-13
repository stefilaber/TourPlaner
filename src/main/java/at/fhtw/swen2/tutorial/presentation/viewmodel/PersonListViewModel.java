package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.PersonService;
import at.fhtw.swen2.tutorial.service.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonListViewModel {

    @Autowired
    PersonService personService;

    private ObservableList<NewPersonViewModel> personListItems = FXCollections.observableArrayList();

    public ObservableList<NewPersonViewModel> getPersonListItems() {
        return personListItems;
    }

    public void addItem(Person person) {
        personListItems.add(new NewPersonViewModel(person));
    }

    public void clearItems(){ personListItems.clear(); }

    public void initList(){
        personService.getPersonList().forEach(p -> {
            addItem(p);
        });
    }




}

package at.fhtw.swen2.tutorial.presentation.view;


import at.fhtw.swen2.tutorial.presentation.viewmodel.NewPersonViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.PersonListViewModel;
import at.fhtw.swen2.tutorial.service.PersonService;
import at.fhtw.swen2.tutorial.service.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@Component
//@Scope("prototype")
@Slf4j
public class SearchController {
    public static final int PAGE_ITEMS_COUNT = 10;

    @Autowired
    private PersonListController personListController;

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Label searchLabel;

    //private ObservableList<NewPersonViewModel> masterData = FXCollections.observableArrayList();
    //private ObservableList<NewPersonViewModel> results = FXCollections.observableList(masterData);

    @PostConstruct
    void init() {
        //personService.getPersonList().forEach(p -> masterData.add(new NewPersonViewModel(p)));
    }

    @FXML
    private void initialize() {
        // search panel
        searchButton.setText("Search");

        searchButton.setOnAction(event -> loadData());
        searchButton.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        searchField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loadData();
            }
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchLabel.setText(newValue);
        });
    }

    private void loadData() {
        String searchText = searchField.getText();

        personListController.filterList(searchText);
    }

}

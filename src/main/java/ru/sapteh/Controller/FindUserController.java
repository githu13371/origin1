package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Service.GroupDaoImpl;
import ru.sapteh.Service.StudentDaoImpl;
import ru.sapteh.model.Student;
import ru.sapteh.model.Group;

public class FindUserController {

    private final StudentDaoImpl StudentDaoImpl;

    private final GroupDaoImpl groupDao;

    private final ObservableList<Student> Student = FXCollections.observableArrayList();
    private final ObservableList<Group> Group = FXCollections.observableArrayList();

    @FXML
    public TableView<Student> loginTextField;
    @FXML
    public TableColumn<Student, Integer> IdColumn;
    @FXML
    public TableColumn<Group, String> numberGroup;
    @FXML
    public TableView<Group> loginTextField1;

    public FindUserController() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.StudentDaoImpl = new StudentDaoImpl(factory);
        this.groupDao = new GroupDaoImpl(factory);
    }


    @FXML
    public TableColumn<Group, Integer> idColumn;

    @FXML
    public TableColumn<Student, String> firstNameColumn;

    @FXML
    public TableColumn<Student, String> lastNameColumn;

    @FXML
    public TableColumn<Student, Integer> ageColumn;


//    @FXML
//    public TextField firstNameTextField;
//
//    @FXML
//    public TextField lastNameTextField;
//
//    @FXML
//    public TextField ageTextField;


//    @FXML
//    public TextField searchTextField;

    @FXML
    private void initialize() {
        initDate();

//        searchTextField();

        loginTextField.setEditable(true);
        IdColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getIdColumn()));
        firstNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getFirstNameColumn()));
        lastNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getLastNameColumn()));
        ageColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getAgeColumn()));
        loginTextField.setItems(Student);

        Group.addAll(groupDao.findAll());

        loginTextField1.setEditable(true);
        idColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getIdColumn()));
        numberGroup.setCellValueFactory(u-> new SimpleObjectProperty<>(u.getValue().getNumberGroup()));
        loginTextField1.setItems(Group);
//        listenerTabUserDetails(null);
//        loginTextField.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
//                {
//                    listenerTabUserDetails(newValue);
//                }
//        );


    }

//    private void listenerTabUserDetails(Student Student) {
//        if (Student != null) {
//
//            firstNameTextField.setText(Student.getFirstNameColumn());
//            lastNameTextField.setText(Student.getLastNameColumn());
//            ageTextField.setText(String.valueOf(Student.getAgeColumn()));
//        } else {
//
//            firstNameColumn.setText((""));
//            lastNameColumn.setText("");
//            ageColumn.setText("");
//        }
//    }

    private void initDate() {
        Student.addAll(StudentDaoImpl.findAll());
    }
}

//    public void deleteButton(ActionEvent actionEvent) {
//        final Student Student = StudentTableView.getSelectionModel().getSelectedItem();
//        StudentDaoImpl.delete(Student);
//        StudentTableView.getItems().remove(Student);
//        clearTextField();
//        countLabel.setText(String.valueOf(StudentTableView.getItems().size()));
//    }
//
//    public void updateButton(ActionEvent actionEvent) {
//        int selectedIndex = StudentTableView.getSelectionModel().getSelectedIndex();
//        final Student Student = StudentTableView.getSelectionModel().getSelectedItem();
//        Student.setFirst_name(firstNameTextField.getText());
//        Student.setLast_name(lastNameTextField.getText());
//        Student.setAge(Integer.parseInt(ageTextField.getText()));
//        StudentTableView.getItems().set(selectedIndex, Student);
//        StudentDaoImpl.update(Student);
//        clearTextField();
//    }
//
//    public void saveButton(ActionEvent actionEvent) {
//        Student Student = new Student(firstNameTextField.getText(),
//                lastNameTextField.getText(),
//                Integer.parseInt(ageTextField.getText()));
//        StudentDaoImpl.save(Student);
//        StudentTableView.getItems().add(Student);
//        clearTextField();
//        countLabel.setText(String.valueOf(StudentTableView.getItems().size()));
//    }
//
//    private void clearTextField () {
//        firstNameTextField.clear();
//        lastNameTextField.clear();
//        ageTextField.clear();
//        labelId.setText("");
//    }

//    public void searchTextField() {
//        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//            FilteredList<Student> userFilteredList = new FilteredList<>(Student,
//                    s -> s.getFirst_name().toLowerCase().contains(newValue.toLowerCase().trim()));
//            StudentTableView.setItems(userFilteredList);
//            countLabel.setText(String.valueOf(userFilteredList.size()));
//        });
//    }
//
//    public void updateOnTable() {
//        lastNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getLastNameColumn()));
//        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameColumn.setOnEditCommit(event -> {
//            Student Student = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            Student.setLastNameColumn(event.getNewValue());
//            StudentDaoImpl.update(Student);
//        });
//
//        firstNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getFirstNameColumn()));
//        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        firstNameColumn.setOnEditCommit(event -> {
//            Student Student = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            Student.setFirst_name(event.getNewValue());
//            StudentDaoImpl.update(Student);
//        });
//
//        ageColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getAge()));
//        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<>() {
//            @Override
//            public String toString(Integer age) {
//                return String.valueOf(age);
//            }
//
//            @Override
//            public Integer fromString(String age) {
//                return Integer.parseInt(age);
//            }
//        }));
//        ageColumn.setOnEditCommit(event -> {
//            Student Student = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            Student.setAge(event.getNewValue());
//            StudentDaoImpl.update(Student);
//        });
//

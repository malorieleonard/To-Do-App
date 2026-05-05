package org.todoapp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.todoapp.model.*;


public class EducationalTaskContr extends BaseController implements StatusAware {
    @FXML private TextField nameField;
    @FXML private TextField teacherField;
    @FXML private TextField classNameField;
    @FXML private TextField idField;
    @FXML private TextField rankField;
    @FXML private TextField dueDateField;
    @FXML private TextField descriptionField;
    @FXML private Label messageLabel;

    private HomeController homeController;

    @FXML
    private void addBusinessTask() {
        try {
            String name = nameField.getText().trim();
            String teacher = teacherField.getText().trim();
            String className = classNameField.getText().trim();
            int ID = Integer.parseInt(idField.getText().trim());
            int rank = Integer.parseInt(rankField.getText().trim());
            String dueDate = dueDateField.getText().trim();
            String description = descriptionField.getText().trim();

            if (dueDate.isBlank() || name.isBlank()) {
                showMessage("Please complete all fields.");
                return;
            }

            if (!isValidDate(dueDate)) {
                showMessage("Date must be in format YYYY-MM-DD.");
                return;
            }

            EducationalTask educationalTask = new EducationalTask(ID, name, rank, dueDate, false, description, className, teacher);
            taskManage.addTask(educationalTask);
            showMessage("Task " + name + " added to the list.");
            clearFields();

        } catch (NumberFormatException e) {
            showMessage("Task ID must be a whole number.");
        }
    }

    @FXML private void clearFields() {
        nameField.clear();
        teacherField.clear();
        classNameField.clear();
        idField.clear();
        rankField.clear();
        dueDateField.clear();
        descriptionField.clear();
        clearMessages();
    }

    private boolean isValidDate(String dueDate) {
        try {
            LocalDate.parse(dueDate,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void clearMessages() {
        messageLabel.setText("");
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    @Override
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

}

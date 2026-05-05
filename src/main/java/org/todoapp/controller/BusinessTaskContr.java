package org.todoapp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javafx.scene.control.TextField;
import org.todoapp.model.BusinessTask;


public class BusinessTaskContr extends BaseController implements StatusAware {

    try {

        @FXML private TextField nameField;
        @FXML private TextField companyField;
        @FXML private TextField idField;
        @FXML private TextField rankField;
        @FXML private TextField dueDateField;
        @FXML private TextField descriptionField;

        private HomeController homeController;

        @FXML
        private void addBusinessTask() {

            try {
                String name = nameField.getText().trim();
                String company = companyField.getText().trim();
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

                BusinessTask task = new BusinessTask(name, company, ID, rank, dueDate, description);

                taskManage.addTask(task);

                showMessage("Task " + name + " added to the list.");

                clearFields();

            } catch(NumberFormatException e){
                showMessage("Task ID and Rank must be a whole number.");
            }
        }
    }



    @FXML private void clearFields() {
        nameField.clear();
        companyField.clear();
        idField.clear();
        rankField.clear();
        duedateField.clear();
        descriptionField.clear();
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

    private void showMessage(String message) {
        messageLabel.setText(message);
        if (homeController != null) {
            homeController.setStatus(message);
        }
    }

    @Override
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

}

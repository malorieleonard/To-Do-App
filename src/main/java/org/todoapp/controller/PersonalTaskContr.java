package org.todoapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javafx.collections.FXCollections;

import org.todoapp.model.*;


    public class PersonalTaskContr extends BaseController implements StatusAware {
        @FXML
        private TextField nameField;
        @FXML private TextField categoryField;
        @FXML private TextField idField;
        @FXML private TextField rankField;
        @FXML private TextField dueDateField;
        @FXML private TextField descriptionField;
        @FXML private Label messageLabel;

        private HomeController homeController;

        @FXML
        private void addPersonalTask() {
            try {
                String name = nameField.getText().trim();
                String category = categoryField.getText().trim();
                int ID = Integer.parseInt(idField.getText().trim());
                int rank = Integer.parseInt(rankField.getText().trim());
                String dueDate = dueDateField.getText().trim();
                String description = descriptionField.getText().trim();

                if (dueDate.isBlank() || category.isBlank() || description.isBlank() || name.isBlank()) {
                    showMessage("Please complete all fields.");
                    return;
                }

                if (!isValidDate(dueDate)) {
                    showMessage("Date must be in format YYYY-MM-DD.");
                    return;
                }

                PersonalTask personalTask = new PersonalTask(ID, name, rank, dueDate, false, description, category);

                    taskManage.addTask(personalTask);
                showMessage("Task " + name + " added to the list.");
                clearFields();

            } catch (NumberFormatException e) {
                showMessage("Task ID must be a whole number.");
            }
        }

        @FXML private void clearFields() {
            nameField.clear();
            categoryField.clear();
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



package org.todoapp.model;

public class BusinessTask extends Task implements Completable{
        private String company;

        /**
         * makes businessTank class
         * @param ID
         * @param name
         * @param rank
         * @param dueDate
         * @param isCompleted
         * @param description
         * @param company
         */
        public BusinessTask(int ID, String name, int rank, String dueDate, boolean isCompleted, String description, String company) {
            super(ID, name, rank, dueDate, isCompleted, description);
            this.company = company;
        }

        /**
         * Gets company name
         * @return String company
         */
        public String getCompany() {
            return company;
        }

        /**
         * Sets company name
         * @param company
         */
        public void setCompany(String company) {
            this.company = company;
        }

    @Override
    public void markComplete() {
        setCompleted(true);
    }

    @Override
    public String toString() {
        return ID + "," + company + "," + name + "," + rank + "," + dueDate + "," + isCompleted + "," + description;
    }
}





package mainpkg;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty userName, userType;

    public User(String userName, String userType) {
        this.userName = new SimpleStringProperty(userName);
        this.userType = new SimpleStringProperty(userType);
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }
    public void setUserType(String userType) {
        this.userType = new SimpleStringProperty(userType);
    }

    public String getFirstName() {
        return userName.get();
    }
    public String getLastName() {
        return userType.get();
    }
}

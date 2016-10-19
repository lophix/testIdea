package netty.http.xml;

import java.util.List;

/**
 * POJO
 *
 * @Authuor Administrator
 * @Create 2016-10-19-13:23
 */
public class Customer {
    private long cunstomerNumber;
    private String firstName;
    private String lastName;
    private List<String> middleNames;

    public long getCunstomerNumber() {
        return cunstomerNumber;
    }

    public void setCunstomerNumber(long cunstomerNumber) {
        this.cunstomerNumber = cunstomerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }
}

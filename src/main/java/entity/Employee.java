package entity;

import java.util.UUID;

public class Employee {
    private String id;
    private String fullName;
    private String address;
    private String email;
    private String account;
    private String password;
    private long created_at;
    private long updated_at;
    private int status;

    public Employee(){

    }

    public Employee(String fullName, String address, String email, String account, String password) {
        long now = System.currentTimeMillis();

        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.created_at = now;
        this.updated_at = now;
        this.status = 1;
    }

    public Employee(String id, String fullName, String address, String email, String account, String password, long created_at, long updated_at, int status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
    }

    public enum EmployeeStatus{
        ACTIVE(1), DEACTIVE(0);
        private int code;

        EmployeeStatus(int code){
            this.code = code;
        }


    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

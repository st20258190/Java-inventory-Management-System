package Classes;

public class Account {
    private String name;
    private String age;
    private String email;
    private String tel;
    private String id;
    private boolean isManager = false;
    private boolean isCashier = false;

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isCashier() {
        return isCashier;
    }

    public void setCashier(boolean cashier) {
        isCashier = cashier;
    }
}

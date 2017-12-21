/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author User
 */
public class custinfo {

    private String Id;
    private String pass;
    private String name;
    private String phone;
    private String gender;
    private String address;

    public custinfo() {
    }

    public custinfo(String id, String passw, String name, String ph, String gen, String add) {

        this.Id = id;
        this.pass = passw;
        this.name = name;
        this.phone = ph;
        this.gender = gen;
        this.address = add;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getpass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}

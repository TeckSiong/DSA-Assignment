/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author khosit
 */
public class TotalAssign {

    private int id;
    private String name;

    public TotalAssign() {
    }

    public TotalAssign(int a, String b) {
        this.id = a;
        this.name = b;
    }

    public int getOrderId() {
        return id;
    }

    public void setDelmenId(int delmenId) {
        this.id = delmenId;
    }

    public String getDelName() {
        return name;
    }

    public void setDelName(String delmenId) {
        this.name = delmenId;
    }

}

package ru.vsu.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "abonent")
@DiscriminatorValue("abonent")
public class abonent implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public abonent() {
    }

    public abonent( String surname, String name, String telefon1, String telefon2, String telefon3) {

        this.surname = surname;
        this.name = name;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.telefon3 = telefon3;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gid() {
        return id;
    }

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "telefon1")
    private String telefon1;

    @Column(name = "telefon2")
    private String telefon2;

    @Column(name = "telefon3")
    private String telefon3;

    public void setsurname(String surname){
        this.surname=surname;
    }
    public void setname(String name){
        this.name=name;
    }
    public void settelefon1(String telefon1){
        this.telefon1=telefon1;
    }
    public void settelefon2(String telefon2){
        this.telefon2=telefon2;
    }
    public void settelefon3(String telefon3){
        this.telefon3=telefon3;
    }
    public String gsurname(){
        return surname;
    }
    public String gname(){
        return name;
    }
    public String gtelefon1(){
        return telefon1;
    }
    public String gtelefon2(){
        return telefon2;
    }
    public String gtelefon3(){
        return telefon3;
    }
    public String toString() {
        return " Фамилия: "+surname+" Имя: "+name+" Телефон 1: "+telefon1+" Телефон 2: "+telefon2+" Телефон 3: "+telefon3;
    }
//    public int compareTo(abonent o) {
//        abonent element = o;
//        int surnamesr = surname.compareToIgnoreCase(element.gsurname());
//        if (surnamesr == 0) {
//            int namesr = name.compareToIgnoreCase(element.gname());
//            if (namesr == 0) {
//                int telefonsr = telefon1.compareTo(telefon1);
//                if (telefonsr == 0) {
//                    return telefonsr;
//                }
//                return 0;
//            } else {
//                return namesr;
//            }
//        } else {
//            return surnamesr;
//        }
//    }

}

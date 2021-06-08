package ru.vsu;

import ru.vsu.model.abonent;

import java.util.List;

interface spravochnic {
    void add(abonent chelovec);
    void delete(int id);
    void edit(int id, abonent chelovec);
    abonent chel(int id);
    List<abonent> poisk(String isk);
    List<abonent> abonen();
}

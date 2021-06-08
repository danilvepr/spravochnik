package ru.vsu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vsu.model.abonent;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class Manager {
    private spravochnic spravochnic;
    @Autowired
    public Manager(@Qualifier("hspravochnic") ru.vsu.spravochnic spravochnic) {
        this.spravochnic = spravochnic;
    }
    @Transactional
    public List<abonent> abonen() {
        return spravochnic.abonen();
    }
    @Transactional
    public void add(abonent chelovec){
        spravochnic.add(chelovec);
    }
    @Transactional
    public void edit(int id, abonent chelovec) {
        spravochnic.edit(id, chelovec);
    }
    @Transactional
    public void delete(int id) {
        spravochnic.delete(id);
    }
    @Transactional
    public abonent chel(int id) {
        return spravochnic.chel(id);
    }
    @Transactional
    public List<abonent> poisk(String isk) {
        return spravochnic.poisk(isk);
    }
}

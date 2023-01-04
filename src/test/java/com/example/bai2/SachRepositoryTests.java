package com.example.bai2;

import com.example.bai2.repository.SachRepository;
import com.example.bai2.sach.Sach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class SachRepositoryTests {
    @Autowired private SachRepository repo;

    @Test
    public void TestAddNew(){
        Sach sach = new Sach();
        sach.setTen("Cong nghe thong tin");
        sach.setChuyenmuc("Khoa hoc");
        sach.setTacgia("Hieu Cuong");
        repo.save(sach);
    }
    @Test
    public void TestListAll(){
        Iterable<Sach> sachs = repo.findAll();
        for (Sach sach : sachs){
            System.out.println(sach);
        }
    }
//    @Test
//    public void TestUpdate(){
//        Integer Id = 1 ;
//        Optional<Sach> optionalSach = repo.findById(Id);
//        Sach sach = optionalSach.get();
//        sach.setTacgia("ABC");
//        repo.save(sach);
//    }
//    @Test
//    public void TestGet(){
//        Integer Id = 2 ;
//        Optional<Sach> optionalSach = repo.findById(Id);
//        System.out.println(optionalSach.get());
//    }
//    @Test
//    public void TestDelete(){
//        Integer Id = 2 ;
//        repo.deleteById(Id);
//}

}

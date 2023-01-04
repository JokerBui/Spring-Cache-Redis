package com.example.bai2.repository;

import com.example.bai2.sach.Sach;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SachRepository extends JpaRepository<Sach,Integer> {
//Hibernate
    @Query(value = " SELECT u FROM Sach u where u.ten LIKE '%' || :keyword || '%' "
        +" OR u.chuyenmuc LIKE '%' || :keyword || '%'"
        +" OR u.tacgia LIKE '%' || :keyword || '%'")
    public List<Sach> search(@Param("keyword") String keyword);
//Native Query
    @Query(value = " SELECT * FROM sachdb.sachs u where u.tacgia = :keyword"
            +" OR u.chuyenmuc = :keyword"
            +" OR u.tacgia = :keyword", nativeQuery = true)
    public List<Sach> searchNative(@Param("keyword") String keyword);
}

package com.metacoding.storev1.store;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Main Page
    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    // Detail Page
    public Store 상세보기(int id) {
        Store store = storeRepository.findById(id);
        return store;
    }

    // Save
    @Transactional // insert, delete, update시에 사용 : 함수 종료시 commit 됨
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    // Delete
    @Transactional
    public void 상품삭제(int id) {
        // 1. 상품 조회
        Store store = storeRepository.findById(id);

        // 2. 상품 삭제
        if (store == null) {
            throw new RuntimeException("삭제할 상품이 없어요.");
        }
        storeRepository.deleteById(id);

    }

}

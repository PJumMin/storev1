package com.metacoding.storev1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 (JPA가 ObjectMapping을 위해 new할 때 사용함.)
@Table(name = "store_tb") // 테이블명
@Entity // 설정파일에서 테이블 생성
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 번호 (auto_increment)
    private Integer id;
    private String name;
    private Integer price;
    private Integer stock; // 재고
}

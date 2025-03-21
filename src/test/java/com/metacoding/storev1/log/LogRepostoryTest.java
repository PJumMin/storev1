package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Import(LogRepository.class)
@DataJpaTest // em IoC 등록
public class LogRepostoryTest {

    // DI
    @Autowired // DI해줌 | 이하는 어노테이션 새로운 방법
    private LogRepository logRepository;

    @Test // 세모버튼 생김
    public void findAllJoinStore_test() { // 테스트 클래스_test : 컨벤션 | 매개변수에 아무것도 적을 수 없다.
        List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();
        for (ListPage listPage : logList) {
            System.out.println(listPage);
        }
    }

}

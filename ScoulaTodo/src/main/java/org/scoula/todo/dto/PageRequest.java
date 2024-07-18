package org.scoula.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class PageRequest
{
    private int page; // 요청 페이지
    private int size; //한 페이지당 데이터 건수
    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }
    public int getOffset() { // offset값 계산 - vue의 computed속성과 비슷. offset은 get만 있으면 된다.
        return (page - 1) * size; //시작 위치가 나오게 된다.
    }
}
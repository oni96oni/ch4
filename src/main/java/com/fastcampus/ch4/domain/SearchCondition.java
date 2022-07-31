package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1;
    // 기본값을 주면 나중에 컨트롤러에서 값을 받을때 값이 안들어오면 기본값을 사용한다.
    private Integer pageSize = 10;
    // private Integer offset = 0; 있으면 계속 관리해줘야하기 때문에 없애버린다. page, pageSize로만 계산하게끔 해주자
    private String keyword = "";
    // 검색어 저장
    private String option = "";
    // 제목+내용, 제목, 내용 검색할것들을 선택하는 옵션

    public SearchCondition() {}
    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public String getQueryString(Integer page) {
        // ?page=1&pageSize=10&option=T&keyword="title" 이렇게 일일이 만들어 주기가 귀찮아서 자동적으로 쿼리스트링을 만들어줘서 반환하려고한다!
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize",pageSize)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .build().toString();
    }
    public String getQueryString() {
        return getQueryString(page); //코드중복을 처리하기위해 메소드불러왔다.
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page-1)*pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}

package com.food.exp.dto;

import org.apache.ibatis.type.Alias;

@Alias("RstDTO")
public class RstDTO {
    String rst_id;
    String rst_name;
    String rst_addr1;
    String rst_addr2;
    String rst_phone;
    String rst_cate;

    // 기본 생성자
    public RstDTO() {
    }

    // 매개변수가 있는 생성자
    public RstDTO(String rst_id, String rst_name, String rst_addr1, String rst_addr2, String rst_phone, String rst_cate) {
        this.rst_id = rst_id;
        this.rst_name = rst_name;
        this.rst_addr1 = rst_addr1;
        this.rst_addr2 = rst_addr2;
        this.rst_phone = rst_phone;
        this.rst_cate = rst_cate;
    }

    // Getter와 Setter 메서드
    public String getRst_id() {
        return rst_id;
    }

    public void setRst_id(String rst_id) {
        this.rst_id = rst_id;
    }

    public String getRst_name() {
        return rst_name;
    }

    public void setRst_name(String rst_name) {
        this.rst_name = rst_name;
    }

    public String getRst_addr1() {
        return rst_addr1;
    }

    public void setRst_addr1(String rst_addr1) {
        this.rst_addr1 = rst_addr1;
    }

    public String getRst_addr2() {
        return rst_addr2;
    }

    public void setRst_addr2(String rst_addr2) {
        this.rst_addr2 = rst_addr2;
    }

    public String getRst_phone() {
        return rst_phone;
    }

    public void setRst_phone(String rst_phone) {
        this.rst_phone = rst_phone;
    }

    public String getRst_cate() {
        return rst_cate;
    }

    public void setRst_cate(String rst_cate) {
        this.rst_cate = rst_cate;
    }
}

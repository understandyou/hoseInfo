package com.lianjia.hose.entitys;

import javax.persistence.*;

/**
 * 房屋信息实体
 */
@Entity
//@Table
public class House {
  @Override
  public String toString() {
    return "House{" +
            "id=" + id +
            ", community='" + community + '\'' +
            ", ridgepole=" + ridgepole +
            ", unit='" + unit + '\'' +
            ", floor=" + floor +
            ", houserNumber='" + houserNumber + '\'' +
            '}';
  }

  //自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
  private Integer id;
  /**
   * 小区名
   */
  private String community;
  /**
   * 栋数
   */
  private Long ridgepole;
  /**
   * 单元
   */
  private char unit;
  /**
   * 楼层
   */
  private Long floor;
  /**
   * 房号
   */
  @Column(name = "houser_number")
  private String houserNumber;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCommunity() {
    return community;
  }

  public void setCommunity(String community) {
    this.community = community;
  }


  public Long getRidgepole() {
    return ridgepole;
  }

  public void setRidgepole(Long ridgepole) {
    this.ridgepole = ridgepole;
  }


  public char getUnit() {
    return unit;
  }

  public void setUnit(char unit) {
    this.unit = unit;
  }


  public Long getFloor() {
    return floor;
  }

  public void setFloor(Long floor) {
    this.floor = floor;
  }


  public String getHouserNumber() {
    return houserNumber;
  }

  public void setHouserNumber(String houserNumber) {
    this.houserNumber = houserNumber;
  }

}

package test;

import java.time.LocalDate;

public class Member {
private Integer id;
private String name;
private LocalDate birthday;
private String gender;
private Integer colorId;

@Override
public String toString() {
    return "member [id=" + id + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", colorId="
            + colorId + "]";
}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public LocalDate getBirthday() {
    return birthday;
}
public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
}
public String getGender() {
    return gender;
}
public void setGender(String gender) {
    this.gender = gender;
}
public Integer getColorId() {
    return colorId;
}
public void setColorId(Integer colorId) {
    this.colorId = colorId;
}


   
}

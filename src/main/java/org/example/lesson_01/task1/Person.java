package org.example.lesson_01.task1;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        gender = builder.gender;
    }

    @Override
    public String toString() {
        String result = "Hi! My name is " + firstName;
        result = result + ((middleName.length()>0)?(" " + middleName):"");
        result = result + " " + lastName + ". I am " + age + " years old " + gender + ". ";
        result = result + "You can reach me by phone number " + phone + ". ";
        result = result + "I am living in " + country + ", my address is " + address + ". Nice to meet you!";
        return result;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withMiddleName(String val) {
            middleName = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withAddress(String val) {
            address = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withAge(int val) {
            age = val;
            return this;
        }

        public Builder withGender(String val) {
            gender = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }


    }
}

package com.example.todo_app.Models;

import javax.persistence.*;


    @Entity
    public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        public long getUserId() {
            return id;
        }
        public void setUserId(long id) {
            this.id = id;
        }
        @Column
        private String userName;
        @Column
        private String email;
        @Column
        private String password;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

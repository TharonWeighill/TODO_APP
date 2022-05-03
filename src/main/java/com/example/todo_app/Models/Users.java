package com.example.todo_app.Models;

import javax.persistence.*;


    @Entity
    public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long userId;
        public long getUserId() {
            return userId;
        }
        public void setUserId(long userId) {
            this.userId = userId;
        }
        @Column
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

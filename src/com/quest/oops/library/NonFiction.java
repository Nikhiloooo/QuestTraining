package com.quest.oops.library;

public class NonFiction extends Book {

        private String subject;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }


        @Override
        public boolean isAvailable() {
            return super.isAvailable();
        }
    }



package com.quest.oops.library;

public class Fiction extends Book {

        private String genre;


        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }


        @Override
        public boolean isAvailable() {
            return super.isAvailable();
        }
    }



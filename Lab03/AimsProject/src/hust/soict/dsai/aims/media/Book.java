// src/hust/soict/dsai/aims/media/Book.java
package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final List<String> authors = new ArrayList<>();
    private int contentLength = 0;

    public Book(String title) {
        super(title);
    }

    public void addAuthor(String authorName) {
        if (authorName != null && !authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public void setContentLength(int length) {
        this.contentLength = length;
    }

    public int getContentLength() {
        return contentLength;
    }

    @Override
    public String toString() {
        return "Book - " + title +
               " - Authors: " + authors +
               " - Tokens: " + contentLength +
               " - " + cost + " $";
    }
}
package ru.croc.task13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> badComments = new ArrayList<>();
        for (String comment : comments) {
            String tempComments = comment.toLowerCase();
            for (String badWord : blackList) {
                if (tempComments.contains(badWord)) {
                    badComments.add(comment);
                    break;
                }
            }
        }
        comments.removeAll(badComments);
    }
}
package ru.spsuace.homework2.objects.analyzer;

public class Spam implements TextAnalyzer {
    private final String[] spam;
    public Spam(String[] spam) {
        this.spam = spam;
    }
    @Override
    public FilterType analyzer(String text) {
        for (String word : spam) {
            if (text.contains(word)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}

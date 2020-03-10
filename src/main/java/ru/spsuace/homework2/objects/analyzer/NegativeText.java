package ru.spsuace.homework2.objects.analyzer;

public class NegativeText implements TextAnalyzer {
    public final String[] negative = {"=(", ":(", ":|"};


    @Override
    public FilterType analyzer(String text) {
        for (String n : negative) {
            if (text.contains(n)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}

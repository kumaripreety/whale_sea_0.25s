package com.example.textAnalysisV2.util;

import java.util.Set;

public class ExclusionWords {
    public static final Set<String> EXCLUSIONS = Set.of(
        // Prepositions
        "aboard", "about", "above", "across", "after", "against", "along", "amid", "among", "around",
        "as", "at", "before", "behind", "below", "beneath", "beside", "besides", "between", "beyond",
        "but", "by", "concerning", "despite", "down", "during", "except", "for", "from", "in", "inside",
        "into", "like", "near", "of", "off", "on", "onto", "opposite", "out", "outside", "over", "past",
        "regarding", "since", "through", "throughout", "till", "to", "toward", "under", "underneath",
        "unlike", "until", "up", "upon", "versus", "via", "with", "within", "without",

        // Pronouns
        "i", "me", "you", "he", "him", "she", "her", "it", "we", "us", "they", "them", "there",
        "my", "mine", "your", "yours", "his", "hers", "its", "our", "ours", "their", "theirs",
        "myself", "yourself", "himself", "herself", "itself", "ourselves", "yourselves", "themselves",
        "this", "that", "these", "those", "anyone", "everyone", "someone", "no one", "nothing", "everything",
        "thou", "thee", "thy", "thine", "ye",

        // Conjunctions
        "and", "or", "nor", "so", "yet", "although", "because", "unless", "while", "whereas", "if", "though", "than",

        // Articles
        "a", "an", "the",

        // Modal Verbs and Forms
        "can", "could", "may", "might", "shall", "should", "will", "would", "must", "ought",
        "is", "was", "are", "were", "be", "been", "being", "am", "do", "does", "did", "not", "has", "have", "had",
        "now", "then", "which", "what", "when", "where", "why", "how", "who", "whom", "whose",
        "each", "every", "some", "any", "no", "both", "either", "neither", "all", "let",
        "other", "others", "another", "such", "same", "very", "much", "many", "few", "several", "most",
        "more", "less", "least", "only", "just", "even", "still", "also", "too", "well", "here", "anywhere",
        "everywhere", "somewhere", "nowhere",

        // Common Verbs / Tense
        "said", "say", "says", "saying", "see", "seen", "go", "come", "ll", "ve", "re",

        // Descriptive / Adjectives
        "old", "new", "last", "long", "short", "big", "small", "high", "low", "good", "bad", "great", "little", "own",

        // Frequency Adverbs
        "again", "always", "never", "ever", "often", "sometimes", "usually", "rarely", "seldom",

        // Intensifiers
        "quite", "rather", "almost",

        // Others
        "way", "away", "oh", "aye",

        // Alphabets
        "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v", "w", "x", "y", "z",

        // Numbers (written form)
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
        "hundred", "thousand", "million", "billion"
    );
}

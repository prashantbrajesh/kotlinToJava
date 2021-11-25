package model;

import java.util.*;
import java.util.stream.Collectors;

public class BookingTest2 {
    public static void main(String[] args) {

//        return result;
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords,
                                                String negativeKeywords,
                                                List<Integer> hotelIds,
                                                List<String> reviews,
                                                int k) {

        List<String> positiveReviewsKeys = Arrays.asList(positiveKeywords.split(" "));

        List<String> negativeReviewsKeys = Arrays.asList(negativeKeywords.split(" "));


        Map<Integer, Integer> accumulatedReview = new HashMap<>();

        for (int i = 0; i < reviews.size(); i++) {

            int hotelId = hotelIds.get(i);

            List<String> reviewWords = Arrays.asList(reviews.get(i).split(" "));

            int currentPositive = (int) reviewWords.stream()
                    .filter(token -> positiveReviewsKeys.contains(token))
                    .count();

            int currentNegative = (int) reviewWords.stream()
                    .filter(token -> negativeReviewsKeys.contains(token))
                    .count();

            int total = currentPositive * 3 + currentNegative * -1;

            int previous = accumulatedReview.getOrDefault(hotelId, 0);

            accumulatedReview.put(hotelId, previous + total);
        }

        List<Integer> awardTopKHotels = accumulatedReview.entrySet()
                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return awardTopKHotels;
    }

}

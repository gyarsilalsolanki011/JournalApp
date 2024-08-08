package com.gyarsilalsolanki011.JournalApp.schedulers;

import com.gyarsilalsolanki011.JournalApp.cache.AppCache;
import com.gyarsilalsolanki011.JournalApp.entity.JournalEntry;
import com.gyarsilalsolanki011.JournalApp.entity.User;
import com.gyarsilalsolanki011.JournalApp.enums.Sentiment;
import com.gyarsilalsolanki011.JournalApp.repository.UserRepositoryImpl;
import com.gyarsilalsolanki011.JournalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AppCache appCache;

    //@Scheduled(cron = "0 0 9 * * SUN")

    public void fetchUsersAndSendMail() {
        List<User> users = userRepository.getUsersForSA();
        for (User user : users) {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x-> x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
            if (mostFrequentSentiment != null)
                emailService.sendEmail(user.getEmail(), "Sentiments for last 7 days", mostFrequentSentiment.toString());
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache() {
        appCache.init();
    }
}

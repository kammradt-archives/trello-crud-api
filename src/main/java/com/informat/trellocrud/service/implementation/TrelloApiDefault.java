package com.informat.trellocrud.service.implementation;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import com.informat.trellocrud.service.interfaces.TrelloApiService;
import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.TList;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrelloApiDefault implements TrelloApiService {

    @Override
    public Trello getConnection() {
        String key = "3c00545dcec6d48e3cdbff9115501a54";
        String token = "6393393fe7f08d3b5c5d221e5fd19745c96f13309017f1425c64da03946e96a3";
        return new TrelloImpl(key, token, new ApacheHttpClient());
    }

    @Override
    public Task sendTaskToTrello(Task task) {
        Trello trello = getConnection();
        Board board = trello.getBoard("vh53Iyjt");
        List<TList> lists = board.fetchLists();

        Task createdTask = new Task();
        lists.forEach(list -> {
            if (list.getName().equals(task.getListName().toString())) {
                Card card = new Card();
                card.setName(task.getTaskName());
                Card createdCard = list.createCard(card);
                createdTask.setTrelloId(createdCard.getId());
                createdTask.setListName(task.getListName());
                createdTask.setTaskName(createdCard.getName());
                createdTask.setCreatedAt((new Date()));
            }
        });
        return createdTask;
    }

    @Override
    public List<Card> getAllTasksFromExternalApi() {
        Trello trello = getConnection();
        Board board = trello.getBoard("vh53Iyjt");
        List<TList> lists = board.fetchLists();

        List<Card> cards = new ArrayList<>();
        lists.forEach(list -> {
            cards.addAll(trello.getListCards(list.getId()));
        });
        return cards;
    }
}

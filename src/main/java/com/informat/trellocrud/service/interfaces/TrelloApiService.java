package com.informat.trellocrud.service.interfaces;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Card;

import java.util.List;

public interface TrelloApiService {
    Trello getConnection();
    Task sendTaskToTrello(Task task);
    List<Card> getAllTasksFromExternalApi();
}

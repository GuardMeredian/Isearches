package com.bcode.Isearches.repos;

import com.bcode.Isearches.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

 List<Message>findByTagMessage(String tagMessage);
}

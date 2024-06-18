package by.shylau.salerno.mapper;

import by.shylau.salerno.dto.request.CardRequest;
import by.shylau.salerno.dto.responce.CardResponse;
import by.shylau.salerno.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CardMapper {

    Card createCard(CardRequest cardRequest);

    CardResponse toResponse(Card card);
    List<CardResponse> toResponseList(List<Card> cardList);
}

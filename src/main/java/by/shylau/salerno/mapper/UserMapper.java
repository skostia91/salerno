package by.shylau.salerno.mapper;

import by.shylau.salerno.dto.request.UserRequest;
import by.shylau.salerno.dto.responce.UserResponse;
import by.shylau.salerno.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User createUser(UserRequest userRequest);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> userList);
}

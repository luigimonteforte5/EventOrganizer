package org.example.eventorganizer.mapper.impl;

import org.example.eventorganizer.mapper.GenericMapper;
import org.example.eventorganizer.user.model.User;
import org.example.eventorganizer.user.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, implementationName = "CustomUserMapperImpl")
public interface UserMapper extends GenericMapper<User, UserDTO> {
}

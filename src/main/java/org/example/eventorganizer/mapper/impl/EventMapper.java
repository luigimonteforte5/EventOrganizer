package org.example.eventorganizer.mapper.impl;

import org.example.eventorganizer.event.model.Event;
import org.example.eventorganizer.event.model.EventDTO;
import org.example.eventorganizer.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, implementationName = "CustomEventMapperImpl")
public interface EventMapper extends GenericMapper<Event, EventDTO> {
}

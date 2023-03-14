package com.prefix.app.modules.study.event;

import com.prefix.app.modules.study.domain.entity.Study;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StudyUpdateEvent {
    private final Study study;
    private final String message;
}

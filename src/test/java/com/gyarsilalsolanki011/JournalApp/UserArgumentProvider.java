package com.gyarsilalsolanki011.JournalApp;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("Mohan").password("Mohan").build()),
                Arguments.of(User.builder().userName("Ramesh").password("").build())
        );
    }
}

//Note: we have created entity User as builder for testing purpose

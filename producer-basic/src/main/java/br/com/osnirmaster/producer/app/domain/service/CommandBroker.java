package br.com.osnirmaster.producer.app.domain.service;

import br.com.osnirmaster.producer.app.domain.Quote;

import java.util.concurrent.ExecutionException;


public interface CommandBroker {

    void sendCommand(Quote quote) throws ExecutionException, InterruptedException;
}

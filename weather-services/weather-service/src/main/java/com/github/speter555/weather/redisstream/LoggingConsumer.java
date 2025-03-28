/*-
 * #%L
 * Weather-backend
 * %%
 * Copyright (C) 2025 i-Cell Mobilsoft Zrt.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.speter555.weather.redisstream;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import com.github.speter555.weather.common.reactive.message.WeatherReactiveMessageConstants;
import hu.icellmobilsoft.coffee.se.logging.Logger;
import hu.icellmobilsoft.reactive.messaging.redis.streams.metadata.IncomingRedisStreamMetadata;
import io.smallrye.mutiny.Uni;

/**
 * Consume message from {@link WeatherReactiveMessageConstants.Channel#LOGGING_CONSUMER_CHANNEL}}
 */
@ApplicationScoped
public class LoggingConsumer {

    @Inject
    Logger logger;

    /**
     * Process message from {@link WeatherReactiveMessageConstants.Channel#LOGGING_CONSUMER_CHANNEL}}
     * 
     * @param message
     *            reactive message
     * @return reactive void
     */
    @Incoming(WeatherReactiveMessageConstants.Channel.LOGGING_CONSUMER_CHANNEL)
    public Uni<Void> processMessage(Message<String> message) {
        logMetadata(message);
        return Uni.createFrom().voidItem();
    }

    private void logMetadata(Message<String> message) {
        Optional<IncomingRedisStreamMetadata> metadata = message.getMetadata().get(IncomingRedisStreamMetadata.class);
        logger.info("Message metadata stream: [{0}]", metadata.map(IncomingRedisStreamMetadata::getStream));
        logger.info("Message metadata id: [{0}]", metadata.map(IncomingRedisStreamMetadata::getId));
        logger.info("Message metadata additional: [{0}]", metadata.map(IncomingRedisStreamMetadata::getAdditionalFields));
        logger.info("Message payload: [{0}]", message.getPayload());
    }

}

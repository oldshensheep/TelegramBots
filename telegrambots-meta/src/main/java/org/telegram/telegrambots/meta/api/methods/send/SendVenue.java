package org.telegram.telegrambots.meta.api.methods.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Use this method to send information about a venue. On success, the sent Message is
 * returned.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Jacksonized
public class SendVenue extends BotApiMethodMessage {
    public static final String PATH = "sendVenue";

    private static final String CHAT_ID_FIELD = "chat_id";
    private static final String MESSAGE_THREAD_ID_FIELD = "message_thread_id";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String TITLE_FIELD = "title";
    private static final String DISABLE_NOTIFICATION_FIELD = "disable_notification";
    private static final String ADDRESS_FIELD = "address";
    private static final String FOURSQUARE_ID_FIELD = "foursquare_id";
    private static final String REPLY_TO_MESSAGE_ID_FIELD = "reply_to_message_id";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String FOURSQUARE_TYPE_FIELD = "foursquare_type";
    private static final String ALLOW_SENDING_WITHOUT_REPLY_FIELD = "allow_sending_without_reply";
    private static final String GOOGLE_PLACE_ID_FIELD = "google_place_id";
    private static final String GOOGLE_PLACE_TYPE_FIELD = "google_place_type";
    private static final String PROTECT_CONTENT_FIELD = "protect_content";
    private static final String REPLY_PARAMETERS_FIELD = "reply_parameters";
    private static final String BUSINESS_CONNECTION_ID_FIELD = "business_connection_id";
    private static final String MESSAGE_EFFECT_ID_FIELD = "message_effect_id";
    private static final String ALLOW_PAID_BROADCAST_FIELD = "allow_paid_broadcast";

    @JsonProperty(CHAT_ID_FIELD)
    @NonNull
    private String chatId; ///< Unique identifier for the chat to send the message to (Or username for channels)
    /**
     * Unique identifier for the target message thread (topic) of the forum;
     * for forum supergroups only
     */
    @JsonProperty(MESSAGE_THREAD_ID_FIELD)
    private Integer messageThreadId;
    @JsonProperty(LATITUDE_FIELD)
    @NonNull
    private Double latitude; ///< Latitude of venue location
    @JsonProperty(LONGITUDE_FIELD)
    @NonNull
    private Double longitude; ///< Longitude of venue location
    @JsonProperty(TITLE_FIELD)
    @NonNull
    private String title; ///< Title of the venue
    @JsonProperty(ADDRESS_FIELD)
    @NonNull
    private String address; ///< Address of the venue
    @JsonProperty(DISABLE_NOTIFICATION_FIELD)
    private Boolean disableNotification; ///< Optional. Sends the message silently. Users will receive a notification with no sound.
    @JsonProperty(FOURSQUARE_ID_FIELD)
    private String foursquareId; ///< Optional. Foursquare identifier of the venue
    @JsonProperty(REPLY_TO_MESSAGE_ID_FIELD)
    private Integer replyToMessageId; ///< Optional. If the message is a reply, ID of the original message
    /**
     * Optional.
     * Additional interface options.
     * A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove a reply keyboard
     * or to force a reply from the user.
     */
    @JsonProperty(REPLY_MARKUP_FIELD)
    private ReplyKeyboard replyMarkup;
    @JsonProperty(FOURSQUARE_TYPE_FIELD)
    private String foursquareType; ///< Optional. Foursquare type of the venue, if known.
    @JsonProperty(ALLOW_SENDING_WITHOUT_REPLY_FIELD)
    private Boolean allowSendingWithoutReply; ///< Optional	Pass True, if the message should be sent even if the specified replied-to message is not found
    @JsonProperty(GOOGLE_PLACE_ID_FIELD)
    private String googlePlaceId; ///< Optional. Google Places identifier of the venue
    @JsonProperty(GOOGLE_PLACE_TYPE_FIELD)
    private String googlePlaceType; ///< Optional. Google Places type of the venue. (See supported types.)
    @JsonProperty(PROTECT_CONTENT_FIELD)
    private Boolean protectContent; ///< Optional. Protects the contents of sent messages from forwarding and saving
    /**
     * Optional
     * Description of the message to reply to
     */
    @JsonProperty(REPLY_PARAMETERS_FIELD)
    private ReplyParameters replyParameters;
    /**
     * Optional.
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    @JsonProperty(BUSINESS_CONNECTION_ID_FIELD)
    private String businessConnectionId;
    /**
     * Optional
     * Unique identifier of the message effect to be added to the message
     */
    @JsonProperty(MESSAGE_EFFECT_ID_FIELD)
    private String messageEffectId;
    /**
     * Optional
     * Pass True to allow up to 1000 messages per second, ignoring broadcasting limits for a fee of 0.1 Telegram Stars per message.
     * The relevant Stars will be withdrawn from the bot's balance
     */
    @JsonProperty(ALLOW_PAID_BROADCAST_FIELD)
    private Boolean allowPaidBroadcast;

    @Tolerate
    public void setChatId(@NonNull Long chatId) {
        this.chatId = chatId.toString();
    }

    public void enableNotification() {
        this.disableNotification = false;
    }

    public void disableNotification() {
        this.disableNotification = true;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (chatId.isEmpty()) {
            throw new TelegramApiValidationException("ChatId parameter can't be empty", this);
        }
        if (title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
        if (replyParameters != null) {
            replyParameters.validate();
        }
    }

    public static abstract class SendVenueBuilder<C extends SendVenue, B extends SendVenueBuilder<C, B>> extends BotApiMethodMessageBuilder<C, B> {
        @Tolerate
        public SendVenueBuilder<C, B> chatId(@NonNull Long chatId) {
            this.chatId = chatId.toString();
            return this;
        }
    }
}

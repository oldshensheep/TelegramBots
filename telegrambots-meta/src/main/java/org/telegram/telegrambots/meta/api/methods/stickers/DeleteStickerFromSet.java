package org.telegram.telegrambots.meta.api.methods.stickers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodBoolean;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
public class DeleteStickerFromSet extends BotApiMethodBoolean {
    private static final String PATH = "deleteStickerFromSet";

    private static final String STICKER_FIELD = "sticker";

    @JsonProperty(STICKER_FIELD)
    @NonNull
    private String sticker; ///< File identifier of the sticker

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (sticker.isEmpty()) {
            throw new TelegramApiValidationException("sticker can't be null", this);
        }
    }
}

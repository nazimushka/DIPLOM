package reserve.bot.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import reserve.bot.bot.BotService;
import reserve.bot.bot.UpdateUtil;
import reserve.bot.command.Command;
import reserve.bot.command.CommandName;
import reserve.bot.command.KeyboardMaker;
import reserve.bot.models.User;
import reserve.bot.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Start implements Command {

    private static final String GREETING_TEXT = "Привет, выбери одну из кнопок ниже";

    private final BotService botService;
    private final UserService userService;

    @Override
    public boolean execute(Update update,  boolean isBeginning) {
        Long userId = UpdateUtil.getUserId(update);
        Optional<User> userOpt = userService.findById(userId);
        User user = userOpt.orElseGet(() -> userService.create(update));
        botService.sendMarkup(userId, GREETING_TEXT, KeyboardMaker.getKeyboard(user));
        return true;
    }

    @Override
    public CommandName getName() {
        return CommandName.START;
    }
}
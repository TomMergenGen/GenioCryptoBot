package kz.genio.geniocryptobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class GeniocryptobotApplication {

	public static void main(String[] args) {

		SpringApplication.run(GeniocryptobotApplication.class, args);

		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new GenioBot());
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
	}

}

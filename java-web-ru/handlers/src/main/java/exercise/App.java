package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        /*
        Реализуйте Javalin-приложение и добавьте в него:

        Обработчик GET /phones. Он должен возвращать список телефонов, закодированный в json
        Обработчик GET /domains. Он должен возвращать список доменов, закодированный в json
         */
        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.bodyAsClass(Data.getPhones()));
        app.get("/domains", ctx -> ctx.bodyAsClass(Data.getDomains()));

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

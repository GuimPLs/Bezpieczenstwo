package pl.guimpl.bezpieczenstwo;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Bezpieczenstwo extends JavaPlugin {

    private ReportManager reportManager;
    private ModeratorManager moderatorManager;

    @Override
    public void onEnable() {
        // Inicjalizacja managerów
        reportManager = new ReportManager();
        moderatorManager = new ModeratorManager(this);

        // Załaduj zgłoszenia
        reportManager.loadReports(this);

        // Rejestracja komend
        getCommand("report").setExecutor(new CommandHandler(reportManager, moderatorManager));
        getCommand("reports").setExecutor(new CommandHandler(reportManager, moderatorManager));
        getCommand("resolve").setExecutor(new CommandHandler(reportManager, moderatorManager));

        // Rejestracja listenera zdarzeń
        getServer().getPluginManager().registerEvents(new ReportListener(reportManager), this);

        // Powiadomienie moderatorów o starcie pluginu
        moderatorManager.notifyModerators("Plugin Bezpieczenstwo został uruchomiony.");
    }

    @Override
    public void onDisable() {
        // Zapisz zgłoszenia
        try {
            reportManager.saveReports();
        } catch (IOException e) {
            getLogger().severe("Wystąpił błąd podczas zapisywania zgłoszeń: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

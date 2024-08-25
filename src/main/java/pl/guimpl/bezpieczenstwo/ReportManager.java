package pl.guimpl.bezpieczenstwo;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReportManager {

    private List<Report> reports = new ArrayList<>();
    private File reportFile;
    private FileConfiguration reportConfig;

    public void createReport(Player player, String reason) {
        reports.add(new Report(player.getUniqueId(), reason, null));
    }

    public void listReports(CommandSender sender) {
        if (reports.isEmpty()) {
            sender.sendMessage("§aBrak zgłoszeń.");
            return;
        }
        sender.sendMessage("§aLista zgłoszeń:");
        for (int i = 0; i < reports.size(); i++) {
            Report report = reports.get(i);
            sender.sendMessage("§7[" + (i + 1) + "] §6" + report.getReason() + " §7od §e" + report.getPlayerName() +
                    (report.getResolvedBy() != null ? " §7(rozwiązane przez: §e" + report.getResolvedBy() + "§7)" : ""));
        }
    }

    public boolean resolveReport(int reportId, Player resolver) {
        if (reportId >= 0 && reportId < reports.size()) {
            Report report = reports.get(reportId);
            report.setResolvedBy(resolver.getName());
            try {
                saveReports();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public void loadReports(Bezpieczenstwo plugin) {
        reportFile = new File(plugin.getDataFolder(), "reports.yml");
        if (!reportFile.exists()) {
            try {
                // Tworzenie pliku z domyślną zawartością
                if (plugin.getDataFolder().mkdirs() || plugin.getDataFolder().exists()) {
                    reportFile.createNewFile();
                    reportConfig = YamlConfiguration.loadConfiguration(reportFile);
                    // Inicjalizacja pustej listy zgłoszeń
                    reportConfig.set("reports", new ArrayList<>());
                    reportConfig.save(reportFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reportConfig = YamlConfiguration.loadConfiguration(reportFile);

        List<String> reportList = reportConfig.getStringList("reports");
        for (String reportData : reportList) {
            String[] parts = reportData.split(";");
            UUID playerUUID = UUID.fromString(parts[0]);
            String reason = parts[1];
            String resolvedBy = parts.length > 2 ? parts[2] : null;
            reports.add(new Report(playerUUID, reason, resolvedBy));
        }
    }

    public void saveReports() throws IOException {
        List<String> reportList = new ArrayList<>();
        for (Report report : reports) {
            String reportData = report.getPlayerUUID() + ";" + report.getReason() +
                    (report.getResolvedBy() != null ? ";" + report.getResolvedBy() : "");
            reportList.add(reportData);
        }
        reportConfig.set("reports", reportList);
        reportConfig.save(reportFile);
    }
}

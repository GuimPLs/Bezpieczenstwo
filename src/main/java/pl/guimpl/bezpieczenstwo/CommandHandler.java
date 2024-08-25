package pl.guimpl.bezpieczenstwo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

    private final ReportManager reportManager;
    private final ModeratorManager moderatorManager;

    public CommandHandler(ReportManager reportManager, ModeratorManager moderatorManager) {
        this.reportManager = reportManager;
        this.moderatorManager = moderatorManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (label.equalsIgnoreCase("report")) {
                if (sender instanceof Player) {
                    if (args.length < 1) {
                        sender.sendMessage("§cMusisz podać powód zgłoszenia!");
                        return false;
                    }
                    Player player = (Player) sender;
                    String reason = String.join(" ", args);
                    reportManager.createReport(player, reason);
                    player.sendMessage("§aTwoje zgłoszenie zostało przyjęte!");
                    moderatorManager.notifyModerators("§e" + player.getName() + " zgłosił problem: " + reason);
                } else {
                    sender.sendMessage("§cTylko gracze mogą składać zgłoszenia!");
                }
                return true;
            } else if (label.equalsIgnoreCase("reports")) {
                if (sender.hasPermission("bezpieczenstwo.viewreports")) {
                    reportManager.listReports(sender);
                } else {
                    sender.sendMessage("§cNie masz uprawnień do przeglądania zgłoszeń!");
                }
                return true;
            } else if (label.equalsIgnoreCase("resolve")) {
                if (sender instanceof Player) {
                    if (args.length < 1) {
                        sender.sendMessage("§cMusisz podać numer zgłoszenia do rozwiązania!");
                        return false;
                    }
                    int reportId;
                    try {
                        reportId = Integer.parseInt(args[0]) - 1;
                    } catch (NumberFormatException e) {
                        sender.sendMessage("§cNiepoprawny numer zgłoszenia!");
                        return false;
                    }
                    if (reportManager.resolveReport(reportId, (Player) sender)) {
                        sender.sendMessage("§aZgłoszenie zostało oznaczone jako rozwiązane!");
                    } else {
                        sender.sendMessage("§cNie znaleziono zgłoszenia o podanym numerze!");
                    }
                } else {
                    sender.sendMessage("§cTylko gracze mogą rozwiązywać zgłoszenia!");
                }
                return true;
            }
        } catch (Exception e) {
            sender.sendMessage("§cWystąpił błąd podczas przetwarzania komendy. Sprawdź logi serwera.");
            e.printStackTrace(); // Zapisz stack trace do logów serwera
        }
        return false;
    }
}
